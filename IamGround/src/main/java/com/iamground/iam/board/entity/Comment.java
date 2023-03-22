package com.iamground.iam.board.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.transaction.Transactional;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
@SequenceGenerator( /// 식별자, 시퀀스전략
        name = "BOARD_SEQ_GENERATOR",
        sequenceName = "SEQ_BOARD_NO",
        initialValue = 1,
        allocationSize = 1
)
@Entity
@Table(name = "TBL_QNA_BOARD_COMMENT")
@EntityListeners(AuditingEntityListener.class)
public class Comment {
	@Transactional
	public void save(Board board/*, User user*/) {
		this.board = board;
		/* this.user = user; */
	}
	
	@Id /* 기본 키 지정 */
//	@GeneratedValue(strategy = GenerationType.IDENTITY) /* 기본 키 생성을 DB에 위임 */
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "BOARD_SEQ_GENERATOR"
			)
	@Column(name="COMMENT_NO")
	private int commentNo;
	
	/*지연로딩, 로딩되는 시점에 lazy로딩 설정이 되어있는 엔티티는 프록시 객체로 가져온다, 실제 객체를 사용하는 시점에 초기화가 된다,DB에 쿼리가 나간다, 반대는 EAGER */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BOARD_NO") // 참조하고자 하는 테이블(부모)의 pk컬럼 이름  
	private Board board; // 참조하고자 하는 테이블을 관리하는 Entity
	
	@Column(name = "PROMEM_NO")
	private int promemNo;
	
	@Column(name = "COMMENT_CONTENT")
	private String commentContent;
	
	@Column(name = "LIKE_NO")
	private int likeNo;
	
    @Column(name = "CREATED_DATE")
    @CreatedDate
    private String createdDate;
 
    @Column(name = "MODIFIED_DATE")
    @LastModifiedDate
    private String modifiedDate;

	public Comment() {
		super();
	}

	public Comment(int commentNo, Board board, int promemNo, String commentContent, int likeNo, String createdDate,
			String modifiedDate) {
		super();
		this.commentNo = commentNo;
		this.board = board;
		this.promemNo = promemNo;
		this.commentContent = commentContent;
		this.likeNo = likeNo;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
	}

	public int getCommentNo() {
		return commentNo;
	}

	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public int getPromemNo() {
		return promemNo;
	}

	public void setPromemNo(int promemNo) {
		this.promemNo = promemNo;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public int getLikeNo() {
		return likeNo;
	}

	public void setLikeNo(int likeNo) {
		this.likeNo = likeNo;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	@Override
	public String toString() {
		return "Comment [commentNo=" + commentNo + ", board=" + board.getBoardTitle() + ", promemNo=" + promemNo + ", commentContent="
				+ commentContent + ", likeNo=" + likeNo + ", createdDate=" + createdDate + ", modifiedDate="
				+ modifiedDate + "]";
	}

    
}
