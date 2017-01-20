package com.gura.spring.users.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gura.spring.users.service.UsersService;

// Component 스캔시 bean이 되고 또한 컨트롤러 역할을 할수 있도록
@Controller
public class UsersController {
	
	// 의존 객체 주입 되도록
	@Autowired
	private UsersService usersService;
	
	// 
	@RequestMapping("/users/checkid")
	@ResponseBody
	public Map<String, Object> checkid(@RequestParam String inputId) {
		Map<String, Object> map = usersService.canUseId(inputId);
		// json 문자열 응답하기
		return map;
	}
	
	// 회원 가입 폼 요청 처리
	@RequestMapping("/users/signup_form")
	public String signupForm() {
		
		return "users/signup_form";
	}
	
}