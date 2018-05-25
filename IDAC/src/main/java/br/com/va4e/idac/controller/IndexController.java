package br.com.va4e.idac.controller;


import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import br.com.va4e.idac.entity.Member;
import br.com.va4e.idac.entity.MemberAddress;
import br.com.va4e.idac.entity.MemberEmail;
import br.com.va4e.idac.entity.MemberPhone;

@Controller
public class IndexController {

	 @RequestMapping("/")
	public String getIndex(){
		
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
		 member.setLastName("Macedo");
		 member.setUserName("maria");
		 member.setCpf("070.448.539-20");
		 member.setRg("22.590-3");
		 member.setGender("Feminino");
		 member.setActive(true);
		 member.setBirthday(new Date(1932/06/26));
		 
		List<MemberAddress> memberAddresses = new ArrayList<MemberAddress>();
		MemberAddress memberAddress= new MemberAddress("Rua Osíris Magalhães de Almeida", "180", "Casa 7", "05634-020", "São Paulo", "São Paulo", "Brasil", 0 ,member);
		MemberAddress memberAddress2= new MemberAddress("Rua Edmundo Scannapieco", "218", "", "05516-070", "São Paulo", "São Paulo", "Brasil", 1,member );

		 
	/*	 member.addAddress(new MemberAddress("Rua Osíris Magalhães de Almeida", "180", "Casa 7", "05634-020", "São Paulo", "São Paulo", "Brasil", 0, member ));
		 member.addAddress(new MemberAddress("Rua Edmundo Scannapieco", "218", "", "05516-070", "São Paulo", "São Paulo", "Brasil", 1 ,member));*/
		 
		memberAddress.setMember(member);
		
		memberAddress2.setMember(member);
		
		
		 memberAddresses.add(memberAddress);
		 memberAddresses.add(memberAddress2);

		/* member.getAddresses().add(new MemberAddress("Rua Osíris Magalhães de Almeida", "180", "Casa 7", "05634-020", "São Paulo", "São Paulo", "Brasil", 0 , member));

		 member.getAddresses().add(new MemberAddress("Rua Edmundo Scannapieco", "218", "", "05516-070", "São Paulo", "São Paulo", "Brasil", 1 , member));*/
		 
		 List<MemberEmail> memberEmails =  new ArrayList<MemberEmail>();
		 
		 MemberEmail memberEmail1 = new  MemberEmail("mh@gmail.com",0, true,true,member);
		MemberEmail memberEmail2 = new  MemberEmail("mh@va4e.com.br", 1, false, true,member);
		 
		 memberEmails.add(memberEmail1);
		memberEmails.add(memberEmail2);
		 
	/*	
		member.getEmails().add(new  MemberEmail("mh@gmail.com",0, true,true, member));
		member.getEmails().add(new  MemberEmail("mh@va4e.com.br", 1, false, true, member));*/
		 
		/* member.addEmail(new MemberEmail("mh@gmail.com",0, true,true,member));
		 member.addEmail(new MemberEmail("mh@va4e.com.br", 1, false, true,member));

		 
		 member.addPhone(new MemberPhone("11","3721-1066", "", "", 0,member));
		 member.addPhone(new MemberPhone("11","3721-1066", "", "", 0,member));*/
		 
		 List<MemberPhone> memberPhones = new ArrayList<MemberPhone>();
		 
		 
		 MemberPhone memberPhone1 = new MemberPhone("11","3721-1066", "", "", 0,member);
		 MemberPhone memberPhone2 = new MemberPhone("11","99241-7777", "", "", 1,member);
		 
		 memberPhones.add(memberPhone1);
		 memberPhones.add(memberPhone2);
		 
		/* member.getPhones().add(new MemberPhone("11","3721-1066", "", "", 0, member));
		 member.getPhones().add( new MemberPhone("11","99241-7777", "", "", 1, member));*/

		member.setAddresses(memberAddresses);
		member.setEmails(memberEmails);
		member.setPhones(memberPhones);
		 
		 RestTemplate restTemplate = new RestTemplate(); 

	        URI uri = restTemplate.postForLocation("http://localhost:8080/api/member/", member, Member.class);

		 System.out.println(uri);
		 
		 
		// restTemplate.postForObject("http://localhost:8080/api/member/", request, responseType, uriVariables)
	 }
	
}
