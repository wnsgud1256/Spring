package com.company.hellospring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller //빈등록, 서블릿이 호출 하도록 설정
public class LoginController {

	@Autowired UserService userService;
	//로그인 폼으로 가는 기능
	@RequestMapping(value={"/login.do","in.do"},method=RequestMethod.GET)
	public String login( ) { 
		
		return "user/login";
	}
	
	//로그인 처리
	@RequestMapping(value="/login.do",method=RequestMethod.POST)
	public String loginProc(@ModelAttribute("user") UserDTO dto,					
							@RequestParam(value="id",required=false,defaultValue="admin") String userid, //required를 쓰면 에러가 안뜨고 null이뜸
							//디폴트 값은 admin이고 아이디를 넘기면 id값이 들어감, required=false는 파라미터가 안넘어오면 에러가뜸
							@RequestParam String password,//modelattribute를 쓰면 userdto가 dto로 저장되는게 아닌 user로 저장됨
							HttpSession session) {
	System.out.println("==========="+userid+ ":"+password); //값을 안넣으면 에러가 떠야 하는데 에러가 안뜸.
	UserDTO userDTO = userService.getUser(dto);
	if (userDTO ==null||											//아이디가 없거나
		!userDTO.getPassword().equals(dto.getPassword()) ) {		// 또는 DB에서 조회한 비밀번호와 일치하지 않는경우
		return "user/login";
	} else {
		session.setAttribute("login", userDTO); //로그인이되면 회원 목록으로 감.
		return "redirect:getUsers.do";
	}

}
	//로그아웃처리
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		session.invalidate(); //세션을 무효화 함
		return "user/login";
	}
}

/*UserDTO dto,
HttpSession session,
HttpServletRequest request <- WAS가 제공 하는 것들*/