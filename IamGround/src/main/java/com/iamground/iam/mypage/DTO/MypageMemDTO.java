package com.iamground.iam.mypage.DTO;

public class MypageMemDTO {
	
	private int memNo;
	private String memName;	
	private String memGender;
	private String memPhone;
	private String memEmail;
	private String memAddress;
	private String memNickname;
	
	public MypageMemDTO() {
		super();
	}

	public MypageMemDTO(int memNo, String memName, String memGender, String memPhone, String memEmail,
			String memAddress, String memNickname) {
		super();
		this.memNo = memNo;
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
		return "MypageMemDTO [memNo=" + memNo + ", memName=" + memName + ", memGender=" + memGender + ", memPhone="
				+ memPhone + ", memEmail=" + memEmail + ", memAddress=" + memAddress + ", memNickname=" + memNickname
				+ "]";
	}
	
	
	
}