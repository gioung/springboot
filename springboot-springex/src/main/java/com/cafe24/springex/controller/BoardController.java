package com.cafe24.springex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 * 
 * @RequestMapping
 * Method 단독매핑
 * 
 * */


@Controller

public class BoardController {
	
	@ResponseBody
	@RequestMapping("/board/update") //param값이 없으면 default값이 없으므로 400응답이 뜸. 
	public String update(
			//String name
			//@RequestParam String name
			//밑에것이 정석 위에는 스프링이 알아서 추측
			@RequestParam("name") String name) {
		System.out.println("---"+name+"---");
		return "BoardController:update()";
	}
	
	
	@ResponseBody
	@RequestMapping("/board/write") //required 는 default가 true, false 는 오류안남
	public String write(@RequestParam(value="n",required=true, defaultValue="")String name,
			@RequestParam(value="age",required=true, defaultValue="0")int age) {
		    //String 형식인 param을 age로 바꿔줌.
		System.out.println("---"+name+"---");
		System.out.println("---"+age+"---");
		return "BoardController:write()";
	}

	@ResponseBody
	@RequestMapping("/board/view/{no}")
	//http://localhost:8080/springex01/board/view?no=10 
	// => http://localhost:8080/springex01/board/view/10
	public String view(@PathVariable(value="no")Long no) {
		
		
		return "BoardController:view("+no+")";
	}
	
	
	
}
