package com.company.hellospring.board;

import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAOmybatis {

	@Autowired 
	SqlSessionTemplate mybatis;
	//전체조회
	public List<BoardDTO> getBoards(){
		System.out.println("board mybatis 목록 조회==========");
		 return mybatis.selectList("board.getBoards");
	}
	
}
