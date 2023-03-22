package com.iamground.iam.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name="Profile")
@Table(name="TBL_PROFILE")
@SequenceGenerator(
		name="PROFILE_SEQ_GENERATOR",
		sequenceName = "SEQ_PROFILE_NO",
		initialValue = 1,
		allocationSize = 1
		)
public class Profile {

		@Id
		@GeneratedValue(
				strategy = GenerationType.SEQUENCE,
				generator = "PROFILE_SEQ_GENERATOR"
		)
		@Column(name = "PROFILE_NO")
		private int profileNo;
		@Column(name="PROFILE_FILE_NAME")
		private String profileFileName;	
		@Column(name="PROFILE_FILE_RENAME")
		private String profileFileRename;	
		@Column(name="COMPANY_FILE_NAME")
		private String companyFileName;	
		@Column(name="COMPANY_FILE_RENAME")
		private String companyFileRename;
		@Column(name = "PROMEM_NO")				// FK
		private int promemNo;
		
		public Profile() {
			super();
		}
		
		public Profile(int profileNo, String profileFileName, String profileFileRename, String companyFileName,
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
			return "Profile [profileNo=" + profileNo + ", profileFileName=" + profileFileName + ", profileFileRename="
					+ profileFileRename + ", companyFileName=" + companyFileName + ", companyFileRename="
					+ companyFileRename + ", promemNo=" + promemNo + "]";
		}
		
		
}