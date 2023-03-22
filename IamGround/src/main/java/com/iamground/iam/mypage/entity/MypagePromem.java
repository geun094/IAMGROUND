package com.iamground.iam.mypage.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="MypagePromem")
@Table(name="TBL_PROMEMBER")
public class MypagePromem {
	@Id
	@Column(name = "PROMEM_NO")
	private int promemNo;
	@Column(name = "PROMEM_ID")
	private String promemId;
	@Column(name = "PROMEM_NAME")
	private String promemName;
	@Column(name = "PROMEM_GENDER")
	private String promemGender;
	@Column(name = "PROMEM_PHONE")
	private String promemPhone;
	@Column(name = "PROMEM_EMAIL")
	private String promemEmail;
	@Column(name = "PROMEM_ADDRESS")
	private String promemAddress;
	@Column(name = "PROMEM_NICKNAME")
	private String promemNickname;
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
	
	public MypagePromem() {
		super();
	}

	public MypagePromem(int promemNo, String promemId, String promemName, String promemGender, String promemPhone,
			String promemEmail, String promemAddress, String promemNickname, Integer totalComment, Integer totalLikeNo,
			String businessRegNum, String businessRegFileName, String businessRegFileRename, String companyName,
			String companyPhone, String companyTime, String companyAddress, String authorityRequest) {
		super();
		this.promemNo = promemNo;
		this.promemId = promemId;
		this.promemName = promemName;
		this.promemGender = promemGender;
		this.promemPhone = promemPhone;
		this.promemEmail = promemEmail;
		this.promemAddress = promemAddress;
		this.promemNickname = promemNickname;
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

	public String getPromemId() {
		return promemId;
	}

	public void setPromemId(String promemId) {
		this.promemId = promemId;
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

	public String getPromemNickname() {
		return promemNickname;
	}

	public void setPromemNickname(String promemNickname) {
		this.promemNickname = promemNickname;
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
		return "MypagePromem [promemNo=" + promemNo + ", promemId=" + promemId + ", promemName=" + promemName
				+ ", promemGender=" + promemGender + ", promemPhone=" + promemPhone + ", promemEmail=" + promemEmail
				+ ", promemAddress=" + promemAddress + ", promemNickname=" + promemNickname + ", totalComment="
				+ totalComment + ", totalLikeNo=" + totalLikeNo + ", businessRegNum=" + businessRegNum
				+ ", businessRegFileName=" + businessRegFileName + ", businessRegFileRename=" + businessRegFileRename
				+ ", companyName=" + companyName + ", companyPhone=" + companyPhone + ", companyTime=" + companyTime
				+ ", companyAddress=" + companyAddress + ", authorityRequest=" + authorityRequest + "]";
	}
	
	
}