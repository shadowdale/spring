package com.gura.spring.users.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring.users.dao.UsersDao;
import com.gura.spring.users.dto.UsersDto;

// Component
@Component
public class UsersServiceImpl implements UsersService{
	
	// 의존 객체 주입 되도록
	@Autowired
	private UsersDao usersDao;
	
	@Override
	public void insert(UsersDto dto) {
		usersDao.insert(dto);
		
	}

	@Override
	public boolean isValid(UsersDto dto) {
		return usersDao.isValid(dto);
	}

	@Override
	public void update(UsersDto dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Map<String, Object> canUseId(String id) {
		// 아이디 사용가능 여부를 리턴 받는다.
		boolean canUse = usersDao.canUseId(id);
		
		// 결과 값을 Map에 담는다.
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("canUse", canUse);
		
		return map;
	}

	@Override
	public ModelAndView getData(String id) {
		
		// Dao를 이용해서 회원정보를 얻어온다.
		UsersDto dto = usersDao.getData(id);
		
		// ModelAndView객체를 생성해서
		ModelAndView mView = new ModelAndView();
		
		// 회원정보를 "dto"라는 키값으로 담는다.(request에 자동으로 담긴다.)
		mView.addObject("dto", dto);
		
		// ModelAndVIew 객체를 리턴해준다.
		return mView;
	}

}
