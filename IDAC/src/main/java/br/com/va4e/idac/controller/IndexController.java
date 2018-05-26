package br.com.va4e.idac.controller;

import java.net.URI;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import br.com.va4e.idac.entity.Member;

@Controller
public class IndexController {

	@RequestMapping("/")
	public String getIndex() {

		return "index";
	}

	@GetMapping("/showMyLoginPage")
	public String showMyLoginPage() {

		return "login";
	}

	@GetMapping("/member/add/")
	public void addMember() {

		Member member = new Member();

		member.setFirstName("Maria Helena");
		member.setLastName("Macedo222");
		member.setUserName("mariah");
		member.setCpf("070.448.539-20");
		member.setRg("22.590-3");
		member.setGender("Feminino");
		member.setActive(true);
		member.setBirthday(new Date(1932 / 06 / 26));

		RestTemplate restTemplate = new RestTemplate();

		URI uri = restTemplate.postForLocation("http://localhost:8080/api/member/", member, Member.class);

	}

}
