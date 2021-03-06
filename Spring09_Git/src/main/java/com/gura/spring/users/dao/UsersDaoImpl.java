package com.gura.spring.users.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gura.spring.users.dto.UsersDto;

// Component 스캔시 bean으로 만들기 위한 어노테이션
@Repository
public class UsersDaoImpl implements UsersDao {
	
	@Autowired // 의존객체를 주입 받기 위한 어노 테이션
	private SqlSession session;
	
	@Override
	public void insert(UsersDto dto) {
		session.insert("users.insert", dto);
		
	}

	// 인자로 전달된 아이디에 해당하는 비밀번호를 리턴해주는 메소드
	@Override
	public String getPassword(String id) {
		String password = session.selectOne("users.getPwd", id);
		return password;
	}

	@Override
	public void update(UsersDto dto) {
		session.update("users.update", dto);
		
	}

	@Override
	public void delete(String id) {
		session.delete("users.delete", id);
		
	}

	@Override
	public boolean canUseId(String id) {
		String selectId = session.selectOne("users.isExistId", id);
		if(selectId == null) { // 없으면
			return true; // 사용가능한 아이디 이다.
		} else {
			return false;			
		}
	}

	@Override
	public UsersDto getData(String id) {
		UsersDto dto = session.selectOne("users.getData", id);
		return dto;
	}

}
