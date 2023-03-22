package com.iamground.iam.member.DTO;

import javax.persistence.Column;

public class AdminDTO {

	private String memNo;	
	private String memName;	
	private String memPhone;
	private String memEmail;
	private String authorityDesc;
	
	public AdminDTO() {}

	public AdminDTO(String memNo, String memName, String memPhone, String memEmail, String authorityDesc) {
		this.memNo = memNo;
		this.memName = memName;
		this.memPhone = memPhone;
		this.memEmail = memEmail;
		this.authorityDesc = authorityDesc;
	}

	public String getMemNo() {
		return memNo;
	}

	public void setMemNo(String memNo) {
		this.memNo = memNo;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public String getMemPhone() {
		return memPhone;
	}

	public void setMemPhone(String memPhone) {
		this.memPhone = memPhone;
	}

	public String getMemEmail() {
		return memEmail;
	}

	public void setMemEmail(String memEmail) {
		this.memEmail = memEmail;
	}

	public String getAuthorityDesc() {
		return authorityDesc;
	}

	public void setAuthorityDesc(String authorityDesc) {
		this.authorityDesc = authorityDesc;
	}

	@Override
	public String toString() {
		return "AdminDTO [memNo=" + memNo + ", memName=" + memName + ", memPhone=" + memPhone + ", memEmail=" + memEmail
				+ ", authorityDesc=" + authorityDesc + "]";
	}
	
	
}
