package com.iamground.iam.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name="Member")
@Table(name="TBL_MEMBER")
@SequenceGenerator(
		 name="MEMBER_SEQ_GENERATOR",
		 sequenceName = "SEQ_MEM_NO",
		 initialValue = 0,
		 allocationSize = 1
)
public class Member {

	@Id
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "MEMBER_SEQ_GENERATOR"
	)
	@Column(name = "MEM_NO")
	private int memNo;
	@Column(name="MEM_NAME")
	private String memName;	
	@Column(name="MEM_GENDER")
	private String memGender;
	@Column(name="MEM_PHONE")
	private String memPhone;
	@Column(name="MEM_EMAIL")
	private String memEmail;
	@Column(name="MEM_ADDRESS")
	private String memAddress;
	@Column(name="MEM_ID")
	private String memId;
	@Column(name="MEM_PWD")
	private String memPwd;
	@Column(name="MEM_NICKNAME")
	private String memNickname;
	@Column(name="MEM_CHG_PWD_DATETIME")
	private java.sql.Date memChgPwdDatetime; 
	@Column(name="MEM_PWD_EXP_DATE")
	private java.sql.Date memPwdExpDate;
	@Column(name="MEM_REG_DATETIME")
	private java.sql.Date memRegDatetime;
	@Column(name="MEM_INACTIVE_YN")
	private String meminactiveYn; 
	@Column(name="MEM_SECESSION_YN")
	private String secessionYn; 
	@Column(name="MEM_SECESSION_DATETIME")
	private java.sql.Date memSecessionDatetime;
	
	public Member() {}

	public Member(int memNo, String memName, String memGender, String memPhone, String memEmail, String memAddress,
			String memId, String memPwd, String memNickname, Date memChgPwdDatetime, Date memPwdExpDate,
			Date memRegDatetime, String meminactiveYn, String secessionYn, Date memSecessionDatetime) {
		super();
		this.memNo = memNo;
		this.memName = memName;
		this.memGender = memGender;
		this.memPhone = memPhone;
		this.memEmail = memEmail;
		this.memAddress = memAddress;
		this.memId = memId;
		this.memPwd = memPwd;
		this.memNickname = memNickname;
		this.memChgPwdDatetime = memChgPwdDatetime;
		this.memPwdExpDate = memPwdExpDate;
		this.memRegDatetime = memRegDatetime;
		this.meminactiveYn = meminactiveYn;
		this.secessionYn = secessionYn;
		this.memSecessionDatetime = memSecessionDatetime;
	}

	public int getMemNo() {
		return memNo;
	}

	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public String getMemGender() {
		return memGender;
	}

	public void setMemGender(String memGender) {
		this.memGender = memGender;
	}

	public String getMemPhone() {
		return memPhone;
	}

	public void setMemPhone(String memPhone) {
		this.memPhone = memPhone;
	}

	public String getMemEmail() {
		return memEmail;
	}

	public void setMemEmail(String memEmail) {
		this.memEmail = memEmail;
	}

	public String getMemAddress() {
		return memAddress;
	}

	public void setMemAddress(String memAddress) {
		this.memAddress = memAddress;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getMemPwd() {
		return memPwd;
	}

	public void setMemPwd(String memPwd) {
		this.memPwd = memPwd;
	}

	public String getMemNickname() {
		return memNickname;
	}

	public void setMemNickname(String memNickname) {
		this.memNickname = memNickname;
	}

	public java.sql.Date getMemChgPwdDatetime() {
		return memChgPwdDatetime;
	}

	public void setMemChgPwdDatetime(java.sql.Date memChgPwdDatetime) {
		this.memChgPwdDatetime = memChgPwdDatetime;
	}

	public java.sql.Date getMemPwdExpDate() {
		return memPwdExpDate;
	}

	public void setMemPwdExpDate(java.sql.Date memPwdExpDate) {
		this.memPwdExpDate = memPwdExpDate;
	}

	public java.sql.Date getMemRegDatetime() {
		return memRegDatetime;
	}

	public void setMemRegDatetime(java.sql.Date memRegDatetime) {
		this.memRegDatetime = memRegDatetime;
	}

	public String getMeminactiveYn() {
		return meminactiveYn;
	}

	public void setMeminactiveYn(String meminactiveYn) {
		this.meminactiveYn = meminactiveYn;
	}

	public String getSecessionYn() {
		return secessionYn;
	}

	public void setSecessionYn(String secessionYn) {
		this.secessionYn = secessionYn;
	}

	public java.sql.Date getMemSecessionDatetime() {
		return memSecessionDatetime;
	}

	public void setMemSecessionDatetime(java.sql.Date memSecessionDatetime) {
		this.memSecessionDatetime = memSecessionDatetime;
	}

	@Override
	public String toString() {
		return "Member [memNo=" + memNo + ", memName=" + memName + ", memGender=" + memGender + ", memPhone=" + memPhone
				+ ", memEmail=" + memEmail + ", memAddress=" + memAddress + ", memId=" + memId + ", memPwd=" + memPwd
				+ ", memNickname=" + memNickname + ", memChgPwdDatetime=" + memChgPwdDatetime + ", memPwdExpDate="
				+ memPwdExpDate + ", memRegDatetime=" + memRegDatetime + ", meminactiveYn=" + meminactiveYn
				+ ", secessionYn=" + secessionYn + ", memSecessionDatetime=" + memSecessionDatetime + "]";
	}
	
	
	
}


