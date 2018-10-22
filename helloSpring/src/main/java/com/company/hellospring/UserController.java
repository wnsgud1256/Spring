package com.company.hellospring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

	@Autowired //DI(Dependency Injection)
	UserService userService;
	
	@RequestMapping("/getUsers.do")//URL요청
	public String getUsers(Model model) {
		model.addAttribute("list",userService.getUsers()); 
		return "user/getUsers"; //뷰 페이지 명
	}
	//수정 폼
	@RequestMapping("/updateUserForm.do")//URL요청
	public String updateUserForm(Model model, UserDTO dto) {
		model.addAttribute("user",userService.getUser(dto)); 
		return "user/updateUser";
	}
	
	@RequestMapping("/updateUser.do")//URL요청
	public String updateUser(Model model, UserDTO dto) {
		model.addAttribute("user",userService.updateUser(dto)); 
		return "redirect:/getUsers.do";
	}
	
}

