package com.iamground.iam.member.DTO;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.iamground.iam.entity.MemberRoleAndAuthority;

public class MemberAndMemberRoleDTO {
	private int memNo;
	private String memName;	
	private String memGender;
	private String memPhone;
	private String memEmail;
	private String memAddress;
	private String memId;
	private String memPwd;
	private String memNickname;
	private java.sql.Date memChgPwdDatetime; 
	private java.sql.Date memPwdExpDate;
	private java.sql.Date memRegDatetime;
	private String meminactiveYn; 
	private String secessionYn; 
	private java.sql.Date memSecessionDatetime;
	private List<MemberRoleAndAuthority> memberRoleList;
	public MemberAndMemberRoleDTO() {
		super();
	}
	public MemberAndMemberRoleDTO(int memNo, String memName, String memGender, String memPhone, String memEmail,
			String memAddress, String memId, String memPwd, String memNickname, Date memChgPwdDatetime,
			Date memPwdExpDate, Date memRegDatetime, String meminactiveYn, String secessionYn,
			Date memSecessionDatetime, List<MemberRoleAndAuthority> memberRoleList) {
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
		this.memberRoleList = memberRoleList;
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
	public List<MemberRoleAndAuthority> getMemberRoleList() {
		return memberRoleList;
	}
	public void setMemberRoleList(List<MemberRoleAndAuthority> memberRoleList) {
		this.memberRoleList = memberRoleList;
	}
	@Override
	public String toString() {
		return "MemberAndMemberRoleDTO [memNo=" + memNo + ", memName=" + memName + ", memGender=" + memGender
				+ ", memPhone=" + memPhone + ", memEmail=" + memEmail + ", memAddress=" + memAddress + ", memId="
				+ memId + ", memPwd=" + memPwd + ", memNickname=" + memNickname + ", memChgPwdDatetime="
				+ memChgPwdDatetime + ", memPwdExpDate=" + memPwdExpDate + ", memRegDatetime=" + memRegDatetime
				+ ", meminactiveYn=" + meminactiveYn + ", secessionYn=" + secessionYn + ", memSecessionDatetime="
				+ memSecessionDatetime + ", memberRoleList=" + memberRoleList + "]";
	}
	
}
