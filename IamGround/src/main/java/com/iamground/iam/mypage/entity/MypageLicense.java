package com.iamground.iam.mypage.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="MypageLicense")
@Table(name="TBL_LICENSE")
public class MypageLicense implements Serializable {
	private static final long serialVersionUID = -4464072352766296526L;

		@Column(name = "LICENSE_FILE_NO")
		private int licenseFileNo;
		@Column(name="LICENSE_FILE_NAME ")
		private String licenseFileName;	
		@Column(name="LICENSE_FILE_RENAME ")
		private String licenseFileRename;
		@Id
		@Column(name = "PROMEM_NO")				// FK
		private int promemNo;
		public MypageLicense() {
			super();
		}
		public MypageLicense(int licenseFileNo, String licenseFileName, String licenseFileRename, int promemNo) {
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
		public static long getSerialversionuid() {
			return serialVersionUID;
		}
		@Override
		public String toString() {
			return "MypageLicense [licenseFileNo=" + licenseFileNo + ", licenseFileName=" + licenseFileName
					+ ", licenseFileRename=" + licenseFileRename + ", promemNo=" + promemNo + "]";
		}
		
		
}