package com.gura.spring.shop.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ShopDaoImpl implements ShopDao {

	@Autowired
	private SqlSession session;
	
	@Override
	public void deposit(String id, int money) {
		
		// 아이디와 금액을 Map애 담는다.
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		param.put("money", money);
		session.update("shop.deposit", param);
		
	}

	@Override
	public void withDraw(String id, int money) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		param.put("money", money);
		session.update("shop.withDraw", param);
		
	}

	@Override
	public void addPoint(String id, int point) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		param.put("point", point);
		session.update("shop.addPoint", param);
		
	}

	@Override
	public void deliveryReqest() {
		System.out.println("배송요청을 했습니다.");
		
	}

}
