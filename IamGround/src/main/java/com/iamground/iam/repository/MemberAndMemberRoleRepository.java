package com.iamground.iam.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.iamground.iam.entity.MemberAndMemberRole;
import com.iamground.iam.entity.PromemberAndMemberRole;
import com.iamground.iam.member.DTO.MemberAndMemberRoleDTO;

public interface MemberAndMemberRoleRepository extends JpaRepository<MemberAndMemberRole, Integer> {
	
	int countByMemNameContaining(String searchValue);
	List<MemberAndMemberRole> findByMemNameContaining(String searchValue, Pageable paging);

	
	
	
}
