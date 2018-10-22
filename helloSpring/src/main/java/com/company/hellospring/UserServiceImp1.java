package com.company.hellospring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.hellospring.common.Log4jAdvice;

@Service
public class UserServiceImp1 implements UserService {

	Log4jAdvice logAdvice = new Log4jAdvice();

	// LogAdvice logAdvice = new LogAdvice();
	// DI
	@Autowired UserDAOSpring dao;
	
	@Override
	public int insertUser(UserDTO dto) {
		// TODO Auto-generated method stub
		System.out.println("값 삽입");
		return dao.insertUser(dto);
	}

	@Override
	public UserDTO getUser(UserDTO dto) {
		// logAdvice.pringLog();
		return dao.getUser(dto);
	}

	@Override
	public List<UserDTO> getUsers() {
		
		// TODO Auto-generated method stub
		// logAdvice.pringLog(); //횡단관심
		System.out.println("사용자 목록 조회");
		return dao.getUsers(); // 핵심관심
	}

	@Override
	public int updateUser(UserDTO dto) {
		// TODO Auto-generated method stub
		System.out.println("업데이트");
		return dao.updateUser(dto);// dao.updateUser();
	}

	@Override
	public int deleteUser(UserDTO dto) {
		// TODO Auto-generated method stub
		System.out.println("삭제");
		return dao.deleteUser(dto);// dao.deleteUser();
	}

}
