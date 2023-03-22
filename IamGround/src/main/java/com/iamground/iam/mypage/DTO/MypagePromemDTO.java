package com.iamground.iam.mypage.DTO;

import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

public class MypagePromemDTO {

	private int promemNo;
	private String promemId;
	private String promemName;
	private String promemGender;
	private String promemPhone;
	private String promemEmail;
	private String promemAddress;
	private String promemNickname;
	private Integer totalComment;
	private Integer totalLikeNo;

	
	private String companyName;
	private String companyPhone;
	private String companyTime;
	private String companyAddress;
	private String authorityRequest;
	
	
	private int profileNo;
	private String profileFileName;	
	private String profileFileRename;	
	private String companyFileName;	
	private String companyFileRename;
	
	@Transient
	private MultipartFile businessRegFile;
	@Transient
	private MultipartFile profileFile;
	@Transient
	private MultipartFile companyFile;
	@Transient
	private MultipartFile licenseFile;
	
	public MypagePromemDTO() {
		super();
	}

	public MypagePromemDTO(int promemNo, String promemId, String promemName, String promemGender, String promemPhone,
			String promemEmail, String promemAddress, String promemNickname, Integer totalComment, Integer totalLikeNo,
			String companyName, String companyPhone, String companyTime, String companyAddress, String authorityRequest,
			int profileNo, String profileFileName, String profileFileRename, String companyFileName,
			String companyFileRename, MultipartFile businessRegFile, MultipartFile profileFile,
			MultipartFile companyFile, MultipartFile licenseFile) {
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
		this.companyName = companyName;
		this.companyPhone = companyPhone;
		this.companyTime = companyTime;
		this.companyAddress = companyAddress;
		this.authorityRequest = authorityRequest;
		this.profileNo = profileNo;
		this.profileFileName = profileFileName;
		this.profileFileRename = profileFileRename;
		this.companyFileName = companyFileName;
		this.companyFileRename = companyFileRename;
		this.businessRegFile = businessRegFile;
		this.profileFile = profileFile;
		this.companyFile = companyFile;
		this.licenseFile = licenseFile;
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

	public int getProfileNo() {
		return profileNo;
	}

	public void setProfileNo(int profileNo) {
		this.profileNo = profileNo;
	}

	public String getProfileFileName() {
		return profileFileName;
	}

	public void setProfileFileName(String profileFileName) {
		this.profileFileName = profileFileName;
	}

	public String getProfileFileRename() {
		return profileFileRename;
	}

	public void setProfileFileRename(String profileFileRename) {
		this.profileFileRename = profileFileRename;
	}

	public String getCompanyFileName() {
		return companyFileName;
	}

	public void setCompanyFileName(String companyFileName) {
		this.companyFileName = companyFileName;
	}

	public String getCompanyFileRename() {
		return companyFileRename;
	}

	public void setCompanyFileRename(String companyFileRename) {
		this.companyFileRename = companyFileRename;
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

	@Override
	public String toString() {
		return "MypagePromemDTO [promemNo=" + promemNo + ", promemId=" + promemId + ", promemName=" + promemName
				+ ", promemGender=" + promemGender + ", promemPhone=" + promemPhone + ", promemEmail=" + promemEmail
				+ ", promemAddress=" + promemAddress + ", promemNickname=" + promemNickname + ", totalComment="
				+ totalComment + ", totalLikeNo=" + totalLikeNo + ", companyName=" + companyName + ", companyPhone="
				+ companyPhone + ", companyTime=" + companyTime + ", companyAddress=" + companyAddress
				+ ", authorityRequest=" + authorityRequest + ", profileNo=" + profileNo + ", profileFileName="
				+ profileFileName + ", profileFileRename=" + profileFileRename + ", companyFileName=" + companyFileName
				+ ", companyFileRename=" + companyFileRename + ", businessRegFile=" + businessRegFile + ", profileFile="
				+ profileFile + ", companyFile=" + companyFile + ", licenseFile=" + licenseFile + "]";
	}

	
}