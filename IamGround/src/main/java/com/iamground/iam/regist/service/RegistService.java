package com.iamground.iam.regist.service;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iamground.iam.entity.License;
import com.iamground.iam.entity.Member;
import com.iamground.iam.entity.MemberRole;
import com.iamground.iam.entity.Profile;
import com.iamground.iam.entity.Promember;
import com.iamground.iam.member.DTO.LicenseDTO;
import com.iamground.iam.member.DTO.MemberDTO;
import com.iamground.iam.member.DTO.MemberRoleDTO;
import com.iamground.iam.member.DTO.ProfileDTO;
import com.iamground.iam.member.DTO.PromemberDTO;
import com.iamground.iam.regist.repository.LicenseFileRepository;
import com.iamground.iam.regist.repository.ProfileFileRepository;
import com.iamground.iam.regist.repository.RegistAuthorityRepository;
import com.iamground.iam.regist.repository.RegistMemberRepository;
import com.iamground.iam.regist.repository.RegistPromemberRepository;

@Service
public class RegistService {
	
	private final RegistMemberRepository registMemberRepository;
	private final RegistPromemberRepository registPromemberRepository;
	private final ProfileFileRepository profileFileRepository;
	private final LicenseFileRepository licenseFileRepository;
	private final RegistAuthorityRepository registAuthorityRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	private final ModelMapper modelMapper;
	
	@Autowired
	public RegistService(RegistMemberRepository registMemberRepository, RegistPromemberRepository registPromemberRepository, ProfileFileRepository profileFileRepository, LicenseFileRepository licenseFileRepository, RegistAuthorityRepository registAuthorityRepository, BCryptPasswordEncoder bCryptPasswordEncoder, ModelMapper modelMapper) {
		this.registMemberRepository = registMemberRepository;
		this.registPromemberRepository = registPromemberRepository;
		this.profileFileRepository = profileFileRepository;
		this.licenseFileRepository = licenseFileRepository;
		this.registAuthorityRepository = registAuthorityRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		this.modelMapper = modelMapper;
	}
	

	/* 회원가입-일반 페이지 */
	@Transactional
	public void registNewMember(MemberDTO newMember) {
		String rawPwd = newMember.getMemPwd();
		String encPwd = bCryptPasswordEncoder.encode(rawPwd);
		newMember.setMemPwd(encPwd);
		
		Member tempMember = registMemberRepository.save(modelMapper.map(newMember, Member.class));
		// 권한 테이블의 데이터 삽입 
		MemberRoleDTO memberRole = new MemberRoleDTO();
		
		memberRole.setAuthorityCode(3);
		memberRole.setMemNo(tempMember.getMemNo());
		
		registAuthorityRepository.save(modelMapper.map(memberRole, MemberRole.class));
	}
	
	/* 일반회원 - 아이디 중복확인 */
	@Transactional
	public int registCheckMemId(String memId) {
		System.out.println("아이디 중복 확인 service - memId : " + memId);
		Member checkMemId = registMemberRepository.findByMemId(memId);
		
		if(checkMemId != null) {			// 일반회원 테이블에서 조회된 id가 있을 경우 			
			System.out.println("조회된 아이디 : " + checkMemId.getMemId());
			return 1;
		} else {							// 일반회원 테이블에서 조회된 id가 없을 경우 		
			Promember checkPromemId = registPromemberRepository.findByPromemId(memId);
			if(checkPromemId != null) {		// 전문가회원 테이블에서 조회된 id가 있을 경우
				return 1;
			} else {						// 전문가회원 테이블에서 조회된 id가 있을 경우
				return 0;
			}
		}
	}
	
