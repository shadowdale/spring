package com.gura.spring.users.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring.users.dao.UsersDao;
import com.gura.spring.users.dto.UsersDto;

// Component
@Component
public class UsersServiceImpl implements UsersService{
	
	// 비밀번호 인코더 객체
	private PasswordEncoder pEncoder = new BCryptPasswordEncoder();
	
	// 의존 객체 주입 되도록
	@Autowired
	private UsersDao usersDao;
	
	@Override
	public void insert(UsersDto dto) {
		// 암호화 된 비밀번호를 얻어낸다.
		String encodedPwd = pEncoder.encode(dto.getPwd());
		
		// Dto 객체에 다시 넣어준다.
		dto.setPwd(encodedPwd);
				
		usersDao.insert(dto);
		
	}

	@Override
	public boolean isValid(UsersDto dto) {
		
		// 아이디가 유효한지 여부
		boolean isValid = false;
		// 아이디에 해당하는 DB에 저장된 암호화된 비밀번호를 읽어온다.
		String password = usersDao.getPassword(dto.getId());
		
		if(password != null) { // 아이디가 일단 존재 하는 경우
			
			// .maches(사용자가 입력한 비밀번호, DB에 저장된 암호롸 비밀번호)
			// 를 이용해서 비밀번호가 맞는지 여부를 boolean Type으로 리턴받기
			isValid = pEncoder.matches(dto.getPwd(), password);
		}
		return isValid;
		
	}

	@Override
	public void update(UsersDto dto) {
		
		// 암호화 된 비밀번호를 얻어낸다.
		String encodedPwd = pEncoder.encode(dto.getPwd());
		
		// Dto 객체에 다시 넣어준다.
		dto.setPwd(encodedPwd);
		
		usersDao.update(dto);
		
	}

	@Override
	public void delete(String id) {
		usersDao.delete(id);
		
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
