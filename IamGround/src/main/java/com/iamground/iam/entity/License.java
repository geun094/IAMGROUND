package com.iamground.iam.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name="License")
@Table(name="TBL_LICENSE")
@SequenceGenerator(
		name="LICENSE_FILE_NO_SEQ_GENERATOR",
		sequenceName = "SEQ_LICENSE_FILE_NO",
		initialValue = 1,
		allocationSize = 1
		)
public class License implements Serializable {
	private static final long serialVersionUID = -4464072352766296526L;

		@Id
		@GeneratedValue(
				strategy = GenerationType.SEQUENCE,
				generator = "LICENSE_FILE_NO_SEQ_GENERATOR"
		)
		@Column(name = "LICENSE_FILE_NO")
		private int licenseFileNo;
		@Column(name="LICENSE_FILE_NAME ")
		private String licenseFileName;	
		@Column(name="LICENSE_FILE_RENAME ")
		private String licenseFileRename;
		@Column(name = "PROMEM_NO")				// FK
		private int promemNo;
		
		public License() {
			super();
		}

		public License(int licenseFileNo, String licenseFileName, String licenseFileRename, int promemNo) {
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
			return "License [licenseFileNo=" + licenseFileNo + ", licenseFileName=" + licenseFileName
					+ ", licenseFileRename=" + licenseFileRename + ", promemNo=" + promemNo + "]";
		}
	
	
}