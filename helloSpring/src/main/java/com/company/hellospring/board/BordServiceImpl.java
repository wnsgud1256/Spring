package com.company.hellospring.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BordServiceImpl implements BoardService{

	@Autowired BoardDAOmybatis dao;
	
	@Override
	public List<BoardDTO> getboards() {
		// TODO Auto-generated method stub
		System.out.println("[board목록 조회 ]");
		return dao.getBoards();
	}

}
