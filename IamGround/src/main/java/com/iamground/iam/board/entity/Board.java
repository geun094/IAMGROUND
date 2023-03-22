package com.iamground.iam.board.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@EntityListeners(AuditingEntityListener.class)
@Entity(name="Board")
@Table(name = "TBL_QNA_BOARD")
@SequenceGenerator( /// 식별자, 시퀀스전략
        name = "BOARD_SEQ_GENERATOR",
        sequenceName = "SEQ_BOARD_NO",
        initialValue = 1,
        allocationSize = 1
)
public class Board {
	
	@OrderBy("commentNo desc") // 댓글 작성 시 최근순으로
	@JsonIgnoreProperties({"board"})                           // cascade = CascadeType.REMOVE, 게시글을 삭제하려고 하면 무결성 제약조건 위배 에러가 발생하며 옵션을 주면 해결된다
	@OneToMany(mappedBy = "board", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE) // mppedBy : 연관관계의 주인이 아니므로 DB의 FK가 아니다 라는 뜻(Board 테이블에 댓글리스트를 추가하겠따는 건데 DB에는 하나의 raw 데이터에 하나의 값만 들어갈 수 있다, 만약 여러개가 들어가면 원자성이 깨진다, 그래서 commentList는 DB에 FK로 생성되면 안되서 사용한다
	private List<Comment> commentList; // CommentEntity를 List로 선언해준다.
	
	@Id
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "BOARD_SEQ_GENERATOR"
			)
	@Column(name = "BOARD_NO")
	private int boardNo;
	
	@Column(name = "CATEGORY_CODE")
	private Integer categoryCode;
	
	@Column(name = "BOARD_TITLE")
	private String boardTitle;
	
	@Column(name = "BOARD_CONTENT")
	private String boardContent;
	
	@Column(name = "MEM_NO")
	private int memNo;

    @Column(name = "CREATED_DATE")
    @CreatedDate
    private String createdDate;
 
    @Column(name = "MODIFIED_DATE")
    @LastModifiedDate
    private String modifiedDate;

	public Board() {
		super();
	}

	public Board(List<Comment> commentList, int boardNo, Integer categoryCode, String boardTitle, String boardContent,
			int memNo, String createdDate, String modifiedDate) {
		super();
		this.commentList = commentList;
		this.boardNo = boardNo;
		this.categoryCode = categoryCode;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.memNo = memNo;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
	}

	public List<Comment> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public Integer getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(Integer categoryCode) {
		this.categoryCode = categoryCode;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public int getMemNo() {
		return memNo;
	}

	public void setMemNo(int memNo) {
		this.memNo = memNo;
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
		return "Board [commentList=" + commentList + ", boardNo=" + boardNo + ", categoryCode=" + categoryCode
				+ ", boardTitle=" + boardTitle + ", boardContent=" + boardContent + ", memNo=" + memNo
				+ ", createdDate=" + createdDate + ", modifiedDate=" + modifiedDate + "]";
	}

    
}
