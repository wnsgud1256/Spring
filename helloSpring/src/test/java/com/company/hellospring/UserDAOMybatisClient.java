package com.company.hellospring;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:servlet-context-test.xml")
public class UserDAOMybatisClient {

	@Autowired 
	public UserDAOmybatis dao;
	
	@Test
	public void getUserTest() {
		UserSearchDTO searchDto = new UserSearchDTO();
		searchDto.setStart(1);
		searchDto.setEnd(3);
		
		//String[] ids = {"a","b"};
		//searchDto.setIds(ids);
		//searchDto.setsearchCondition("name");
		//searchDto.setsearchKeyword("홍");
		
		//searchDto.setsearchCondition("id");
		//searchDto.setsearchKeyword("a");
		List<UserDTO> list = dao.getUsers(searchDto);
		for(UserDTO dto : list) {
			System.out.println(dto.getId() + ":" + dto.getName());
		}
	}
	
}
