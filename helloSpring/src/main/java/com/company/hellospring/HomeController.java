package com.company.hellospring;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

import javax.swing.text.TabableView;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import polymorphism.coupling.TV;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/*@Autowired TV  tv;*/ //객체생성해 달라는 요청 root context에 요청을 보넴
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET) //URL 요청이 들어오면 
	public String home(Locale locale, Model model) { // 이 메소드가 실행됨
		logger.info("Welcome home! The client locale is {}.", locale);
		
	/*	tv.powerOn();*/
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate ); //setAttribute
		
		return "home";
	}
	
	
	@RequestMapping("/board.do")
	public String board(UserBean user) { //해당 파라미터를 bean에 담음
		System.out.println(user.getId()+"===========");
		return "board";
	
	}
	
	@RequestMapping("/LoginCheck.do")
	@ResponseBody
	public HashMap<String, Object> dupcheck(UserBean user) { //Bean와 map을 같은 구조로 인식함.
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("userid", user.getId());
		if(user.getId().equals("admin")) {
			map.put("result",false);
		}else {
			map.put("result",true);
		}
		return map;
	}
	@RequestMapping("/LoginCheckXml.do")
	@ResponseBody
	public UserBean dupcheckXml(UserBean user) {

	if(user.getId().equals("admin")) {
		user.setResult(false);
	}else {
		user.setResult(true);
	}
	return user;
	}
}