	/* 일반회원 - 이메일 중복확인 */
	@Transactional
	public int registCheckMemEmail(String memEmail) {
		System.out.println("이메일 중복 확인 service - memEmail : " + memEmail);
		Member checkMemEmail = registMemberRepository.findByMemEmail(memEmail);
		
		if(checkMemEmail != null) {
			System.out.println("조회된 이메일 : " + checkMemEmail.getMemEmail());
			return 1;
		} else {
			Promember checkPromemEmail = registPromemberRepository.findByPromemEmail(memEmail);
			if(checkPromemEmail != null) {
				return 1;
			} else {
				return 0;
			}
		}
	}
	
	/* 일반회원 - 닉네임 중복확인 */
	@Transactional
	public int registCheckMemNickname(String memNickname) {
		System.out.println("닉네임 중복 확인 service - memNickname : " + memNickname);
		Member checkMemNickname = registMemberRepository.findByMemNickname(memNickname);
		
		if(checkMemNickname != null) {
			System.out.println("조회된 닉네임 : " + checkMemNickname.getMemNickname());
			return 1;
		} else {
			Promember checkPromemNickname = registPromemberRepository.findByPromemNickname(memNickname);
			if(checkPromemNickname != null) {
				return 1;
			} else {
				return 0;
			}
		}
	}
	
	/* 회원가입-전문가 페이지 */
	@Transactional
	public void registNewPromember(PromemberDTO newPromember) {
		
		/* 비밀번호 암호화 */
		String rawProPwd = newPromember.getPromemPwd();
		String encProPwd = bCryptPasswordEncoder.encode(rawProPwd);
		newPromember.setPromemPwd(encProPwd);
		
		/* 파일업로드 */
		/* 파일 - 프로필사진*/
		ProfileDTO newProfile = new ProfileDTO();
		
		MultipartFile profileFile = newPromember.getProfileFile();
		
		if(profileFile != null) {
			System.out.println(profileFile.getOriginalFilename());
			String profileFileName = profileFile.getOriginalFilename();
			// 파일 리네임
			String uuid1 = UUID.randomUUID().toString();
			// 확장자 추출
			String profileExtension = profileFileName.substring(profileFileName.lastIndexOf("."));
			String profileFileRename = uuid1 + profileExtension;
			newProfile.setProfileFileName(profileFileName);
			newProfile.setProfileFileRename(profileFileRename);
			
			try {
				profileFile.transferTo(new File(profileFileRename));
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
				new File(profileFileRename).delete();
			}
		}
		
		/* 파일 - 업체사진*/
		MultipartFile companyFile = newPromember.getCompanyFile();
		
		if(companyFile != null) {
			System.out.println(companyFile.getOriginalFilename());
			String companyFileName = companyFile.getOriginalFilename();
			// 확장자 추출
			String uuid2 = UUID.randomUUID().toString();
			String companyExtension = companyFileName.substring(companyFileName.lastIndexOf("."));
			String companyFileRename = uuid2 + companyExtension;
			newProfile.setCompanyFileName(companyFileName);
			newProfile.setCompanyFileRename(companyFileRename);
			
			try {
				companyFile.transferTo(new File(companyFileRename));
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
				new File(companyFileRename).delete();
			}
		}
		
		/* 파일 - 면허증사진*/
		LicenseDTO newLicense = new LicenseDTO();
		
		MultipartFile licenseFile = newPromember.getLicenseFile();
		
		if(licenseFile != null) { 
			System.out.println(licenseFile.getOriginalFilename());
			String licenseFileName = licenseFile.getOriginalFilename();
			// 확장자 추출
			String uuid3 = UUID.randomUUID().toString();
			String licenseExtension = licenseFileName.substring(licenseFileName.lastIndexOf("."));
			String licenseFileRename = uuid3 + licenseExtension;
			newLicense.setLicenseFileName(licenseFileName);
			newLicense.setLicenseFileRename(licenseFileRename);
			
			try {
				licenseFile.transferTo(new File(licenseFileRename));
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
				new File(licenseFileRename).delete();
			}
		}
		
		/* 파일 - 사업자등록증*/
		MultipartFile businessRegFile = newPromember.getBusinessRegFile();
		
		if(businessRegFile != null) {
			System.out.println(businessRegFile.getOriginalFilename());
			String businessRegFileName = businessRegFile.getOriginalFilename();
			// 확장자 추출
			String uuid4 = UUID.randomUUID().toString();
			String businessExtension = businessRegFileName.substring(businessRegFileName.lastIndexOf("."));
			String businessRegFileRename = uuid4 + businessExtension;
			newPromember.setBusinessRegFileName(businessRegFileName);
			newPromember.setBusinessRegFileRename(businessRegFileRename);
		
			try {
				businessRegFile.transferTo(new File(businessRegFileRename));
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
				new File(businessRegFileRename).delete();
			}
		}
		
		Promember promemOrigin = new Promember(); 
		
	
		BeanUtils.copyProperties(newPromember, promemOrigin, "businessRegFile", "profileFile", "companyFile", "licenseFile");
		
		Promember resultPromem = registPromemberRepository.save(modelMapper.map(promemOrigin, Promember.class ));
		
		System.out.println("resultPromem의 전문가 회원번호 :" + resultPromem.getPromemNo());
		// promemNo 값 입력 
		newProfile.setPromemNo(resultPromem.getPromemNo());
		newLicense.setPromemNo(resultPromem.getPromemNo());
		
		profileFileRepository.save(modelMapper.map(newProfile, Profile.class));
		licenseFileRepository.save(modelMapper.map(newLicense, License.class));
		
		// 권한 테이블의 데이터 삽입 
		MemberRoleDTO memberRole = new MemberRoleDTO();
		
		memberRole.setAuthorityCode(3);
		memberRole.setPromemNo(resultPromem.getPromemNo());
		
		System.out.println("memberRole의 promemNo" + memberRole.getPromemNo());
		registAuthorityRepository.save(modelMapper.map(memberRole, MemberRole.class));
		
		
	}

