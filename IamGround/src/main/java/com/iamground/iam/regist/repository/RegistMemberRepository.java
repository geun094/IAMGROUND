package com.iamground.iam.regist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iamground.iam.entity.Member;

/* 아래에 있는 메소드들이 RegistMember와 관계있고 service에서 반환하는 값이 Member가 됨 */
public interface RegistMemberRepository extends JpaRepository<Member, String>{
	
	/* 일반회원 - 아이디 중복확인 */
	public Member findByMemId(String memId);
	
	/* 일반회원 - 이메일 중복확인 */
	public Member findByMemEmail(String memEmail);
	
	/* 일반회원 - 닉네임 중복확인 */
	public Member findByMemNickname(String memNickname);
	
	
	
	
}