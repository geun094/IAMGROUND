package com.iamground.iam.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="TBL_MEMBER_ROLE")
public class MemberRoleAndAuthority {

	@Id
	@Column(name="MEM_NO")
	private int memNo;
	
	@ManyToOne
	@JoinColumn(name="AUTHORITY_CODE")
	private Authority authorityCode;
	
	public MemberRoleAndAuthority() {}

	public MemberRoleAndAuthority(int memNo, Authority authorityCode) {
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

	public Authority getAuthorityCode() {
		return authorityCode;
	}

	public void setAuthorityCode(Authority authorityCode) {
		this.authorityCode = authorityCode;
	}

	@Override
	public String toString() {
		return "MemberRoleAndAuthority [memNo=" + memNo + ", authorityCode=" + authorityCode + "]";
	}
}
