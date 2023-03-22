package com.iamground.iam.notice.dto;

import com.iamground.iam.notice.entity.Notice;

public class NoticeFileDTO {

	private int nFileNo;
	private int noticeNo;
	private String nFileRename;
	private String nFileName;
	public NoticeFileDTO() {
		super();
	}
	public NoticeFileDTO(int nFileNo, int noticeNo, String nFileRename, String nFileName) {
		super();
		this.nFileNo = nFileNo;
		this.noticeNo = noticeNo;
		this.nFileRename = nFileRename;
		this.nFileName = nFileName;
	}
	public int getnFileNo() {
		return nFileNo;
	}
	public void setnFileNo(int nFileNo) {
		this.nFileNo = nFileNo;
	}
	public int getNoticeNo() {
		return noticeNo;
	}
	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}
	public String getnFileRename() {
		return nFileRename;
	}
	public void setnFileRename(String nFileRename) {
		this.nFileRename = nFileRename;
	}
	public String getnFileName() {
		return nFileName;
	}
	public void setnFileName(String nFileName) {
		this.nFileName = nFileName;
	}
	@Override
	public String toString() {
		return "NoticeFileDTO [nFileNo=" + nFileNo + ", noticeNo=" + noticeNo + ", nFileRename=" + nFileRename
				+ ", nFileName=" + nFileName + "]";
	}
	
	
}
