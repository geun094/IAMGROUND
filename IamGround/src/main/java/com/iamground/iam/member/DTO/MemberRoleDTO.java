package com.iamground.iam.member.DTO;

public class MemberRoleDTO {
	private int authorityCode;		// 권한코드 
	private int memNo;			// 회원번호
	private int promemNo;

	public MemberRoleDTO() {
	}

	public MemberRoleDTO(int authorityCode, int memNo, int promemNo) {
		this.authorityCode = authorityCode;
		this.memNo = memNo;
		this.promemNo = promemNo;
	}

	public int getAuthorityCode() {
		return authorityCode;
	}

	public void setAuthorityCode(int authorityCode) {
		this.authorityCode = authorityCode;
	}

	public int getMemNo() {
		return memNo;
	}

	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}

	public int getPromemNo() {
		return promemNo;
	}

	public void setPromemNo(int promemNo) {
		this.promemNo = promemNo;
	}

	@Override
	public String toString() {
		return "MemberRoleDTO [authorityCode=" + authorityCode + ", memNo=" + memNo + ", promemNo=" + promemNo + "]";
	}

	
}