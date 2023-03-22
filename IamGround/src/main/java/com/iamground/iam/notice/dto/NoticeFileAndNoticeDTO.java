package com.iamground.iam.notice.dto;


import com.iamground.iam.notice.entity.Notice;

public class NoticeFileAndNoticeDTO {

	private int nFileNo;
	private Notice notice;
	private String nFileRename;
	private String nFileName;

	public NoticeFileAndNoticeDTO() {
		super();
	}
	
	public NoticeFileAndNoticeDTO(int nFileNo, Notice notice, String nFileRename, String nFileName) {
		super();
		this.nFileNo = nFileNo;
		this.notice = notice;
		this.nFileRename = nFileRename;
		this.nFileName = nFileName;
	}

	public int getnFileNo() {
		return nFileNo;
	}

	public void setnFileNo(int nFileNo) {
		this.nFileNo = nFileNo;
	}

	public Notice getNotice() {
		return notice;
	}

	public void setNotice(Notice notice) {
		this.notice = notice;
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
		return "NoticeFileAndNoticeDTO [nFileNo=" + nFileNo + ", notice=" + notice + ", nFileRename=" + nFileRename
				+ ", nFileName=" + nFileName + "]";
	}
	
	
}
