package com.iamground.iam.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name="MemberRole")
@Table(name="TBL_MEMBER_ROLE")

public class MemberRole {
	

	@Id
	@Column(name="MEM_NO")
	private int memNo;
	
	@Column(name="AUTHORITY_CODE")
	private int authorityCode;
	
	public MemberRole() {}

	public MemberRole(int memNo, int authorityCode) {
		super();
		this.memNo = memNo;
		this.authorityCode = authorityCode;
	}

	public int getMemNo() {
		return memNo;
	}

	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}

	public int getAuthorityCode() {
		return authorityCode;
	}

	public void setAuthorityCode(int authorityCode) {
		this.authorityCode = authorityCode;
	}

	@Override
	public String toString() {
		return "MemberRole [memNo=" + memNo + ", authorityCode=" + authorityCode + "]";
	}
	
}

