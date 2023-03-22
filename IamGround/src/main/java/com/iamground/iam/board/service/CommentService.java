package com.iamground.iam.board.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iamground.iam.board.dto.CommentDTO;
import com.iamground.iam.board.entity.Comment;
import com.iamground.iam.board.repository.BoardRepository;
import com.iamground.iam.board.repository.CommentRepository;

@Service
public class CommentService {

	private final CommentRepository commentRepository;
	private final BoardRepository boardRepository;
	private final ModelMapper modelMapper;
	
	@Autowired
	public CommentService(ModelMapper modelMapper, CommentRepository commentRepository, BoardRepository boardRepository) {
		this.modelMapper = modelMapper;
		this.commentRepository = commentRepository;
		this.boardRepository = boardRepository;
	}
	
	@Transactional
	public void commentSave(CommentDTO newcomment) {
		System.out.println("서비스 받았니------" + newcomment);
		commentRepository.save(modelMapper.map(newcomment, Comment.class));
	}
	

}
