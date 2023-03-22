package com.iamground.iam.member.DTO;

import java.sql.Date;
import java.util.List;

import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

public class PromemberDTO {

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
	private String promemInactiveYn;               
	private String promemSecessionYn;                  
	private java.sql.Date promemSecessionDatetime;
	private Integer totalComment;
	private Integer totalLikeNo;
	private String businessRegNum;
	private String businessRegFileName;
	private String businessRegFileRename;
	private String companyName;
	private String companyPhone;
	private String companyTime;
	private String companyAddress;
	private String authorityRequest;
	private String companyAddressLatitude;
	private String companyAddressLongitude;
	
	@Transient
	private MultipartFile businessRegFile;
	@Transient
	private MultipartFile profileFile;
	@Transient
	private MultipartFile companyFile;
	@Transient
	private MultipartFile licenseFile;
	
	private List<MemberRoleDTO> memberRoleList;

	public PromemberDTO() {
		super();
	}

	public PromemberDTO(int promemNo, String promemName, String promemGender, String promemPhone, String promemEmail,
			String promemAddress, String promemId, String promemPwd, String promemNickname, Date promemChgPwdDatetime,
			Date promemPwdExpDate, Date promemRegDatetime, String promemInactiveYn, String promemSecessionYn,
			Date promemSecessionDatetime, Integer totalComment, Integer totalLikeNo, String businessRegNum,
			String businessRegFileName, String businessRegFileRename, String companyName, String companyPhone,
			String companyTime, String companyAddress, String authorityRequest, String companyAddressLatitude,
			String companyAddressLongitude, MultipartFile businessRegFile, MultipartFile profileFile,
			MultipartFile companyFile, MultipartFile licenseFile, List<MemberRoleDTO> memberRoleList) {
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
		this.promemInactiveYn = promemInactiveYn;
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
		this.companyAddressLatitude = companyAddressLatitude;
		this.companyAddressLongitude = companyAddressLongitude;
		this.businessRegFile = businessRegFile;
		this.profileFile = profileFile;
		this.companyFile = companyFile;
		this.licenseFile = licenseFile;
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

	public String getPromemInactiveYn() {
		return promemInactiveYn;
	}

	public void setPromemInactiveYn(String promemInactiveYn) {
		this.promemInactiveYn = promemInactiveYn;
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

	public String getCompanyAddressLatitude() {
		return companyAddressLatitude;
	}

	public void setCompanyAddressLatitude(String companyAddressLatitude) {
		this.companyAddressLatitude = companyAddressLatitude;
	}

	public String getCompanyAddressLongitude() {
		return companyAddressLongitude;
	}

	public void setCompanyAddressLongitude(String companyAddressLongitude) {
		this.companyAddressLongitude = companyAddressLongitude;
	}

	public MultipartFile getBusinessRegFile() {
		return businessRegFile;
	}

	public void setBusinessRegFile(MultipartFile businessRegFile) {
		this.businessRegFile = businessRegFile;
	}

	public MultipartFile getProfileFile() {
		return profileFile;
	}

	public void setProfileFile(MultipartFile profileFile) {
		this.profileFile = profileFile;
	}

	public MultipartFile getCompanyFile() {
		return companyFile;
	}

	public void setCompanyFile(MultipartFile companyFile) {
		this.companyFile = companyFile;
	}

	public MultipartFile getLicenseFile() {
		return licenseFile;
	}

	public void setLicenseFile(MultipartFile licenseFile) {
		this.licenseFile = licenseFile;
	}

	public List<MemberRoleDTO> getMemberRoleList() {
		return memberRoleList;
	}

	public void setMemberRoleList(List<MemberRoleDTO> memberRoleList) {
		this.memberRoleList = memberRoleList;
	}

	@Override
	public String toString() {
		return "PromemberDTO [promemNo=" + promemNo + ", promemName=" + promemName + ", promemGender=" + promemGender
				+ ", promemPhone=" + promemPhone + ", promemEmail=" + promemEmail + ", promemAddress=" + promemAddress
				+ ", promemId=" + promemId + ", promemPwd=" + promemPwd + ", promemNickname=" + promemNickname
				+ ", promemChgPwdDatetime=" + promemChgPwdDatetime + ", promemPwdExpDate=" + promemPwdExpDate
				+ ", promemRegDatetime=" + promemRegDatetime + ", promemInactiveYn=" + promemInactiveYn
				+ ", promemSecessionYn=" + promemSecessionYn + ", promemSecessionDatetime=" + promemSecessionDatetime
				+ ", totalComment=" + totalComment + ", totalLikeNo=" + totalLikeNo + ", businessRegNum="
				+ businessRegNum + ", businessRegFileName=" + businessRegFileName + ", businessRegFileRename="
				+ businessRegFileRename + ", companyName=" + companyName + ", companyPhone=" + companyPhone
				+ ", companyTime=" + companyTime + ", companyAddress=" + companyAddress + ", authorityRequest="
				+ authorityRequest + ", companyAddressLatitude=" + companyAddressLatitude + ", companyAddressLongitude="
				+ companyAddressLongitude + ", businessRegFile=" + businessRegFile + ", profileFile=" + profileFile
				+ ", companyFile=" + companyFile + ", licenseFile=" + licenseFile + ", memberRoleList=" + memberRoleList
				+ "]";
	}

	
	
}
