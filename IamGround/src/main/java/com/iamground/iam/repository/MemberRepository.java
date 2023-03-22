package com.iamground.iam.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Repository;

import com.iamground.iam.entity.Authority;
import com.iamground.iam.entity.Member;

public interface MemberRepository extends JpaRepository<Member, String> {
	
	@Query(value ="SELECT \r\n"
	         + "        MEM_NO\r\n"
	         + "      , MEM_NAME\r\n"
	         + "      , MEM_GENDER\r\n"
	         + "      , MEM_PHONE\r\n"
	         + "      , MEM_EMAIL\r\n"
	         + "      , MEM_ADDRESS\r\n"
	         + "      , MEM_ID\r\n"
	         + "      , MEM_PWD\r\n"
	         + "      , MEM_NICKNAME\r\n"
	         + "      , MEM_CHG_PWD_DATETIME\r\n"
	         + "      , MEM_PWD_EXP_DATE\r\n"
	         + "      , MEM_REG_DATETIME\r\n"
	         + "      , MEM_INACTIVE_YN\r\n"
	         + "      , MEM_SECESSION_YN\r\n"
	         + "      , MEM_SECESSION_DATETIME\r\n"
	         + "       FROM TBL_MEMBER"
	         + "       WHERE MEM_ID = ?",nativeQuery = true)
	  public Member findMember(String id);
	
	 @Query(value ="SELECT \r\n"
	         + "    PROMEM_NO AS MEM_NO\r\n"
	         + "    , PROMEM_NAME AS MEM_NAME\r\n"
	         + "    , PROMEM_GENDER AS MEM_GENDER\r\n"
	         + "    , PROMEM_PHONE AS MEM_PHONE\r\n"
	         + "    , PROMEM_EMAIL AS MEM_EMAIL\r\n"
	         + "    , PROMEM_ADDRESS AS MEM_ADDRESS\r\n"
	         + "    , PROMEM_ID AS MEM_ID\r\n"
	         + "    , PROMEM_PWD AS MEM_PWD\r\n"
	         + "    , PROMEM_NICKNAME AS MEM_NICKNAME\r\n"
	         + "    , PROMEM_CHG_PWD_DATETIME AS MEM_CHG_PWD_DATETIME\r\n"
	         + "    , PROMEM_PWD_EXP_DATE AS MEM_PWD_EXP_DATE\r\n"
	         + "    , PROMEM_REG_DATETIME AS MEM_REG_DATETIME\r\n"
	         + "    , PROMEM_INACTIVE_YN AS MEM_INACTIVE_YN\r\n"
	         + "    , PROMEM_SECESSION_YN AS MEM_SECESSION_YN\r\n"
	         + "    , PROMEM_SECESSION_DATETIME AS MEM_SECESSION_DATETIME\r\n"
	         + "FROM TBL_PROMEMBER\r\n"
	         + "WHERE PROMEM_ID = ? ",nativeQuery = true)
	     public Member findProMember(String id);

	
	@Query(value ="SELECT\r\n"
			+ "       MEM_ID\r\n"
			+ "FROM   TBL_MEMBER\r\n"
			+ "WHERE  MEM_NAME = ?\r\n"
			+ " AND    REPLACE(MEM_PHONE, '-', '') = ? " ,nativeQuery = true)
	public String findId(String name, String phone);
	
	@Query(value = "SELECT\r\n"
			+ "    MEM_PWD\r\n"
			+ "  FROM TBL_MEMBER\r\n"
			+ " WHERE MEM_ID =?\r\n"
			+ " AND MEM_NAME = ? ", nativeQuery = true)
	public String findPwd(String id, String name);

	//JPA Entity Life-cycle을 무시하고 쿼리가 실행되는거를 무시 INSERT, UPDATE, DELETE (SELECT 제외) 
	@Modifying(clearAutomatically = true)
	@Query(value = "UPDATE TBL_MEMBER SET MEM_PWD=?\r\n"
			+ "            WHERE mem_ID= ?\r\n"
			+ "            and  mem_name= ?" , nativeQuery = true)
	public int updatePwd(String pwd, String id, String name);
	
	
	
	
}
