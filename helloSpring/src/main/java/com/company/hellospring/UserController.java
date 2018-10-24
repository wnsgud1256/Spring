package com.company.hellospring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.company.hellospring.common.Paging;

@Controller
public class UserController {

	@Autowired //DI(Dependency Injection)
	UserService userService;
	
	@RequestMapping("/getUsers.do")//URL요청
	public ModelAndView getUsers(ModelAndView mv  //ModelAndView 모델과 뷰의 객체가 함께 있는 것임
						  ,UserSearchDTO searchDto	//검색 조건들이 다 여기로 들어감
						  , Paging paging) {
		
		//조회할 레코드 건수
		paging.setPageUnit(3);
		
		//현재 페이지 번호 . 없으면 1페이지로 설정
		if(paging.getPage() ==null) {
			paging.setPage(1);
		}
		//전체 건수
		int total = userService.getCnt(searchDto);		//조건에 맞는 건수만 조회가됨.
		paging.setTotalRecord(total);
		mv.addObject("paging", paging); 
		
		//시작/마지막 레코드 번호
		searchDto.setStart(paging.getFirst());
		searchDto.setEnd(paging.getLast());
		mv.addObject("list",userService.getUsers(searchDto));
		
		mv.setViewName("user/getUsers");
		return mv; //뷰 페이지 명
	}
	//수정 폼
	@RequestMapping("/updateUserForm.do")//URL요청
	public String updateUserForm(Model model, UserDTO dto) {
		model.addAttribute("user",userService.getUser(dto)); 
		return "user/updateUser";
	}
	//수정처리
	@RequestMapping("/updateUser.do")//URL요청
	public String updateUser(Model model, UserDTO dto) {
		model.addAttribute("user",userService.updateUser(dto)); 
		return "redirect:/getUsers.do";
	}
	//등록폼
	@RequestMapping("/insertUserForm.do")
	public String insertUserFrom() {
		return "user/insertUser";
	}
	
	//등록처지
	@RequestMapping("/insertUser.do")//URL요청
	public String insertUser(Model model, UserDTO dto) {
		model.addAttribute("user",userService.insertUser(dto)); 
		return "redirect:/getUsers.do";
	}
	
}

