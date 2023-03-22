package com.iamground.iam.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.iamground.iam.board.dto.BoardDTO;
import com.iamground.iam.board.paging.Pagenation;
import com.iamground.iam.board.paging.SelectCriteria;
import com.iamground.iam.board.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

	private final BoardService boardService;

	@Autowired
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	/* 디테일 페이지 */
	@GetMapping("/{boardNo}")
	public ModelAndView boardDetail(ModelAndView mv, @PathVariable int boardNo) {

		BoardDTO board = boardService.boardDetail(boardNo);
		System.out.println("========================="+board);
		mv.addObject("board", board);
		mv.setViewName("/board/detail");

		return mv;
	}

	/* 게시판 전체보기 핸들러 */
	@GetMapping("/list")
	public ModelAndView findBoardList(ModelAndView mv, HttpServletRequest request) {
		
		List<BoardDTO> boardList = boardService.findBoardList();
		
		String currentPage = request.getParameter("currentPage");
		int pageNo = 1;
		
		if(currentPage != null && !"".equals(currentPage)) {
			pageNo = Integer.parseInt(currentPage);
		}

		String searchCondition = request.getParameter("searchCondition");
		String searchValue = request.getParameter("searchValue");
	
		int totalCount = boardService.selectTotalCount(searchCondition, searchValue);
		
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
		
		
		List<BoardDTO> boardList1 = boardService.searchBoardList(selectCriteria);
		
		for(BoardDTO board : boardList) {
			System.out.println(board);
		}

		mv.addObject("boardList", boardList1);
		
		mv.addObject("selectCriteria", selectCriteria);
		mv.setViewName("board/list");

		
		return mv;
	}

	/* 새글쓰기 */
	@GetMapping("/regist")
	public void registPage() {
	}

	@GetMapping(value = "/category", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String findCategoryList() {

		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss:SSS") // 원하는 날짜 포맷으로 변환
				.setPrettyPrinting() // JSON 문자열 이쁘게 출력
				.setFieldNamingPolicy(FieldNamingPolicy.IDENTITY) // 네이밍 규칙(기본은 낙타봉 표기법)
				.serializeNulls() // 필드 값이 null이라도 직렬화
				.disableHtmlEscaping() /// 태그를 그대로 적용시킴 // 직렬화 시 escaping을 하지 않고 태그를 그대로 살림
				.create(); // Gson 객체로 변환

		return gson.toJson(boardService.findAllCategory());
	} // gson.toJson 점프를 사용하여 json으로 변환, findAllCategory 서비스로

	@PostMapping("/regist")
	public ModelAndView registBoard(ModelAndView mv, BoardDTO newBoard, RedirectAttributes rttr) {
		boardService.registNewBoard(newBoard);
		rttr.addFlashAttribute("registSuccessMessage", "글 작성 완료");
		mv.setViewName("redirect:/board/list");
		return mv;
	}

	/* 게시글 수정 */
	@GetMapping("/modify")
	public ModelAndView modifyBoard(ModelAndView mv, BoardDTO board) {
		System.out.println("들고온 게시판 정보" + board);
		mv.addObject("board", board);
		mv.setViewName("/board/Modify");
		return mv;
	}

	@PostMapping("/modify")
	public ModelAndView modifyBoard(ModelAndView mv, RedirectAttributes rttr, @ModelAttribute BoardDTO board) {

		boardService.modifyBoard(board);

		rttr.addFlashAttribute("modifySuccessMessage", "글 수정에 성공하셨습니다");
		mv.setViewName("redirect:/board/" + board.getBoardNo());
		return mv;
	}

	/* 삭제 */
	@DeleteMapping("/{boardNo}") /*
									 * 유동적으로 변하는 PathVariable을 처리하는 방법, URL 매핑부분에 {변수} 처리를 해주면 메서드
									 * 파라미터로 @PathVariable("변수")이렇게 받을 수 있다
									 */
	public String delete(@PathVariable("boardNo") int boardNo) {
		boardService.delete(boardNo);
		return "redirect:/board/list";
	}
	
	@GetMapping("/search")
	public ModelAndView searchPage(HttpServletRequest request, ModelAndView mv) {

		String currentPage = request.getParameter("currentPage");
		int pageNo = 1;

		if(currentPage != null && !"".equals(currentPage)) {
			pageNo = Integer.parseInt(currentPage);
		}

		String searchCondition = request.getParameter("searchCondition");
		String searchValue = request.getParameter("searchValue");

		int totalCount = boardService.selectTotalCount(searchCondition, searchValue);

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

		List<BoardDTO> boardList = boardService.searchBoardList(selectCriteria);

		for(BoardDTO board : boardList) {
			System.out.println(board);
		}

		mv.addObject("boardList", boardList);
		mv.addObject("selectCriteria", selectCriteria);
		mv.setViewName("board/list");

		return mv;
	}
}
