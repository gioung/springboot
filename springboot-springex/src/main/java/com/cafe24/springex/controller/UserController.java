package com.cafe24.springex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
 *  @RequestMapping
 *  type+method
 * 
 * */


@Controller
@RequestMapping("/user") //type 
public class UserController {
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	// @GetMappping("/join") 완전동일
	public String join() {
		return "/WEB-INF/views/join.jsp";
	}

	/*@ResponseBody //메세지임. RESPONSEBODY에 붙어나간다는 뜻.
	@RequestMapping(value="/join", method=RequestMethod.GET)
	// @GetMappping("/join") 완전동일
	public String joinform() {
		return "UserController:join(GET)";
	}*/
	
	
	//@ResponseBody //메세지임. RESPONSEBODY에 붙어나간다는 뜻.
	@RequestMapping(value= {"/join","/j"}, method=RequestMethod.POST)
	//밑에 매개변수는 관례로 스프링에서 알아서 requestparam 매핑을 해줌. 
	// @PostMappping("/join") 완전동일
	public String join(@ModelAttribute UserVo userVo) { //client쪽에서 쿼리파라미터형식인데 어떻게?
		
		if(valid(userVo) == false) {
			return "/WEB-INF/views/join.jsp";
		}
		System.out.println(userVo);
		
		return "redirect:/hello";
	}
	
	private boolean valid(UserVo userVo) {
		return false;
	}
	
	
}
