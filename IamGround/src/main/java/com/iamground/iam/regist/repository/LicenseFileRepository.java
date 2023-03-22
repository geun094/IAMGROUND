package com.iamground.iam.regist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iamground.iam.entity.License;

public interface LicenseFileRepository extends JpaRepository<License, String> {


}