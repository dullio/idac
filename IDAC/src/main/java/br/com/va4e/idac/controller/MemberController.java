package br.com.va4e.idac.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	// @RequestMapping({"/", "/index"})
	 @RequestMapping("/list")
	public String getIndex(){
		
		return "member-list";
	}

}
