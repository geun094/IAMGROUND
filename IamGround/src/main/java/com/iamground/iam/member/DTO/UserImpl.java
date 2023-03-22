package com.iamground.iam.member.DTO;

import java.sql.Date;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class UserImpl extends User {
	private int memNo;									
	private String memName;								
	private String memGender;								
	private String memPhone;
	private String memEmail;
	private String memAddress;
	private String memId;
	private String memPwd;
	private String memNickname;
	private java.sql.Date memChgPwdDatetime;     // 비밀번호변경		
	private java.sql.Date memPwdExpDate;	     // 만료일자 
	private java.sql.Date memRegDatetime;        // 가입일시
	private String meminactiveYn;                // 비활성화여부
	private String secessionYn;                  // 계정탈퇴여부
	private java.sql.Date memSecessionDatetime;	 // 계정탈일시

	
	private List<MemberRoleDTO> memberRoleList;		// 회원별권한리스트
	
	public UserImpl(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}


	

	public UserImpl(String username, String password, Collection<? extends GrantedAuthority> authorities, int memNo,
			String memName, String memGender, String memPhone, String memEmail, String memAddress, String memId,
			String memPwd, String memNickname, Date memChgPwdDatetime, Date memPwdExpDate, Date memRegDatetime,
			String meminactiveYn, String secessionYn, Date memSecessionDatetime, List<MemberRoleDTO> memberRoleList) {
		super(username, password, authorities);
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
	public void setDetails(MemberDTO member) {
		this.memNo = member.getMemNo();
		this.memName =member.getMemName();
		this.memGender =member.getMemGender();
		this.memPhone = member.getMemPhone();
		this.memEmail = member.getMemEmail();
		this.memAddress = member.getMemAddress();
		this.memId =member.getMemId();
		this.memPwd = "[PROTECTED]";
		this.memNickname =member.getMemNickname();
		this.memChgPwdDatetime =member.getMemChgPwdDatetime();
		this.memPwdExpDate =member.getMemPwdExpDate();
		this.memRegDatetime =member.getMemRegDatetime();
		this.meminactiveYn = member.getMeminactiveYn();
		this.secessionYn = member.getSecessionYn();
		this.memSecessionDatetime = member.getMemSecessionDatetime();
		this.memberRoleList = member.getMemberRoleList();
	}

	public int getMemNo() {
		return memNo;
	}




	public String getMemName() {
		return memName;
	}




	public String getMemGender() {
		return memGender;
	}




	public String getMemPhone() {
		return memPhone;
	}




	public String getMemEmail() {
		return memEmail;
	}




	public String getMemAddress() {
		return memAddress;
	}




	public String getMemId() {
		return memId;
	}




	public String getMemPwd() {
		return memPwd;
	}




	public String getMemNickname() {
		return memNickname;
	}




	public java.sql.Date getMemChgPwdDatetime() {
		return memChgPwdDatetime;
	}




	public java.sql.Date getMemPwdExpDate() {
		return memPwdExpDate;
	}




	public java.sql.Date getMemRegDatetime() {
		return memRegDatetime;
	}




	public String getMeminactiveYn() {
		return meminactiveYn;
	}




	public String getSecessionYn() {
		return secessionYn;
	}




	public java.sql.Date getMemSecessionDatetime() {
		return memSecessionDatetime;
	}




	public List<MemberRoleDTO> getMemberRoleList() {
		return memberRoleList;
	}




	@Override
	public String toString() {
		return "UserImpl [memNo=" + memNo + ", memName=" + memName + ", memGender=" + memGender + ", memPhone="
				+ memPhone + ", memEmail=" + memEmail + ", memAddress=" + memAddress + ", memId=" + memId + ", memPwd="
				+ memPwd + ", memNickname=" + memNickname + ", memChgPwdDatetime=" + memChgPwdDatetime
				+ ", memPwdExpDate=" + memPwdExpDate + ", memRegDatetime=" + memRegDatetime + ", meminactiveYn="
				+ meminactiveYn + ", secessionYn=" + secessionYn + ", memSecessionDatetime=" + memSecessionDatetime
				+ ", memberRoleList=" + memberRoleList + "]";
	}




	
}
