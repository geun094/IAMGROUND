package com.iamground.iam.notice.entity;

import javax.persistence.*;

@Entity(name="NoticeFile")
@Table(name = "TBL_NOTICE_File")
@SequenceGenerator(
		name = "NOTICEFILE_SEQ_GENERATOR",
		sequenceName = "SEQ_N_FILE_NO",
		initialValue = 1,
		allocationSize = 1
)
public class NoticeFile implements java.io.Serializable {
	private static final long serialVersionUID = 4626020372423260115L;

	@Id
	@Column(name = "N_FILE_NO")
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "NOTICEFILE_SEQ_GENERATOR"
	)
	private int nFileNo;
	
	@Column(name = "NOTICE_NO")
	private int noticeNo;
	
	@Column(name = "N_FILE_RENAME")
	private String nFileRename;
	
	@Column(name = "N_FILE_NAME")
	private String nFileName;
	
	public NoticeFile() {
		super();
	}
	public NoticeFile(int nFileNo, int noticeNo, String nFileRename, String nFileName) {
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
		return "NoticeFile [nFileNo=" + nFileNo + ", noticeNo=" + noticeNo + ", nFileRename=" + nFileRename
				+ ", nFileName=" + nFileName + "]";
	}
	
	
	
}