	/* 전문가회원 - 아이디 중복확인 */
	@Transactional
	public int registCheckPromemId(String promemId) {
		System.out.println("아이디 중복 확인 service - promemId : " + promemId);
		Promember checkPromemId = registPromemberRepository.findByPromemId(promemId);
		
		if(checkPromemId != null) {
			System.out.println("조회된 아이디 : " + checkPromemId.getPromemId());
			return 1;
		} else {
			Member checkMemId = registMemberRepository.findByMemId(promemId);
			if(checkMemId != null) {
				return 1;
			} else {
				return 0;
			}
		}
	}
	
	/* 전문가회원 - 이메일 중복확인 */
	@Transactional
	public int registCheckPromemEmail(String promemEmail) {
		System.out.println("이메일 중복 확인 service - promemEmail : " + promemEmail);
		Promember checkPromemEmail = registPromemberRepository.findByPromemEmail(promemEmail);
		
		if(checkPromemEmail != null) {
			System.out.println("조회된 이메일 : " + checkPromemEmail.getPromemEmail());
			return 1;
		} else {
			Member checkMemEmail = registMemberRepository.findByMemEmail(promemEmail);
			if(checkMemEmail != null) {
				return 1;
			} else {
				return 0;
			}
		}
	}
	
	/* 전문가회원 - 닉네임 중복확인 */
	@Transactional
	public int registCheckPromemNickname(String promemNickname) {
		System.out.println("닉네임 중복 확인 service - memNickname : " + promemNickname);
		Promember checkPromemNickname = registPromemberRepository.findByPromemNickname(promemNickname);
		
		if(checkPromemNickname != null) {
			System.out.println("조회된 닉네임 : " + checkPromemNickname.getPromemNickname());
			return 1;
		} else {
			Member checkMemNickname = registMemberRepository.findByMemNickname(promemNickname);
			if(checkMemNickname != null) {
				return 1;
			} else {
				return 0;
			}
		}
	}

	


	
}