package br.com.va4e.idac.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping("/")
	public String getIndex() {

		return "/member/members";
	}

	
	
	
	@RequestMapping("/test")
	public String getTest() {

		return "layout";
	}
	
	@GetMapping("/showMyLoginPage")
	public String showMyLoginPage() {

		return "login";
	}

}
