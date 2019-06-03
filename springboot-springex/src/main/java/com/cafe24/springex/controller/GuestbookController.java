package com.cafe24.springex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 *  @RequestMapping
 *  type
 * 
 * */

//단독 Mapping
@Controller
@RequestMapping("/guestbook/*")
public class GuestbookController {
	
	@ResponseBody
	@RequestMapping  //guestbook/list로 받겠다.(method 이름을 url로 쓰겠다.)
	public String list() {
		return "GuestbookController/list";
	}
	

}
