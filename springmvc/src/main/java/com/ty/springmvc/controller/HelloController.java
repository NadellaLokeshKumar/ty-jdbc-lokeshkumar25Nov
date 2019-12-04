package com.ty.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	@RequestMapping(path = "/hello")
	public String hello(ModelMap map) {
		map.addAttribute("msg", "Hello World");
		return "index";
	}
}
