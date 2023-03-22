package com.iamground.iam.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="TBL_PROMEMBER")
public class PromemberAndMemberRole {
	@Id
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "PROMEMBER_SEQ_GENERATOR"
	)
	@Column(name = "PROMEM_NO")
	private int promemNo;
	@Column(name="PROMEM_NAME")
	private String promemName;	
	@Column(name="PROMEM_GENDER")
	private String promemGender;
	@Column(name="PROMEM_PHONE")
	private String promemPhone;
	@Column(name="PROMEM_EMAIL")
	private String promemEmail;
	@Column(name="PROMEM_ADDRESS")
	private String promemAddress;
	@Column(name="PROMEM_ID")
	private String promemId;
	@Column(name="PROMEM_PWD")
	private String promemPwd;
	@Column(name="PROMEM_NICKNAME")
	private String promemNickname;
	@Column(name="PROMEM_CHG_PWD_DATETIME")
	private java.sql.Date promemChgPwdDatetime; 
	@Column(name="PROMEM_PWD_EXP_DATE")
	private java.sql.Date promemPwdExpDate;
	@Column(name="PROMEM_REG_DATETIME")
	private java.sql.Date promemRegDatetime;
	@Column(name="PROMEM_INACTIVE_YN")
	private String promeminactiveYn; 
	@Column(name="PROMEM_SECESSION_YN")
	private String prosecessionYn; 
	@Column(name="PROMEM_SECESSION_DATETIME")
	private java.sql.Date promemSecessionDatetime;
	@Column(name="AUTHORITY_REQUEST")
	private String authorityRequest; 
	
	
	@OneToMany
	@JoinColumn(name = "PROMEM_NO")
	private List<PromemberRoleAndAuthority> memberRoleList;

	public PromemberAndMemberRole() {}

	public PromemberAndMemberRole(int promemNo, String promemName, String promemGender, String promemPhone,
			String promemEmail, String promemAddress, String promemId, String promemPwd, String promemNickname,
			Date promemChgPwdDatetime, Date promemPwdExpDate, Date promemRegDatetime, String promeminactiveYn,
			String prosecessionYn, Date promemSecessionDatetime, String authorityRequest,
			List<PromemberRoleAndAuthority> memberRoleList) {
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
		this.memberRoleList = memberRoleList;
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

	public List<PromemberRoleAndAuthority> getMemberRoleList() {
		return memberRoleList;
	}

	public void setMemberRoleList(List<PromemberRoleAndAuthority> memberRoleList) {
		this.memberRoleList = memberRoleList;
	}

	@Override
	public String toString() {
		return "PromemberAndMemberRole [promemNo=" + promemNo + ", promemName=" + promemName + ", promemGender="
				+ promemGender + ", promemPhone=" + promemPhone + ", promemEmail=" + promemEmail + ", promemAddress="
				+ promemAddress + ", promemId=" + promemId + ", promemPwd=" + promemPwd + ", promemNickname="
				+ promemNickname + ", promemChgPwdDatetime=" + promemChgPwdDatetime + ", promemPwdExpDate="
				+ promemPwdExpDate + ", promemRegDatetime=" + promemRegDatetime + ", promeminactiveYn="
				+ promeminactiveYn + ", prosecessionYn=" + prosecessionYn + ", promemSecessionDatetime="
				+ promemSecessionDatetime + ", authorityRequest=" + authorityRequest + ", memberRoleList="
				+ memberRoleList + "]";
	}

	
	

	
	
	
}
