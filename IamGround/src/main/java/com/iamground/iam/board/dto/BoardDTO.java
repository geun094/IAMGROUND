package com.iamground.iam.board.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.iamground.iam.board.entity.Comment;

public class BoardDTO {
	private int boardNo;
	private int categoryCode;
	private String boardTitle;
	private String boardContent;
	private int memNo;
	private List<Comment> commentList;
	private String createdDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm"));
    private String modifiedDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm"));
	public BoardDTO() {
		super();
	}
	public BoardDTO(int boardNo, int categoryCode, String boardTitle, String boardContent, int memNo,
			List<Comment> commentList, String createdDate, String modifiedDate) {
		super();
		this.boardNo = boardNo;
		this.categoryCode = categoryCode;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.memNo = memNo;
		this.commentList = commentList;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public int getCategoryCode() {
		return categoryCode;
	}
	public void setCategoryCode(int categoryCode) {
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
	public List<Comment> getCommentList() {
		return commentList;
	}
	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
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
		return "BoardDTO [boardNo=" + boardNo + ", categoryCode=" + categoryCode + ", boardTitle=" + boardTitle
				+ ", boardContent=" + boardContent + ", memNo=" + memNo + ", commentList=" + commentList
				+ ", createdDate=" + createdDate + ", modifiedDate=" + modifiedDate + "]";
	}
    
    
    
}
