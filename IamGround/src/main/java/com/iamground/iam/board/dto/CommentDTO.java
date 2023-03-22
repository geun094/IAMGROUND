package com.iamground.iam.board.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//@JsonInclude(Include.NON_NULL)
public class CommentDTO {
	private int commentNo;
	private int promemNo;
	private int likeNo;
	private String commentContent;
	private String createdDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm"));
    private String modifiedDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm"));
	private int boardNo;
	
	public CommentDTO() {
		super();
	}
	public CommentDTO(int commentNo, int promemNo, int likeNo, String commentContent, String createdDate,
			String modifiedDate, int boardNo) {
		super();
		this.commentNo = commentNo;
		this.promemNo = promemNo;
		this.likeNo = likeNo;
		this.commentContent = commentContent;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
		this.boardNo = boardNo;
	}
	public int getCommentNo() {
		return commentNo;
	}
	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}
	public int getPromemNo() {
		return promemNo;
	}
	public void setPromemNo(int promemNo) {
		this.promemNo = promemNo;
	}
	public int getLikeNo() {
		return likeNo;
	}
	public void setLikeNo(int likeNo) {
		this.likeNo = likeNo;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
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
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	@Override
	public String toString() {
		return "CommentDTO [commentNo=" + commentNo + ", promemNo=" + promemNo + ", likeNo=" + likeNo
				+ ", commentContent=" + commentContent + ", createdDate=" + createdDate + ", modifiedDate="
				+ modifiedDate + ", boardNo=" + boardNo + "]";
	}
	
}
