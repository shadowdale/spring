package com.gura.spring.users.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.gura.spring.users.service.UsersService;

// Component 스캔시 bean이 되고 또한 컨트롤러 역할을 할수 있도록
@Controller
public class UsersController {
	
	// 의존 객체 주입 되도록
	@Autowired
	private UsersService usersService;
	
	
}
