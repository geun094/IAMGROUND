package com.iamground.iam.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iamground.iam.board.dto.CommentDTO;
import com.iamground.iam.board.service.CommentService;

@Controller
@RequestMapping("/board")
public class CommentController {
	private final CommentService commentService;

	@Autowired
	public CommentController(CommentService commentService) {
		this.commentService = commentService;
	}

	@PostMapping("/{boardNo}/comment")
	@ResponseBody // 내부적으로 json 문자열로 변환해줌
	public CommentDTO commentSave(CommentDTO commentDTO) { // 

		System.out.println("컨트롤러 받았니=================="+commentDTO);

		commentService.commentSave(commentDTO);
		
		return commentDTO;
	}
}

/*
 * @AuthenticationPrincipal 로그인 정보를 받아오는 어노테이션 나중에 아래 글 다시 참고하기
 * (https://velog.io/@jyleedev/AuthenticationPrincipal-%EB%A1%9C%EA%B7%B8%
 * EC%9D%B8-%EC%A0%95%EB%B3%B4-%EB%B0%9B%EC%95%84%EC%98%A4%EA%B8%B0)
 * 
 * @AuthenticationPrincipal PrincipalDetail principalDetail) {
 * commentService.commentSave(boardNo, comment, principalDetail.getUser()); } //
 * User 정보는 @AuthenticationPrincipal, boardNo는 @PathVariable 통해서, Comment는
 * JSON으로 보내준다 }
 */