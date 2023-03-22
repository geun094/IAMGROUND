package com.iamground.iam.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.iamground.iam.entity.MemberAndMemberRole;
import com.iamground.iam.entity.PromemberAndMemberRole;
import com.iamground.iam.member.DTO.MemberAndMemberRoleDTO;

public interface PromemberAndMemberRoleRepository extends JpaRepository<PromemberAndMemberRole, Integer> {
	int countByPromemNameContaining(String searchValue);
	List<PromemberAndMemberRole> findByPromemNameContaining(String searchValue, Pageable paging);
	
	@Modifying(clearAutomatically = true)
    @Query(value = "UPDATE TBL_MEMBER_ROLE \r\n"
    		+ "SET AUTHORITY_CODE = '2'\r\n"
    		+ "WHERE PROMEM_NO = ?", nativeQuery = true)
    int updateByProMember(String promemNo);
		
	
}
