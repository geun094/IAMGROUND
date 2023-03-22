package com.iamground.iam.member.DTO;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.iamground.iam.entity.Authority;

public class MemberRoleAndAuthorityDTO {
	private int memNo;
	private Authority authorityCode;
	public MemberRoleAndAuthorityDTO() {
	}
	public MemberRoleAndAuthorityDTO(int memNo, Authority authorityCode) {
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
		return "MemberRoleAndAuthorityDTO [memNo=" + memNo + ", authorityCode=" + authorityCode + "]";
	}
	
}
