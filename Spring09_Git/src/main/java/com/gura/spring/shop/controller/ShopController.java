package com.gura.spring.shop.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring.shop.service.ShopService;

@Controller
public class ShopController {
	
	@Autowired
	private ShopService shopService;
	
	@RequestMapping("/shop/index")
	public ModelAndView index(ModelAndView mView) {
		
		// 모델
		List<String> info = new ArrayList<String>();
		info.add("구정 특별 SALE");
		info.add("10%의 보너스 포인트를 적립해 드립니다.");
		info.add("기회를 놓치지 마세요");
		
		// 모델을 info라는 키값으로 담기
		mView.addObject("info", info);
		
		// view 페이지의 정보 담아서
		mView.setViewName("/shop/index");
		
		// 리턴해주기
		return mView;
	}
	
	// 입금 폼 요청처리
	@RequestMapping("/shop/depositform")
	public String depositForm() {
		
		return "/shop/depositform";
	}
	
	// 입금 요청처리
	@RequestMapping("/shop/deposit")
	public String deposit(@RequestParam String id, @RequestParam int cash) {
		
		// ShopService 객체를 이용해서 입금 작업을 한다.
		shopService.deposit(id, cash);
		return "redirect:/shop/index.do";
	}
	
	// 상품목록보기 요청처리
	@RequestMapping("/shop/list")
	public String list() {
		return "/shop/list";
	}
	
}
