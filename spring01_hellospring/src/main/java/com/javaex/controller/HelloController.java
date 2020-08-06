package com.javaex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	@RequestMapping("/hello")
	public ModelAndView hello(@RequestParam(required=false, defaultValue="SPRING")String name) {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("message", "hello" + name);
		mav.setViewName("index");
		
		System.out.println("HelloController 호출");
		return mav;
	}
}
