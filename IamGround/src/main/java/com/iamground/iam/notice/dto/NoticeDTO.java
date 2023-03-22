package com.iamground.iam.notice.dto;

import java.time.LocalDateTime;

public class NoticeDTO {

	private int noticeNo;
	private int promemNo;
	private String promemName;
	private String noticeTitle;
	private String noticeContent;
	private LocalDateTime noticeDate;
	private LocalDateTime modifiedDate;
	private int noticeCount;
	private String noticeStatus;
	public NoticeDTO() {
		super();
	}
	public NoticeDTO(int noticeNo, int promemNo, String promemName, String noticeTitle, String noticeContent,
			LocalDateTime noticeDate, LocalDateTime modifiedDate, int noticeCount, String noticeStatus) {
		super();
		this.noticeNo = noticeNo;
		this.promemNo = promemNo;
		this.promemName = promemName;
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.noticeDate = noticeDate;
		this.modifiedDate = modifiedDate;
		this.noticeCount = noticeCount;
		this.noticeStatus = noticeStatus;
	}
	public int getNoticeNo() {
		return noticeNo;
	}
	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}
	public int getPromemNo() {
		return promemNo;
	}
	public void setPromemNo(int promemNo) {
		this.promemNo = promemNo;
	}
	public String getPromemName() {
		return promemName;
	}
	public void setPromemName(String promemName) {
		this.promemName = promemName;
	}
	public String getNoticeTitle() {
		return noticeTitle;
	}
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	public String getNoticeContent() {
		return noticeContent;
	}
	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}
	public LocalDateTime getNoticeDate() {
		return noticeDate;
	}
	public void setNoticeDate(LocalDateTime noticeDate) {
		this.noticeDate = noticeDate;
	}
	public LocalDateTime getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(LocalDateTime modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public int getNoticeCount() {
		return noticeCount;
	}
	public void setNoticeCount(int noticeCount) {
		this.noticeCount = noticeCount;
	}
	public String getNoticeStatus() {
		return noticeStatus;
	}
	public void setNoticeStatus(String noticeStatus) {
		this.noticeStatus = noticeStatus;
	}
	@Override
	public String toString() {
		return "NoticeDTO [noticeNo=" + noticeNo + ", promemNo=" + promemNo + ", promemName=" + promemName
				+ ", noticeTitle=" + noticeTitle + ", noticeContent=" + noticeContent + ", noticeDate=" + noticeDate
				+ ", modifiedDate=" + modifiedDate + ", noticeCount=" + noticeCount + ", noticeStatus=" + noticeStatus
				+ "]";
	}
	
	
}