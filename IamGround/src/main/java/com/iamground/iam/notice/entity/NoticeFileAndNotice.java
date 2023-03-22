package com.iamground.iam.notice.entity;

import javax.persistence.*;


@Entity(name="NoticeFileAndNotice")
@Table(name = "TBL_NOTICE_File")
@SequenceGenerator(
		name = "NOTICEFILEANDNOTICE_SEQ_GENERATOR",
		sequenceName = "SEQ_N_FILE_NO",
		initialValue = 1,
		allocationSize = 1
)
public class NoticeFileAndNotice implements java.io.Serializable {
	private static final long serialVersionUID = 4733247566348401033L;

	@Id
	@Column(name = "N_FILE_NO")
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "NOTICEFILEANDNOTICE_SEQ_GENERATOR"
	)
	private int nFileNo;
	
	@ManyToOne
	@JoinColumn(name="NOTICE_NO")
	private Notice notice;
	
	@Column(name="N_FILE_RENAME")
	private String nFileRename;
	
	@Column(name="N_FILE_NAME")
	private String nFileName;

	public NoticeFileAndNotice() {
		super();
	}

	public NoticeFileAndNotice(int nFileNo, Notice notice, String nFileRename, String nFileName) {
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "NoticeFileAndNotice [nFileNo=" + nFileNo + ", notice=" + notice + ", nFileRename=" + nFileRename
				+ ", nFileName=" + nFileName + "]";
	}
	
	
	
	
}
