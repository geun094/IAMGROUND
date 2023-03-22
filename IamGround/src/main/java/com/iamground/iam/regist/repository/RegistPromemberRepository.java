package com.iamground.iam.regist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iamground.iam.entity.Promember;

public interface RegistPromemberRepository extends JpaRepository<Promember, String> {

	/* 전문가회원 - 아이디 중복확인 */
	public Promember findByPromemId(String promemId);
	
	/* 전문가회원 - 이메일 중복확인 */
	public Promember findByPromemEmail(String promemEmail);
	
	/* 전문가회원 - 닉네임 중복확인 */
	public Promember findByPromemNickname(String promemNickname);
	
}