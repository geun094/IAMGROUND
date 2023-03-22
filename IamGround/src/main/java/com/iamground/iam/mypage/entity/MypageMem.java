package com.iamground.iam.mypage.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="MypageMem")
@Table(name="TBL_MEMBER")
public class MypageMem {
	@Id
	@Column(name="MEM_NO")
	private int memNo;
	@Column(name="MEM_ID")
	private String memId;
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
	@Column(name="MEM_NICKNAME")
	private String memNickname;
	
	public MypageMem() {
		super();
	}

	public MypageMem(int memNo, String memId, String memName, String memGender, String memPhone, String memEmail,
			String memAddress, String memNickname) {
		super();
		this.memNo = memNo;
		this.memId = memId;
		this.memName = memName;
		this.memGender = memGender;
		this.memPhone = memPhone;
		this.memEmail = memEmail;
		this.memAddress = memAddress;
		this.memNickname = memNickname;
	}

	public int getMemNo() {
		return memNo;
	}

	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
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

	public String getMemNickname() {
		return memNickname;
	}

	public void setMemNickname(String memNickname) {
		this.memNickname = memNickname;
	}

	@Override
	public String toString() {
		return "MypageMem [memNo=" + memNo + ", memId=" + memId + ", memName=" + memName + ", memGender=" + memGender
				+ ", memPhone=" + memPhone + ", memEmail=" + memEmail + ", memAddress=" + memAddress + ", memNickname="
				+ memNickname + "]";
	}

	
	
}