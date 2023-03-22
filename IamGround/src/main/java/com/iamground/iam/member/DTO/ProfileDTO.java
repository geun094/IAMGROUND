package com.iamground.iam.member.DTO;

public class ProfileDTO {

	private int profileNo;
	private String profileFileName;	
	private String profileFileRename;	
	private String companyFileName;	
	private String companyFileRename;
	private int promemNo;
	
	public ProfileDTO() {
		super();
	}

	public ProfileDTO(int profileNo, String profileFileName, String profileFileRename, String companyFileName,
			String companyFileRename, int promemNo) {
		super();
		this.profileNo = profileNo;
		this.profileFileName = profileFileName;
		this.profileFileRename = profileFileRename;
		this.companyFileName = companyFileName;
		this.companyFileRename = companyFileRename;
		this.promemNo = promemNo;
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

	public int getPromemNo() {
		return promemNo;
	}

	public void setPromemNo(int promemNo) {
		this.promemNo = promemNo;
	}

	@Override
	public String toString() {
		return "ProfileDTO [profileNo=" + profileNo + ", profileFileName=" + profileFileName + ", profileFileRename="
				+ profileFileRename + ", companyFileName=" + companyFileName + ", companyFileRename="
				+ companyFileRename + ", promemNo=" + promemNo + "]";
	}
	
}