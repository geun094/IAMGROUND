package com.iamground.iam.regist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iamground.iam.entity.MemberRole;

public interface RegistAuthorityRepository extends JpaRepository <MemberRole, String> {
	public MemberRole save(MemberRole newMemberRole);
}