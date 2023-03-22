package com.iamground.iam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.iamground.iam.entity.Member;
import com.iamground.iam.entity.MemberRole;

public interface MemberRoleRepository extends JpaRepository<MemberRole, Integer> {
	@Query(value = "SELECT\r\n"
			+ "               A.MEMBER_NO\r\n"
			+ "             , A.AUTHORITY_CODE\r\n"
			+ "          FROM TBL_MEMBER_ROLE A\r\n"
			+ "         WHERE A.MEMBER_NO = 1", nativeQuery = true)
	   public List<Member> findMemberRoleMemberNo();

}
