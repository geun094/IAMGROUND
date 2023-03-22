package com.iamground.iam.regist.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.iamground.iam.member.DTO.MemberDTO;
import com.iamground.iam.member.DTO.PromemberDTO;
import com.iamground.iam.regist.service.RegistService;

@Controller
@RequestMapping("/regist")
public class RegistController {
	
	private final RegistService registService;
	
	@Autowired
	public RegistController(RegistService registService) {
		this.registService = registService;
	}
	
	/* 회원가입 첫 페이지 */
	@GetMapping("/regist")
	public void registPage() {}
	
	/* 회원가입-일반 페이지 */
	@GetMapping("/regist-member")
	public void registMemberPage() {}
	
	/* 일반회원 - 아이디 중복 확인 */
	@PostMapping("checkMemId")
	@ResponseBody
	public String checkMemId(@RequestBody MemberDTO memId) {
		System.out.println("아이디 중복확인 controller");
		System.out.println(memId.getMemId());
		
		int memIdcheckResult = registService.registCheckMemId(memId.getMemId());
		return memIdcheckResult + "";		// int -> String 으로 자료형 변환
	}
	
	/* 일반회원 - 이메일 중복 확인 */
	@PostMapping("checkMemEmail")
	@ResponseBody
	public String checkMemEmail(@RequestBody MemberDTO memEmail) {
		System.out.println("이메일 중복확인 controller");
		System.out.println(memEmail.getMemEmail());
		
		int memEmailCheckResult = registService.registCheckMemEmail(memEmail.getMemEmail());
		return memEmailCheckResult + "";		// int -> String 으로 자료형 변환
	}
	
	/* 일반회원 - 닉네임 중복 확인 */
	@PostMapping("checkMemNickname")
	@ResponseBody
	public String checkMemNickname(@RequestBody MemberDTO memNickname) {
		System.out.println("닉네임 중복확인 controller");
		System.out.println(memNickname.getMemNickname());
		
		int memNicknameCheckResult = registService.registCheckMemNickname(memNickname.getMemNickname());
		return memNicknameCheckResult + "";		// int -> String 으로 자료형 변환
	}
		
	@PostMapping("/regist-member")
	public ModelAndView registMember(ModelAndView mv, MemberDTO newMember, RedirectAttributes rttr) {
		registService.registNewMember(newMember);
		
		rttr.addFlashAttribute("registSuccessMessage", "회원 가입에 성공하셨습니다.");
		mv.setViewName("/regist/regist-mem-success");
		
		return mv;
	}
	


	
	/* 회원가입-전문가 페이지 */
	@GetMapping("/regist-promember")
	public void registPromemberPage() {}
	
	/* 전문가회원 - 아이디 중복 확인 */
	@PostMapping("checkPromemId")
	@ResponseBody
	public String checkMemId(@RequestBody PromemberDTO promemId) {
		System.out.println("아이디 중복확인 controller");
		System.out.println(promemId.getPromemId());
		
		int promemIdcheckResult = registService.registCheckPromemId(promemId.getPromemId());
		return promemIdcheckResult + "";		// int -> String 으로 자료형 변환
	}
	
	/* 전문가회원 - 이메일 중복 확인 */
	@PostMapping("checkPromemEmail")
	@ResponseBody
	public String checkPromemEmail(@RequestBody PromemberDTO promemEmail) {
		System.out.println("이메일 중복확인 controller");
		System.out.println(promemEmail.getPromemEmail());
		
		int promemEmailCheckResult = registService.registCheckPromemEmail(promemEmail.getPromemEmail());
		return promemEmailCheckResult + "";		// int -> String 으로 자료형 변환
	}
	
	/* 전문가회원 - 닉네임 중복 확인 */
	@PostMapping("checkPromemNickname")
	@ResponseBody
	public String checkPromemNickname(@RequestBody PromemberDTO promemNickname) {
		System.out.println("닉네임 중복확인 controller");
		System.out.println(promemNickname.getPromemNickname());
		
		int promemNicknameCheckResult = registService.registCheckPromemNickname(promemNickname.getPromemNickname());
		return promemNicknameCheckResult + "";		// int -> String 으로 자료형 변환
	}
	

	@PostMapping("/regist-promember")
	public ModelAndView registProember(ModelAndView mv, PromemberDTO newPromember, RedirectAttributes rttr) {
		
		System.out.println ("promemNo : " + newPromember.getPromemNo());
		
		registService.registNewPromember(newPromember);
		
		rttr.addFlashAttribute("registSuccessMessage", "회원 가입에 성공하셨습니다.");
		mv.setViewName("/regist/regist-promem-success");
		
		return mv;
	}


}