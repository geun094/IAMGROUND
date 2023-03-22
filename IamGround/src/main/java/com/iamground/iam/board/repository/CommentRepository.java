package com.iamground.iam.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iamground.iam.board.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer>{

}
