package com.iamground.iam.mypage.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.security.Principal;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.iamground.iam.mypage.DTO.MypageMemDTO;
import com.iamground.iam.mypage.DTO.MypagePromemDTO;
import com.iamground.iam.mypage.entity.MypageMem;
import com.iamground.iam.mypage.entity.MypagePromemAndProfile;
import com.iamground.iam.mypage.service.MypageService;

@Controller
@RequestMapping("/mypage")
public class MypageController {
	private final MypageService mypageService;
	
	@Autowired
	public MypageController(MypageService mypageService) {
		this.mypageService = mypageService;
	}
	
	/* 일반회원 마이페이지 */
	@PostMapping("/mypage-mem")
	public ModelAndView mypageMem(ModelAndView mv, Principal principal, RedirectAttributes rttr) {
		
		MypageMem memInfo = mypageService.mypageMem(principal.getName());
		mv.addObject("memInfo", memInfo);
		
		mv.setViewName("mypage/mypage-mem");
		
		return mv;
	}
	
	/* 전문가회원(승인 전) 마이페이지 */
	@GetMapping("/mypage-promem-before")
	public ModelAndView mypagePromemBefore(ModelAndView mv, Principal principal, RedirectAttributes rttr) {
		System.out.println(principal.getName());
		MypagePromemAndProfile promemInfo = mypageService.mypagePromemBefore(principal.getName());
		mv.addObject("promemInfo", promemInfo);
		
		return mv;
	}
	
	/* 전문가회원(승인 후) 마이페이지 */
	@GetMapping("/mypage-promem-after")
	public ModelAndView mypagePromemAfter(ModelAndView mv, Principal principal, RedirectAttributes rttr) {
		MypagePromemAndProfile promemInfo = mypageService.mypagePromemBefore(principal.getName());
		mv.addObject("promemInfo", promemInfo);
		
		return mv;
	}
	
	/* 프로필 사진 띄우기 */
	@GetMapping("profileImg")
	@ResponseBody
	public void profileImg(HttpServletRequest request, HttpServletResponse response) {
		  
		// path -> yml에 location 설정 똑같이 해주기 
		String path = "C:\\ProjectUploadFile";
		String imgName = request.getParameter("imgName");
		String extension = imgName.substring(imgName.lastIndexOf(".")+1);
		
	    ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
	    
	    try {
	 
	      //이미지 파일 읽기
	      File file = new File(path + imgName);
	      
	     System.out.println ("filPath : " + file.exists());
	     System.out.println ("extension : " + extension);
	 
	      BufferedImage image = ImageIO.read(file);
	 
	 
	      ImageIO.write(image, extension, jpegOutputStream);
	 
	    byte[] imgByte = jpegOutputStream.toByteArray();
		 
	    response.setHeader("Cache-Control", "no-store");
	    response.setHeader("Pragma", "no-cache");
	    response.setDateHeader("Expires", 0);
	    response.setContentType("image/jpeg");
	    ServletOutputStream responseOutputStream = response.getOutputStream();
	    responseOutputStream.write(imgByte);
	    responseOutputStream.flush();
	    responseOutputStream.close();
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	 
	}
	
	/* 업체 사진 띄우기 */
	@GetMapping("companyImg")
	@ResponseBody
	public void companyImg(HttpServletRequest request, HttpServletResponse response) {
		  
		// path -> yml에 location 설정 똑같이 해주기 
		String path = "C:\\ProjectUploadFile";
		String imgName = request.getParameter("imgName");
		String extension = imgName.substring(imgName.lastIndexOf(".")+1);
		
	    ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
	    
	    try {
	 
	      //이미지 파일 읽기
	      File file = new File(path + imgName);
	      
	     System.out.println ("filPath : " + file.exists());
	     System.out.println ("extension : " + extension);
	 
	      BufferedImage image = ImageIO.read(file);
	 
	 
	      ImageIO.write(image, extension, jpegOutputStream);
	 
	    byte[] imgByte = jpegOutputStream.toByteArray();
		 
	    response.setHeader("Cache-Control", "no-store");
	    response.setHeader("Pragma", "no-cache");
	    response.setDateHeader("Expires", 0);
	    response.setContentType("image/jpeg");
	    ServletOutputStream responseOutputStream = response.getOutputStream();
	    responseOutputStream.write(imgByte);
	    responseOutputStream.flush();
	    responseOutputStream.close();
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	}	 
	
	/* 일반회원 마이페이지 수정 페이지 */
	@PostMapping("/mypage-mem-updatePage")
	public ModelAndView memUpdatePage(ModelAndView mv, Principal principal, RedirectAttributes rttr) {
		MypageMem memInfo = mypageService.mypageMem(principal.getName());
		mv.addObject("memInfo", memInfo);
		
		mv.setViewName("mypage/mypage-mem-update");
		
		return mv;
	}
	
	/* 일반회원 마이페이지 수정 */
	@PostMapping("/mypage-mem-update")
	public ModelAndView memUpdate(ModelAndView mv, MypageMemDTO memUpdate, Principal principal, RedirectAttributes rttr) {
		System.out.println("controller동작!!!!!!");
		mypageService.memUpdate(memUpdate, principal);
		rttr.addAttribute("updateSuccessMessage","회원정보가 수정되었습니다.");
		mv.setViewName("mypage/mypage-mem");
		
		return mv;
	}
	
	/* 페이지 추가해야함.. */
	/* 전문가회원(승인 전) 마이페이지 수정 */
	@PostMapping("/mypage-promem-before-update")
	public ModelAndView promemBeforeUpdate(ModelAndView mv, MypagePromemDTO promemBeforeUpdate, RedirectAttributes rttr) {
		
		mypageService.promemUpdate(promemBeforeUpdate);
		rttr.addAttribute("updateSuccessMessage","회원정보가 수정되었습니다.");
		mv.setViewName("/mypage/mypage-promem-before");
		
		return mv;
	}
	
	/* 페이지 추가해야함.. */
	/* 전문가회원(승인 후) 마이페이지 수정 */
	@PostMapping("/mypage-promem-after-update")
	public ModelAndView promemAfterUpdate(ModelAndView mv, MypagePromemDTO promemAfterUpdate, RedirectAttributes rttr) {
		
		mypageService.promemUpdate(promemAfterUpdate);
		rttr.addAttribute("updateSuccessMessage","회원정보가 수정되었습니다.");
		mv.setViewName("/mypage/mypage-promem-After");
		
		return mv;
	}
	
	/* 마이페이지 클릭 시 권한 체크 */
	@PostMapping("checkId")
	@ResponseBody
	public String checkId(Principal principal) {
		
		int memIdCheckResult = mypageService.mypageCheckMemId(principal.getName());
		String	src			= null;
		
		if (memIdCheckResult == 1) {
			src = "mypage/mypage-mem";
		} else if(memIdCheckResult == 2){
			src ="mypage/mypage-promem-before";
		} else {

			src ="mypage/mypage-promem-after";
		}

		return src;
	}
	
	
}