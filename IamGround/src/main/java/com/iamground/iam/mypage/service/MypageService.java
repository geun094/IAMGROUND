package com.iamground.iam.mypage.service;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.UUID;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iamground.iam.entity.Member;
import com.iamground.iam.entity.Profile;
import com.iamground.iam.entity.Promember;
import com.iamground.iam.member.DTO.ProfileDTO;
import com.iamground.iam.mypage.DTO.MypageMemDTO;
import com.iamground.iam.mypage.DTO.MypagePromemDTO;
import com.iamground.iam.mypage.entity.MypageMem;
import com.iamground.iam.mypage.entity.MypagePromem;
import com.iamground.iam.mypage.entity.MypagePromemAndProfile;
import com.iamground.iam.mypage.repository.MypageMemRepository;
import com.iamground.iam.mypage.repository.MypagePromemRepository;
import com.iamground.iam.regist.repository.ProfileFileRepository;

@Service
public class MypageService {
	private final MypagePromemRepository mypagePromemRepository;
	private final MypageMemRepository mypageMemRepository;
	private final ProfileFileRepository profileFileRepository;
	
	private final ModelMapper modelMapper;
	
	@Autowired
	public MypageService(MypagePromemRepository mypagePromemRepository, MypageMemRepository mypageMemRepository, ProfileFileRepository profileFileRepository, ModelMapper modelMapper) {
		this.mypagePromemRepository = mypagePromemRepository;
		this.mypageMemRepository = mypageMemRepository;
		this.profileFileRepository = profileFileRepository;
		this.modelMapper = modelMapper;
	}
	
	/* 마이페이지 일반회원 */
	@Transactional
	public MypageMem mypageMem(String memId) {
		
		return mypageMemRepository.findByMemId(memId);
	}
	
	/* 마이페이지 전문가회원(승인 전) */
	@Transactional
	public MypagePromemAndProfile mypagePromemBefore(String promemId) {

		return mypagePromemRepository.findByPromemId(promemId);
	}
	
	/* 마이페이지 전문가회원(승인 후) */
	@Transactional
	public MypagePromemAndProfile mypagePromemAfter(String promemId) {

		return mypagePromemRepository.findByPromemId(promemId);
	}
	
	/* 마이페이지 일반회원 수정 */
	@Transactional
	public void memUpdate(MypageMemDTO memUpdate, Principal principal) {
		MypageMem tempMem =  mypageMemRepository.findByMemId(principal.getName());
		
		memUpdate.setMemNo(tempMem.getMemNo());
		
		mypageMemRepository.save(modelMapper.map(memUpdate, MypageMem.class));
	}
	
	/* 마이페이지 전문가회원 수정 */
	@Transactional
	public void promemUpdate(MypagePromemDTO promemUpdate) {
		
		// 파일 업로드 
	
		ProfileDTO updateProfile = new ProfileDTO();
		
		MultipartFile profileFile = promemUpdate.getProfileFile();
		System.out.println(profileFile.getOriginalFilename());
		String profileFileName = profileFile.getOriginalFilename();
		// 파일 리네임
		String uuid1 = UUID.randomUUID().toString();
		// 확장자 추출
		String profileExtension = profileFileName.substring(profileFileName.lastIndexOf("."));
		String profileFileRename = uuid1 + profileExtension;
		updateProfile.setProfileFileName(profileFileName);
		updateProfile.setProfileFileRename(profileFileRename);
		
		try {
			profileFile.transferTo(new File(profileFileRename));
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
			new File(profileFileRename).delete();
		}
		
		/* 파일 - 업체사진*/
		MultipartFile companyFile = promemUpdate.getCompanyFile();
		System.out.println(companyFile.getOriginalFilename());
		String companyFileName = companyFile.getOriginalFilename();
		// 확장자 추출
		String uuid2 = UUID.randomUUID().toString();
		String companyExtension = companyFileName.substring(companyFileName.lastIndexOf("."));
		String companyFileRename = uuid2 + companyExtension;
		updateProfile.setCompanyFileName(companyFileName);
		updateProfile.setCompanyFileRename(companyFileRename);
		
		try {
			companyFile.transferTo(new File(companyFileRename));
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
			new File(companyFileRename).delete();
		}
		
		MypagePromemAndProfile resultPromem = mypagePromemRepository.findByPromemId(promemUpdate.getPromemId());
		
		MypagePromem promemOrigin = new MypagePromem(); 
		
		
		BeanUtils.copyProperties(promemUpdate, promemOrigin, "businessRegFile", "profileFile", "companyFile", "licenseFile");
		
		promemOrigin.setPromemNo(resultPromem.getPromemNo());
		
		/* 전문가 회원번호 입력 */
		updateProfile.setPromemNo(resultPromem.getPromemNo());
		
		profileFileRepository.save(modelMapper.map(updateProfile, Profile.class));
		
		mypagePromemRepository.save(modelMapper.map(promemOrigin, MypagePromemAndProfile.class));
	}
	
	@Transactional
	public int mypageCheckMemId(String memId) {
		System.out.println("아이디 중복 확인 service - memId : " + memId);
		MypageMem checkMemId = mypageMemRepository.findByMemId(memId);
		if(checkMemId != null) {			// 일반회원 테이블에서 조회된 id가 있을 경우 			
			System.out.println("조회된 아이디 : " + checkMemId.getMemId());
			return 1;
		} else {
			MypagePromemAndProfile checkAuthorityRequest = mypagePromemRepository.findByPromemId(memId);
			if("Y".equals(checkAuthorityRequest.getAuthorityRequest())) {
				return 2;		// 승인 요청 여부 Y일 경우
			} else {
				return 3;
			}
		}
		
	}
	
	

}