package com.company.hellospring;

import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOmybatis {

	@Autowired 
	SqlSessionTemplate mybatis;
	//전체조회
	public List<UserDTO> getUsers(UserSearchDTO dto){
		System.out.println("user mybatis 목록 조회==========");
		 return mybatis.selectList("user.getUsers",dto);
	}
	
	//건수 조회
	public int getCnt(UserSearchDTO searchDto) {			 //userMapper
		return mybatis.selectOne("user.getCnt",searchDto);
	}
	
	//단건조회
	public UserDTO getUser(UserDTO dto) {
		System.out.println("mybations 사용자 삭제");
		 return mybatis.selectOne("user.getUser",dto);
	}
	//등록
	public int insertUser(UserDTO dto) {
		System.out.println("mybations 사용자 등록");
		return mybatis.insert("user.insertUser", dto); //user mapper에서 참고해서 씀
	}
	//수정
	public int updateUser(UserDTO dto) {
		System.out.println("mybations 사용자 수정");
		return mybatis.update("user.updateUser", dto);
	}
	//삭제
	public int deleteUser(UserDTO dto) {
		System.out.println("mybations 사용자 삭제");
		return mybatis.delete("user.deleteUser", dto);
	}
}
