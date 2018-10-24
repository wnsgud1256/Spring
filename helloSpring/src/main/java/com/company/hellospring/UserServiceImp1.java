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
	//@Autowired UserDAOSpring dao;
	@Autowired UserDAOmybatis dao;
	@Override
	public int insertUser(UserDTO dto) {
		// TODO Auto-generated method stub
		System.out.println("값 삽입");
		/*dao.insertUser(dto);*/		//일부러 에러 2번 나도록 조작함.
		return dao.insertUser(dto); //이렇게 하면 한건은 들어가지만 유니크 에러가 걸림  트랜잭션 처리가 되어있으면 자동으로 롤백이됨. 
									//하지만 처리가 되어 있지 않으면 한건은 에러가 나지만 처음 입력된 한건은 삽입이 됨
	}

	@Override
	public UserDTO getUser(UserDTO dto) {
		// logAdvice.pringLog();
		return dao.getUser(dto);
	}

	@Override
	public List<UserDTO> getUsers(UserSearchDTO searchDto) {
		
		// TODO Auto-generated method stub
		// logAdvice.pringLog(); //횡단관심
		System.out.println("사용자 목록 조회");
		return dao.getUsers(searchDto); // 핵심관심
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

	@Override
	public int getCnt(UserSearchDTO searchDto) {
		// TODO Auto-generated method stub
		return dao.getCnt(searchDto);
	}

}
