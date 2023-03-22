package com.iamground.iam.member.DTO;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.iamground.iam.entity.Authority;

public class PromemberRoleAndAuthorityDTO {
	private int promemNo;
	private Authority authorityCode;
	public PromemberRoleAndAuthorityDTO() {
	}
	public PromemberRoleAndAuthorityDTO(int promemNo, Authority authorityCode) {
		this.promemNo = promemNo;
		this.authorityCode = authorityCode;
	}
	public int getMemNo() {
		return promemNo;
	}
	public void setMemNo(int promemNo) {
		this.promemNo = promemNo;
	}
	public Authority getAuthorityCode() {
		return authorityCode;
	}
	public void setAuthorityCode(Authority authorityCode) {
		this.authorityCode = authorityCode;
	}
	@Override
	public String toString() {
		return "MemberRoleAndAuthorityDTO [memNo=" + promemNo + ", authorityCode=" + authorityCode + "]";
	}
	
}
