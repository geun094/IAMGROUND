package com.iamground.iam.common.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.iamground.iam.entity.Member;
import com.iamground.iam.member.DTO.MemberDTO;
import com.iamground.iam.member.DTO.UserImpl;
import com.iamground.iam.member.service.MemberService;
import com.iamground.iam.repository.MemberRepository;

@Service
public class CommonService  {

	private final MemberRepository memberRepository;
	
	
	@Autowired
	public CommonService (MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}	

	public String findId(String memName, String memPhone ){
		String memId = memberRepository.findId(memName,memPhone);
						
		//return modelMapper.map(member, MemberDTO.class);
		return memId;
	}
	
	
	public String findPwd(String memId, String memName) {
		String memPwd = memberRepository.findPwd(memId,memName);
		
		return memPwd;
		
	}
	
	@Transactional
	public int updatePwd(String memPwd, String memId, String memName) {
		int upPwd = memberRepository.updatePwd(memPwd, memId, memName);
		
		return upPwd;
		
	}
	
 
	
	
	 
}
