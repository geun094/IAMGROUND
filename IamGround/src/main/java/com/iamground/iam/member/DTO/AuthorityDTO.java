package com.iamground.iam.member.DTO;

public class AuthorityDTO {
	private int authorityCode;				// 권한코드
	private String authorityName;			// 권한명
	private String authorityDesc;			// 권한설명
	
	public AuthorityDTO() {
	}

	public AuthorityDTO(int authorityCode, String authorityName, String authorityDesc) {
		super();
		this.authorityCode = authorityCode;
		this.authorityName = authorityName;
		this.authorityDesc = authorityDesc;
	}

	public int getAuthorityCode() {
		return authorityCode;
	}

	public void setAuthorityCode(int authorityCode) {
		this.authorityCode = authorityCode;
	}

	public String getAuthorityName() {
		return authorityName;
	}

	public void setAuthorityName(String authorityName) {
		this.authorityName = authorityName;
	}

	public String getAuthorityDesc() {
		return authorityDesc;
	}

	public void setAuthorityDesc(String authorityDesc) {
		this.authorityDesc = authorityDesc;
	}

	@Override
	public String toString() {
		return "AuthorityDTO [authorityCode=" + authorityCode + ", authorityName=" + authorityName + ", authorityDesc="
				+ authorityDesc + "]";
	}
	
}
