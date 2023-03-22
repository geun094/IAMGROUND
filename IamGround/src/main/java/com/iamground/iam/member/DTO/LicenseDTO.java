package com.iamground.iam.member.DTO;


public class LicenseDTO {

	private int licenseFileNo;
	private String licenseFileName;	
	private String licenseFileRename;
	private int promemNo;
	
	public LicenseDTO() {
		super();
	}

	public LicenseDTO(int licenseFileNo, String licenseFileName, String licenseFileRename, int promemNo) {
		super();
		this.licenseFileNo = licenseFileNo;
		this.licenseFileName = licenseFileName;
		this.licenseFileRename = licenseFileRename;
		this.promemNo = promemNo;
	}

	public int getLicenseFileNo() {
		return licenseFileNo;
	}

	public void setLicenseFileNo(int licenseFileNo) {
		this.licenseFileNo = licenseFileNo;
	}

	public String getLicenseFileName() {
		return licenseFileName;
	}

	public void setLicenseFileName(String licenseFileName) {
		this.licenseFileName = licenseFileName;
	}

	public String getLicenseFileRename() {
		return licenseFileRename;
	}

	public void setLicenseFileRename(String licenseFileRename) {
		this.licenseFileRename = licenseFileRename;
	}

	public int getPromemNo() {
		return promemNo;
	}

	public void setPromemNo(int promemNo) {
		this.promemNo = promemNo;
	}

	@Override
	public String toString() {
		return "LicenseDTO [licenseFileNo=" + licenseFileNo + ", licenseFileName=" + licenseFileName
				+ ", licenseFileRename=" + licenseFileRename + ", promemNo=" + promemNo + "]";
	}
	
	
}