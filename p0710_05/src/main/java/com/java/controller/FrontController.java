package com.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class FrontController {
	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	
	
	
}
