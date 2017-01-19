package com.gura.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


//컨트롤러로 만들기 위한 어노테이션
@Controller
public class HomeController {
	
	// "/home.do" 요청 처리
	@RequestMapping("/home") // 클라이언트의 요청 멥핑하기 위한 어노테이션
	public String home() {
		/*
		 *  리턴되는 data Type과 메소드명은 상황에 맞게 구성할수 있다.
		 *  
		 *  - 리턴 Type을 String으로 한다는 것의 의미
		 *    단, @ResponseBoby 어노테이션이 없다는 가정 하에서
		 *    
		 *    1. forward 이동 정보를 리턴해준다.
		 *    2. redirect 이동 정보를 리턴해준다.
		 */
		return "home";
	}
	
}
