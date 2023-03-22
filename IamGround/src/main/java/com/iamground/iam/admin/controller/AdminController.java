package com.iamground.iam.admin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.iamground.iam.admin.service.AdminService;
import com.iamground.iam.member.DTO.MemberAndMemberRoleDTO;
import com.iamground.iam.member.paging.Pagenation;
import com.iamground.iam.member.paging.SelectCriteria;


@Controller
@RequestMapping("/adminpage")
public class AdminController {
	
	private final AdminService adminService;
	
	@Autowired
	public AdminController(AdminService adminService) {
		this.adminService = adminService;
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
			
			int totalCount = adminService.selectTotalCount(searchCondition, searchValue);

			/* 한 페이지에 보여 줄 게시물 수 */
			int limit = 10;		//얘도 파라미터로 전달받아도 된다.

			/* 한 번에 보여질 페이징 버튼의 갯수 */
			int buttonAmount = 5;

			/* 페이징 처리를 위한 로직 호출 후 페이징 처리에 관한 정보를 담고 있는 인스턴스를 반환받는다. */
			SelectCriteria selectCriteria = null;
			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchCondition, searchValue);

			if(StringUtils.isNotBlank(searchCondition) && searchCondition.equals("2")) {
				//전문가회원검색
				List memberList = adminService.searchMemberList(selectCriteria);
				for(int i=0; memberList.size() > i; i++) {
					System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>"+memberList.get(i));
				}
				mv.addObject("adminList", memberList);
				mv.addObject("selectCriteria", selectCriteria);
				mv.setViewName("adminpage/search");
			}else {
				//일반회원 검색
				System.out.println(">?sdafds");
				List<MemberAndMemberRoleDTO> memberList = adminService.searchMemberList(selectCriteria);
				mv.addObject("adminList", memberList);
				mv.addObject("selectCriteria", selectCriteria);
				mv.setViewName("adminpage/search");
			}

			return mv;
		}
	
	@PostMapping(value="/promemOk", produces="application/json; charset=UTF-8")
	@ResponseBody
	public JSONObject promemOk(@RequestBody String data) {
		
		// JSONParser로 JSONObject로 변환
        JSONParser parser = new JSONParser();
        JSONObject jObj = new JSONObject();
        JSONObject rObj = new JSONObject();
        try {
			jObj = (JSONObject) parser.parse(data);
			
			System.out.println(">>"+jObj.get("promemNo"));
						
			int promem = adminService.promemOk(jObj.get("promemNo").toString());
			
			if(promem != 0) {
				rObj.put("rCode", 100);
				rObj.put("rMessage", "승인완료 되었습니다.");
			}else {
				//실패시
				rObj.put("rCode", 200);
				rObj.put("rMessage", "승인이 실패하였습니다.");
			}
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
        
        return rObj;
	}
	
	
}
