package com.ysj.root.member.controllers;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ysj.root.member.dto.MemberDTO;
import com.ysj.root.member.service.MemberService;

@Controller
public class UserController {
	
	@Autowired 
	MemberService ms;
	
	@GetMapping(value = "loginView")
	public String loginView() {
		return "member/loginView";
	}
	
	//로그인 성공시 (세션값 완성, 로그인  결과 전달, 로그인후 메인 사이트 가야함)
	//  produces 에 설정한 값으로만 jsp요청 클라이언트에게 응답하겠다는 의미
	@PostMapping(value = "loginProc" , produces = "application/json;charset=utf-8")
	@ResponseBody
	public String loginProc(@RequestBody Map<String, Object> mapDto, HttpSession session) {
		System.out.println("loginProc 작동확인1");
		System.out.println(mapDto.get("id"));
		System.out.println(mapDto.get("pw"));
		
		String id = (String)mapDto.get("id") ;
		String pw = (String)mapDto.get("pw") ;
		
		int result = ms.UserLogin(id, pw);
		System.out.println(result);
		if(result ==1 ) {
			session.setAttribute("sessionId", id);
			return "{\"loginResult\" : true}";
		}else if( result ==0){
			return "{\"loginResult\" : \"pwFalse\"}";
		}
		return "{\"loginResult\" : false}";
	}
	
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	
	@GetMapping("joinView")
	public String joinView() {
		return "member/joinView";
	}
	@PostMapping("join")
	public String Join(MemberDTO dto) {
		int i = ms.UserSave(dto);
		System.out.println(i);
		// insert문은 올바른 값을 넣었을때 1을 출력 잊지말자
		if(i==1) {
			return "index";
		}else if(i==0){
			return "member/joinView";
		}else {
			//-1 다른 모종의 에러
		}
		return "index";
	}
	
}
