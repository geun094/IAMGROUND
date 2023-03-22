package com.iamground.iam.mypage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iamground.iam.mypage.entity.MypagePromemAndProfile;

public interface MypagePromemRepository extends JpaRepository<MypagePromemAndProfile, String> {
	
	public MypagePromemAndProfile findByPromemId(String promemId);
	
	
}