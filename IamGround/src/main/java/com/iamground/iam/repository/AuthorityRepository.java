package com.iamground.iam.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.iamground.iam.entity.Authority;
import com.iamground.iam.entity.MemberRole;
import com.iamground.iam.member.DTO.MemberRoleDTO;


public interface AuthorityRepository extends JpaRepository<Authority, Integer> {
	@Query(value ="SELECT \r\n"
			+ "		    A.AUTHORITY_CODE\r\n"
			+ "		    , A.AUTHORITY_NAME\r\n"
			+ "		    , A.AUTHORITY_DESC\r\n"
			+ "		FROM TBL_AUTHORITY A, TBL_MEMBER_ROLE B\r\n"
			+ "		WHERE A.AUTHORITY_CODE = B.AUTHORITY_CODE\r\n"
			+ "		AND B.MEM_NO = ? " ,nativeQuery = true)
	public Authority findMemberAuth(int authority);
	
	@Query(value ="SELECT \r\n"
			+ "		    A.AUTHORITY_CODE\r\n"
			+ "		    , A.AUTHORITY_NAME\r\n"
			+ "		    , A.AUTHORITY_DESC\r\n"
			+ "		FROM TBL_AUTHORITY A, TBL_MEMBER_ROLE B\r\n"
			+ "		WHERE A.AUTHORITY_CODE = B.AUTHORITY_CODE\r\n"
			+ "		AND B.PROMEM_NO = ? " ,nativeQuery = true)
	public Authority findPromemberAuth(int authority);
}
