package com.company.hellospring.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {
	@Autowired
	BoardService boardservice;
	
	@RequestMapping("/getBoards.do") //리퀘스트 맵핑 덕에 자동으로 맵핑 정보가 관리됨
	public String getBoards(Model model) {
		model.addAttribute("list",boardservice.getboards());
		return "Board/getBoards";
	}

}
