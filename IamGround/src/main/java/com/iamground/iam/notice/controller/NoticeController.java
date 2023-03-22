package com.iamground.iam.notice.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.iamground.iam.notice.dto.NoticeDTO;
import com.iamground.iam.notice.dto.NoticeFileAndNoticeDTO;
import com.iamground.iam.notice.paging.Pagenation;
import com.iamground.iam.notice.paging.SelectCriteria;
import com.iamground.iam.notice.service.NoticeService;

@Controller
@RequestMapping("/notice")
public class NoticeController {

	private final NoticeService noticeService;
	
	/* service 연결 */
	@Autowired
	public NoticeController(NoticeService noticeService) {
		this.noticeService = noticeService;
	}
	
	/* noticeService의 메소드를 통해 공지사항 리스트를 가져옴 */
	@GetMapping("/list")
	public ModelAndView findNoticeList(ModelAndView mv, HttpServletRequest request) {
		
		List<NoticeDTO> noticeList = noticeService.findNoticeList();
		
		String currentPage = request.getParameter("currentPage");
		int pageNo = 1;
		
		if(currentPage != null && !"".equals(currentPage)) {
			pageNo = Integer.parseInt(currentPage);
		}

		String searchCondition = request.getParameter("searchCondition");
		String searchValue = request.getParameter("searchValue");
	
		int totalCount = noticeService.selectTotalCount(searchCondition, searchValue);
		
		/* 한 페이지에 보여 줄 게시물 수 */
		int limit = 10;		//얘도 파라미터로 전달받아도 된다.

		/* 한 번에 보여질 페이징 버튼의 갯수 */
		int buttonAmount = 5;
		
		/* 페이징 처리를 위한 로직 호출 후 페이징 처리에 관한 정보를 담고 있는 인스턴스를 반환받는다. */
		SelectCriteria selectCriteria = null;
		if(searchValue != null && !"".equals(searchValue)) {
			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchCondition, searchValue);
		} else {
			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);
		}
		
		
		List<NoticeDTO> noticeList1 = noticeService.searchNoticeList(selectCriteria);
		
		for(NoticeDTO notice : noticeList) {
			System.out.println(notice);
		}

		mv.addObject("noticeList", noticeList1);
		
		mv.addObject("selectCriteria", selectCriteria);
		mv.setViewName("notice/list");

		
		return mv;
	}
	
	/* write 화면단 연결 */
	@GetMapping("/write")
	public void writepage() {}
	
	/* 게시글 등록 */
	@PostMapping("/write")
	public ModelAndView writeNotice(ModelAndView mv, NoticeDTO newNotice, RedirectAttributes rttr) {
		
		noticeService.writeNotice(newNotice);
		
		rttr.addFlashAttribute("writeSuccessMessage", "공지사항 등록에 성공하셨습니다");
		mv.setViewName("redirect:/notice/list");
		
		return mv;
	}
	
	/* 상세 조회 */
	@GetMapping("/{noticeNo}")
	public ModelAndView noticeDetail(ModelAndView mv, @PathVariable int noticeNo) {
		
		NoticeDTO notice = noticeService.noticeDetail(noticeNo);
		
		mv.addObject("notice", notice);
		mv.setViewName("/notice/detail");
		
		return mv;
	}
	
	
	/* 게시글 수정 */
	@PostMapping("/modify")
	public String modifyNotice(RedirectAttributes rttr, @ModelAttribute NoticeDTO notice) {
		System.out.println("수정할 공지사항 번호와 수정할 값: " + notice);
		
		noticeService.modifyNotice(notice);
		
		rttr.addFlashAttribute("modifySuccessMessage", "메뉴 수정에 성공하셨습니다");
		
		return "redirect:/notice/" + notice.getNoticeNo();
	}
	
	/* 게시글 삭제 */
	@PostMapping("/delete")
	public String deleteNotice(RedirectAttributes rttr, @ModelAttribute NoticeDTO notice) {
		System.out.println("삭제할 공지사항 변호와 값들: " + notice);
		
		noticeService.deleteNotice(notice);
		
		return "redirect:/notice/list";
	}
	
	
	/* 페이징 처리 및 검색 */
	@GetMapping("/search")
	public ModelAndView searchPage(HttpServletRequest request, ModelAndView mv) {

		String currentPage = request.getParameter("currentPage");
		int pageNo = 1;
		
		if(currentPage != null && !"".equals(currentPage)) {
			pageNo = Integer.parseInt(currentPage);
		}

		String searchCondition = request.getParameter("searchCondition");
		String searchValue = request.getParameter("searchValue");
	
		int totalCount = noticeService.selectTotalCount(searchCondition, searchValue);
		
		/* 한 페이지에 보여 줄 게시물 수 */
		int limit = 10;		//얘도 파라미터로 전달받아도 된다.

		/* 한 번에 보여질 페이징 버튼의 갯수 */
		int buttonAmount = 5;
		
		/* 페이징 처리를 위한 로직 호출 후 페이징 처리에 관한 정보를 담고 있는 인스턴스를 반환받는다. */
		SelectCriteria selectCriteria = null;
		if(searchValue != null && !"".equals(searchValue)) {
			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchCondition, searchValue);
		} else {
			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);
		}
		System.out.println(selectCriteria);
		
		List<NoticeDTO> noticeList = noticeService.searchNoticeList(selectCriteria);
		
		for(NoticeDTO notice : noticeList) {
			System.out.println(notice);
		}

		mv.addObject("noticeList", noticeList);
		mv.addObject("selectCriteria", selectCriteria);
		mv.setViewName("notice/list");
		
		return mv;
	}
	

		
	
}
