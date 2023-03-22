package com.iamground.iam.common.controller;

import java.util.Random;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iamground.iam.common.service.CommonService;
import com.iamground.iam.repository.MemberRepository;


@Controller
@RequestMapping("/common")
public class CommonController {
	
	private final CommonService commonService;
	private MemberRepository memberRepository;
	private BCryptPasswordEncoder bcryptPasswordEncoder;
	
	@Autowired
	public CommonController(CommonService commonService,MemberRepository memberRepository, BCryptPasswordEncoder bcryptPasswordEncoder) {
		this.commonService = commonService;
		this.memberRepository =memberRepository;
		this.bcryptPasswordEncoder =bcryptPasswordEncoder;
	}
	
	@PostMapping(value="/idfind", produces="application/json; charset=UTF-8")
	@ResponseBody
	public JSONObject findidByMember(@RequestBody String data) {
		
		// JSONParser로 JSONObject로 변환
        JSONParser parser = new JSONParser();
        JSONObject jObj = new JSONObject();
        JSONObject rObj = new JSONObject();
        try {
			jObj = (JSONObject) parser.parse(data);
			
			System.out.println(">>"+jObj.get("memberName"));
			System.out.println(">>"+jObj.get("memberPhone"));
			String memId = commonService.findId(
					(String)jObj.get("memberName")
					,(String)jObj.get("memberPhone")
					);
			
			//id 찾기 service? 연결 후 return값 가져와서
			// return값을 비교한 후 찾기 성공 시
			//성공시
			if(memId != null && !memId.isEmpty()) {
				rObj.put("rCode", 100);
				rObj.put("rMessage", "가입하신 아이디는"+ memId +"입니다.");
			}else {
				//실패시
				rObj.put("rCode", 200);
				rObj.put("rMessage", "입력하신 회원정보가 없습니다.");
			}
						
			
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
        
        return rObj;
	}
	
	@PostMapping(value="/pwdfind", produces="application/json; charset=UTF-8")
	@ResponseBody
	public JSONObject findPwdByMember(@RequestBody String data) {
		
		
		
		// JSONParser로 JSONObject로 변환
        JSONParser parser = new JSONParser();
        JSONObject jObj = new JSONObject();
        JSONObject rObj = new JSONObject();
        try {
        	jObj = (JSONObject) parser.parse(data);
			
			System.out.println(">>"+jObj.get("pwId"));
			System.out.println(">>"+jObj.get("pwName"));
			String memPwd = commonService.findPwd(
					(String)jObj.get("pwId")
					,(String)jObj.get("pwName")
					);
			// pwd찾기 service 호출 후
			//성공시
			if(memPwd != null && !memPwd.isEmpty()) {
				//패스워드 랜덤문자열생성 8자이내(문자 + 숫자)
								
				//생성한 랜덤패스워드를 암호화 후  자바랜덤 문자열 찾아보기  
				Random ran = new Random();
				StringBuffer newPw = new StringBuffer();
				for(int i=0; i < 6; i++) {
					int index = ran.nextInt(3);
					switch(index) {
							case 0 : newPw.append((char)(ran.nextInt(26) + 97));
									break;
							case 1: newPw.append((char)(ran.nextInt(26) + 65));
									break;
							case 2: newPw.append(ran.nextInt(10));
									break;
									
					
					}
//					newPw +=((char)((int)(Math.random()*122)+97));
				}
				
				// 암호화한 패스워드를 pwd업데이트 서비스에 넘겨서 업데이트 시키기(사용자 id, 암호화한 패스워드) 예제 
				String password = newPw.toString();
				String encdoePassword;
				
				encdoePassword = bcryptPasswordEncoder.encode(password);

		        System.out.println("암호화된 비번: " + encdoePassword);
		        
		        commonService.updatePwd(encdoePassword, (String)jObj.get("pwId"), (String)jObj.get("pwName"));
		        //memberRepository.save(password);
		        
				
				rObj.put("rCode", 100);
				rObj.put("rMessage", "새로운 비밀번호["+password+"]로 로그인 하세요. 로그인후 비밀번호를 변경하시기 바랍니다.");
			}else {
				//실패시
				rObj.put("rCode", 200);
				rObj.put("rMessage", "입력하신 회원정보가 없습니다.");
			}
						
			
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
        
        return rObj;
	}
	
}
