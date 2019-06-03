package com.cafe24.springex.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HelloController {
		@RequestMapping("/hello")
		public String hello() {
			return "/WEB-INF/views/hello.jsp";
			
		}
		
		
		@RequestMapping("/hello2")
		public ModelAndView hello2() {
			ModelAndView mav = new ModelAndView();
			//request setAttribute 랑 비슷함
			mav.addObject("email", "gioung9833@gmail.com");
			mav.setViewName("/WEB-INF/views/hello.jsp");
			
			
			return mav;
		}
		@RequestMapping("/hello3")
		public String hello3(Model model) {
			//모델 객체가 어딘가 초기화되어 있다는 증거
			model.addAttribute("email","duli@gmail.com");
			return "/WEB-INF/views/hello.jsp";
		}
		
		@RequestMapping("/hello4") //밑에 어노테이션은 request param을 이용 
		public String hello4(Model model ,@RequestParam(value="email") String email,
				@RequestParam String name /*Annotaion의 value 생략시 매개변수 name으로 추측*/) {
			//모델 객체가 어딘가 초기화되어 있다는 증거
			model.addAttribute("email",email);
			return "/WEB-INF/views/hello.jsp";
		}
		
		/*기술이 침투 했기 때문에 비추천 (Servlet 기술)*/
		@RequestMapping("/hello5") //밑에 어노테이션은 request param을 이용 
		public String hello5(Model model,HttpServletRequest request) {
			request.getParameter("email");
			request.getParameter("name");
			return "/WEB-INF/views/hello.jsp";
		}
		
}
