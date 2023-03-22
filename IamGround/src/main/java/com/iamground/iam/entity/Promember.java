package com.iamground.iam.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name="Promember")
@Table(name="TBL_PROMEMBER")
@SequenceGenerator(name = "PROMEMBER_SEQ_GENERATOR",
				   sequenceName = "SEQ_PROMEM_NO",		// 매핑할 DB 시퀀스 이름(기본키)
				   initialValue = 1,
				   allocationSize = 1
)

public class Promember {
	@Id
	@GeneratedValue(
		strategy = GenerationType.SEQUENCE,
		generator = "PROMEMBER_SEQ_GENERATOR"
	)
	@Column(name = "PROMEM_NO")
	private int promemNo;
	@Column(name = "PROMEM_NAME")
	private String promemName;
	@Column(name = "PROMEM_GENDER")		// 최대값 5로 설정
	private String promemGender;
	@Column(name = "PROMEM_PHONE")
	private String promemPhone;
	@Column(name = "PROMEM_EMAIL")
	private String promemEmail;
	@Column(name = "PROMEM_ADDRESS")
	private String promemAddress;
	@Column(name = "PROMEM_ID")
	private String promemId;
	@Column(name = "PROMEM_PWD")
	private String promemPwd;
	@Column(name = "PROMEM_NICKNAME")
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
	private String promemSecessionYn; 
	@Column(name="PROMEM_SECESSION_DATETIME")
	private java.sql.Date promemSecessionDatetime;
	@Column(name="TOTAL_COMMENT")
	private Integer totalComment;
	@Column(name="TOTAL_LIKE_NO")
	private Integer totalLikeNo;
	@Column(name = "BUSINESS_REG_NUM")
	private String businessRegNum;
	@Column(name = "BUSINESS_REG_FILE_NAME")
	private String businessRegFileName;
	@Column(name = "BUSINESS_REG_FILE_RENAME")
	private String businessRegFileRename;
	@Column(name = "COMPANY_NAME")
	private String companyName;
	@Column(name = "COMPANY_PHONE")
	private String companyPhone;
	@Column(name = "COMPANY_TIME")
	private String companyTime;
	@Column(name = "COMPANY_ADDRESS")
	private String companyAddress;
	@Column(name = "AUTHORITY_REQUEST")
	private String authorityRequest;
	
	public Promember() {
		super();
	}

	public Promember(int promemNo, String promemName, String promemGender, String promemPhone, String promemEmail,
			String promemAddress, String promemId, String promemPwd, String promemNickname, Date promemChgPwdDatetime,
			Date promemPwdExpDate, Date promemRegDatetime, String promeminactiveYn, String promemSecessionYn,
			Date promemSecessionDatetime, Integer totalComment, Integer totalLikeNo, String businessRegNum,
			String businessRegFileName, String businessRegFileRename, String companyName, String companyPhone,
			String companyTime, String companyAddress, String authorityRequest) {
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
		this.promemSecessionYn = promemSecessionYn;
		this.promemSecessionDatetime = promemSecessionDatetime;
		this.totalComment = totalComment;
		this.totalLikeNo = totalLikeNo;
		this.businessRegNum = businessRegNum;
		this.businessRegFileName = businessRegFileName;
		this.businessRegFileRename = businessRegFileRename;
		this.companyName = companyName;
		this.companyPhone = companyPhone;
		this.companyTime = companyTime;
		this.companyAddress = companyAddress;
		this.authorityRequest = authorityRequest;
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

	public String getPromemSecessionYn() {
		return promemSecessionYn;
	}

	public void setPromemSecessionYn(String promemSecessionYn) {
		this.promemSecessionYn = promemSecessionYn;
	}

	public java.sql.Date getPromemSecessionDatetime() {
		return promemSecessionDatetime;
	}

	public void setPromemSecessionDatetime(java.sql.Date promemSecessionDatetime) {
		this.promemSecessionDatetime = promemSecessionDatetime;
	}

	public Integer getTotalComment() {
		return totalComment;
	}

	public void setTotalComment(Integer totalComment) {
		this.totalComment = totalComment;
	}

	public Integer getTotalLikeNo() {
		return totalLikeNo;
	}

	public void setTotalLikeNo(Integer totalLikeNo) {
		this.totalLikeNo = totalLikeNo;
	}

	public String getBusinessRegNum() {
		return businessRegNum;
	}

	public void setBusinessRegNum(String businessRegNum) {
		this.businessRegNum = businessRegNum;
	}

	public String getBusinessRegFileName() {
		return businessRegFileName;
	}

	public void setBusinessRegFileName(String businessRegFileName) {
		this.businessRegFileName = businessRegFileName;
	}

	public String getBusinessRegFileRename() {
		return businessRegFileRename;
	}

	public void setBusinessRegFileRename(String businessRegFileRename) {
		this.businessRegFileRename = businessRegFileRename;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyPhone() {
		return companyPhone;
	}

	public void setCompanyPhone(String companyPhone) {
		this.companyPhone = companyPhone;
	}

	public String getCompanyTime() {
		return companyTime;
	}

	public void setCompanyTime(String companyTime) {
		this.companyTime = companyTime;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getAuthorityRequest() {
		return authorityRequest;
	}

	public void setAuthorityRequest(String authorityRequest) {
		this.authorityRequest = authorityRequest;
	}

	@Override
	public String toString() {
		return "Promember [promemNo=" + promemNo + ", promemName=" + promemName + ", promemGender=" + promemGender
				+ ", promemPhone=" + promemPhone + ", promemEmail=" + promemEmail + ", promemAddress=" + promemAddress
				+ ", promemId=" + promemId + ", promemPwd=" + promemPwd + ", promemNickname=" + promemNickname
				+ ", promemChgPwdDatetime=" + promemChgPwdDatetime + ", promemPwdExpDate=" + promemPwdExpDate
				+ ", promemRegDatetime=" + promemRegDatetime + ", promeminactiveYn=" + promeminactiveYn
				+ ", promemSecessionYn=" + promemSecessionYn + ", promemSecessionDatetime=" + promemSecessionDatetime
				+ ", totalComment=" + totalComment + ", totalLikeNo=" + totalLikeNo + ", businessRegNum="
				+ businessRegNum + ", businessRegFileName=" + businessRegFileName + ", businessRegFileRename="
				+ businessRegFileRename + ", companyName=" + companyName + ", companyPhone=" + companyPhone
				+ ", companyTime=" + companyTime + ", companyAddress=" + companyAddress + ", authorityRequest="
				+ authorityRequest + "]";
	}
	
	
}