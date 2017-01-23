package com.gura.spring.cafe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring.cafe.dto.CafeDto;
import com.gura.spring.cafe.service.CafeService;

@Controller
public class CafeController {
	
	@Autowired
	private CafeService cafeService;
	
	// 글목록 보기 요청처리
	@RequestMapping("/cafe/list")
	public ModelAndView list() {
		
		// 글 목록이 담겨 있는 ModelAndView 객체를 리턴 받는다.
		ModelAndView mView =  cafeService.getList();
		
		// 뷰페이지의 정보 설정하고
		mView.setViewName("/cafe/list");
		
		// 리턴해준.
		return mView;
	}
	
	// 새글 저장 촘 요청처리
	@RequestMapping("/cafe/private/insertform")
	public String insertform() {
		 return "/cafe/private/insertform";
	}
	
	// 새글 저장 요청처리
	@RequestMapping("/cafe/private/insert")
	public String insert(@ModelAttribute CafeDto dto) {
		cafeService.insert(dto);
		return "redirect:/cafe/list.do";
	}
	
	// 글 자세히보기 요청처리
	@RequestMapping("/cafe/detail")
	public ModelAndView detail(@RequestParam int num) {
		ModelAndView mView = cafeService.getData(num);
		mView.setViewName("/cafe/detail");
		return mView;
	}
	
	// 글 삭제 요청처리
	@RequestMapping("/cafe/private/delete")
	public String delete(@RequestParam int num) {
		cafeService.delete(num);
		return "redirect:/cafe/list.do";
	}
	
}
