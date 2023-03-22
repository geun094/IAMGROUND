package com.iamground.iam.mypage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iamground.iam.mypage.entity.MypageMem;

public interface MypageMemRepository extends JpaRepository<MypageMem, String> {
	
	public MypageMem findByMemId(String memId);
}