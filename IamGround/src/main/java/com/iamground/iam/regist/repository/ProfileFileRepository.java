package com.iamground.iam.regist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iamground.iam.entity.Profile;


public interface ProfileFileRepository extends JpaRepository<Profile, String>{

	public Profile save(Profile newProfile);
}