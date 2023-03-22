package com.iamground.iam.member.DTO;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.iamground.iam.entity.MemberRoleAndAuthority;
import com.iamground.iam.entity.PromemberRoleAndAuthority;

public class PromemberAndMemberRoleDTO {
	private int promemNo;
	private String promemName;	
	private String promemGender;
	private String promemPhone;
	private String promemEmail;
	private String promemAddress;
	private String promemId;
	private String promemPwd;
	private String promemNickname;
	private java.sql.Date promemChgPwdDatetime; 
	private java.sql.Date promemPwdExpDate;
	private java.sql.Date promemRegDatetime;
	private String promeminactiveYn; 
	private String prosecessionYn; 
	private java.sql.Date promemSecessionDatetime;
	private String authorityRequest; 
	private List<PromemberRoleAndAuthority> promemberRoleList;
	
	public PromemberAndMemberRoleDTO() {}

	public PromemberAndMemberRoleDTO(int promemNo, String promemName, String promemGender, String promemPhone,
			String promemEmail, String promemAddress, String promemId, String promemPwd, String promemNickname,
			Date promemChgPwdDatetime, Date promemPwdExpDate, Date promemRegDatetime, String promeminactiveYn,
			String prosecessionYn, Date promemSecessionDatetime, String authorityRequest,
			List<PromemberRoleAndAuthority> promemberRoleList) {
		super();
		this.promemNo = promemNo;
		this.promemName = promemName;
		this.promemGender = promemGender;
		this.promemPhone = promemPhone;
		this.promemEmail = promemEmail;
		this.promemAddress = promemAddress;
		this.promemId = promemId;
		this.promemPwd = promemPwd;
		this.promemNickname = promemNickname;
		this.promemChgPwdDatetime = promemChgPwdDatetime;
		this.promemPwdExpDate = promemPwdExpDate;
		this.promemRegDatetime = promemRegDatetime;
		this.promeminactiveYn = promeminactiveYn;
		this.prosecessionYn = prosecessionYn;
		this.promemSecessionDatetime = promemSecessionDatetime;
		this.authorityRequest = authorityRequest;
		this.promemberRoleList = promemberRoleList;
	}

	public int getPromemNo() {
		return promemNo;
	}

	public void setPromemNo(int promemNo) {
		this.promemNo = promemNo;
	}

	public String getPromemName() {
		return promemName;
	}

	public void setPromemName(String promemName) {
		this.promemName = promemName;
	}

	public String getPromemGender() {
		return promemGender;
	}

	public void setPromemGender(String promemGender) {
		this.promemGender = promemGender;
	}

	public String getPromemPhone() {
		return promemPhone;
	}

	public void setPromemPhone(String promemPhone) {
		this.promemPhone = promemPhone;
	}

	public String getPromemEmail() {
		return promemEmail;
	}

	public void setPromemEmail(String promemEmail) {
		this.promemEmail = promemEmail;
	}

	public String getPromemAddress() {
		return promemAddress;
	}

	public void setPromemAddress(String promemAddress) {
		this.promemAddress = promemAddress;
	}

	public String getPromemId() {
		return promemId;
	}

	public void setPromemId(String promemId) {
		this.promemId = promemId;
	}

	public String getPromemPwd() {
		return promemPwd;
	}

	public void setPromemPwd(String promemPwd) {
		this.promemPwd = promemPwd;
	}

	public String getPromemNickname() {
		return promemNickname;
	}

	public void setPromemNickname(String promemNickname) {
		this.promemNickname = promemNickname;
	}

	public java.sql.Date getPromemChgPwdDatetime() {
		return promemChgPwdDatetime;
	}

	public void setPromemChgPwdDatetime(java.sql.Date promemChgPwdDatetime) {
		this.promemChgPwdDatetime = promemChgPwdDatetime;
	}

	public java.sql.Date getPromemPwdExpDate() {
		return promemPwdExpDate;
	}

	public void setPromemPwdExpDate(java.sql.Date promemPwdExpDate) {
		this.promemPwdExpDate = promemPwdExpDate;
	}

	public java.sql.Date getPromemRegDatetime() {
		return promemRegDatetime;
	}

	public void setPromemRegDatetime(java.sql.Date promemRegDatetime) {
		this.promemRegDatetime = promemRegDatetime;
	}

	public String getPromeminactiveYn() {
		return promeminactiveYn;
	}

	public void setPromeminactiveYn(String promeminactiveYn) {
		this.promeminactiveYn = promeminactiveYn;
	}

	public String getProsecessionYn() {
		return prosecessionYn;
	}

	public void setProsecessionYn(String prosecessionYn) {
		this.prosecessionYn = prosecessionYn;
	}

	public java.sql.Date getPromemSecessionDatetime() {
		return promemSecessionDatetime;
	}

	public void setPromemSecessionDatetime(java.sql.Date promemSecessionDatetime) {
		this.promemSecessionDatetime = promemSecessionDatetime;
	}

	public String getAuthorityRequest() {
		return authorityRequest;
	}

	public void setAuthorityRequest(String authorityRequest) {
		this.authorityRequest = authorityRequest;
	}

	public List<PromemberRoleAndAuthority> getPromemberRoleList() {
		return promemberRoleList;
	}

	public void setPromemberRoleList(List<PromemberRoleAndAuthority> promemberRoleList) {
		this.promemberRoleList = promemberRoleList;
	}

	@Override
	public String toString() {
		return "PromemberAndMemberRoleDTO [promemNo=" + promemNo + ", promemName=" + promemName + ", promemGender="
				+ promemGender + ", promemPhone=" + promemPhone + ", promemEmail=" + promemEmail + ", promemAddress="
				+ promemAddress + ", promemId=" + promemId + ", promemPwd=" + promemPwd + ", promemNickname="
				+ promemNickname + ", promemChgPwdDatetime=" + promemChgPwdDatetime + ", promemPwdExpDate="
				+ promemPwdExpDate + ", promemRegDatetime=" + promemRegDatetime + ", promeminactiveYn="
				+ promeminactiveYn + ", prosecessionYn=" + prosecessionYn + ", promemSecessionDatetime="
				+ promemSecessionDatetime + ", authorityRequest=" + authorityRequest + ", promemberRoleList="
				+ promemberRoleList + "]";
	}

}
