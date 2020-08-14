package com.emaillist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/emaillist")
public class EmaillistController {
	
	@RequestMapping("/form")
	public String form() {
		return null;
	}
	
	@RequestMapping("/list")
	public String list() {
		return null;
	}
	
	/*
	 * @RequestMapping("/delete") public String delete() { return null; }
	 * 
	 * @RequestMapping("/list") public String list() { return null; }
	 */
}
