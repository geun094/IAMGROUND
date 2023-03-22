package com.iamground.iam.mypage.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="MypageProfile")
@Table(name="TBL_PROFILE")

public class MypageProfile {

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
		@Id
		@Column(name = "PROMEM_NO")				// FK
		private int promemNo;
		
		public MypageProfile() {
			super();
		}
		
		public MypageProfile(int profileNo, String profileFileName, String profileFileRename, String companyFileName,
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
			return "MypageProfile [profileNo=" + profileNo + ", profileFileName=" + profileFileName
					+ ", profileFileRename=" + profileFileRename + ", companyFileName=" + companyFileName
					+ ", companyFileRename=" + companyFileRename + ", promemNo=" + promemNo + "]";
		}

		
}