package com.iamground.iam.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.iamground.iam.member.service.MemberService;

@Controller
@RequestMapping("/login")
public class MemberController {
	
	private final MemberService memberService;
	
	@Autowired
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@GetMapping("/login")
	public void memberLoginForm() {}
	
	   @PostMapping("/loginError")
	   public ModelAndView loadUserByUsername (ModelAndView mv) {
	      
	      mv.addObject("msg","아이디 비밀번호를 확인해 주세요!!!!");
	      mv.setViewName("login/login");
	      return mv;
	   }
}

