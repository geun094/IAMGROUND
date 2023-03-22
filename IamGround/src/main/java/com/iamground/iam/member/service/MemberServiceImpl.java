package com.iamground.iam.member.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.iamground.iam.entity.Authority;
import com.iamground.iam.entity.Member;
import com.iamground.iam.member.DTO.MemberDTO;
import com.iamground.iam.member.DTO.UserImpl;
import com.iamground.iam.repository.AuthorityRepository;
import com.iamground.iam.repository.MemberRepository;
import com.iamground.iam.repository.MemberRoleRepository;


@Service
public class MemberServiceImpl implements MemberService{

   private final MemberRepository memberRepository;
   private final MemberRoleRepository memberRoleRepository;
   private final AuthorityRepository authorityRepository;
   private final ModelMapper modelMapper;

   @Autowired
   public MemberServiceImpl(MemberRepository memberRepository, 
                      MemberRoleRepository memberRoleRepository,
                      AuthorityRepository authorityRepository,
                      ModelMapper modelMapper) {
      this.memberRepository = memberRepository;
      this.memberRoleRepository = memberRoleRepository;
      this.authorityRepository = authorityRepository;
      this.modelMapper = modelMapper;
   }
         
   public UserDetails loadUserByUsername(String memId) throws UsernameNotFoundException {
	   System.out.println("넘어온 회원 아이디: " + memId);
      String mem[] = memId.split(",");
      String mId = mem[0];
      String mChk = mem[1];
      
      Member member = new Member();
      
      if(mChk.equals("Y")) {
         member = memberRepository.findProMember(mId);
      }else {
         member = memberRepository.findMember(mId);
      }
      
      System.out.println("조회하는 회원 번호: " + member.getMemNo());
      
      Authority memberAuth = mChk.equals("Y") ? authorityRepository.findPromemberAuth(member.getMemNo())
    		  : authorityRepository.findMemberAuth(member.getMemNo());
      
      System.out.println("가져온 권한: " + memberAuth);
      List<GrantedAuthority> authorities = new ArrayList<>();
      MemberDTO memDTO = modelMapper.map(member,MemberDTO.class);
      if(!memberAuth.getAuthorityName().isEmpty()) {
         authorities.add(new SimpleGrantedAuthority(memberAuth.getAuthorityName()));
      }
      UserImpl user = new UserImpl(member.getMemId(), member.getMemPwd(), authorities);
      user.setDetails(memDTO);
      
      return user;

   }
   
}






