package com.iamground.iam.notice.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity(name="Notice")
@Table(name = "TBL_NOTICE")
@SequenceGenerator(
		name = "NOTICE_SEQ_GENERATOR",
		sequenceName = "SEQ_NOTICE_NO",
		initialValue = 1,
		allocationSize = 1
)


@EntityListeners(AuditingEntityListener.class)
public class Notice  implements java.io.Serializable {
	private static final long serialVersionUID = -3066624457830910690L;

	@Id
	@Column(name = "NOTICE_NO")
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "NOTICE_SEQ_GENERATOR"
	)
	private int noticeNo;
	
	@Column(name = "PROMEM_NO")
	private int promemNo;
	
	@Column(name = "PROMEM_NAME")
	private String promemName;
	
	@Column(name = "NOTICE_TITLE")
	private String noticeTitle;
	
	@Column(name = "NOTICE_CONTENT")
	private String noticeContent;
	
	@CreatedDate
	@Column(name = "NOTICE_DATE", updatable = false)
	private LocalDateTime noticeDate;
	
    @LastModifiedDate
    private LocalDateTime modifiedDate;
	
	@Column(name = "NOTICE_COUNT")
	private int noticeCount;
	
	@Column(name = "NOTICE_STATUS")
	private String noticeStatus;

	public Notice() {
		super();
	}

	public Notice(int noticeNo, int promemNo, String promemName, String noticeTitle, String noticeContent,
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
		return "Notice [noticeNo=" + noticeNo + ", promemNo=" + promemNo + ", promemName=" + promemName
				+ ", noticeTitle=" + noticeTitle + ", noticeContent=" + noticeContent + ", noticeDate=" + noticeDate
				+ ", modifiedDate=" + modifiedDate + ", noticeCount=" + noticeCount + ", noticeStatus=" + noticeStatus
				+ "]";
	}

	

}