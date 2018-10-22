package com.company.hellospring;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
/*@ContextConfiguration(locations = {	"classpath:spring/common-context.xml", 
									"classpath:spring/datasource-context.xml", 
									"classpath:spring/mybatis-context.xml", 
									"classpath:spring/transaction-context.xml"}) 실행파일이 여러개 있을때 사용*/
							
@ContextConfiguration(locations = "classpath:applicationContext.xml") //클래스 패치는 자바 파일의 경로를 알려줌

public class UserDAOClient {
	
	//UserDAO테스트
	UserDAO dao;
	UserDTO dto;
	@Before
	public void before() {
		dao = new UserDAO();
		dto = new UserDTO();
		dto.setId("user1");
		dto.setPassword("user1");
	}
	
	@Test				//ignore 해당 어노테이션을 실행시키지 말라는 문구
	public void insertTest() {
		dto.setId("user3");
		dto.setPassword("user3");
		assertEquals(1, dao.insertUser(dto));
	}
	@Test
	public void getUserTest() {
	assertEquals("user1", dao.getUser(dto).getPassword()); //assertEquls단정 확정 하다는 뜻
	}
	
	public void getUsersTest() {
	assertNotNull("user1",dao.getUsers().get(0).getId());
	}
	
}
