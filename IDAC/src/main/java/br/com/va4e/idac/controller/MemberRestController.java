package br.com.va4e.idac.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.va4e.idac.entity.Member;
import br.com.va4e.idac.repository.MemberRepository;
import br.com.va4e.idac.services.NotificationService;


@RestController
public class MemberRestController {

	@Autowired
	private MemberRepository memberRepository;
	
	 @Autowired
     private NotificationService notifyService;
	 
	 @Autowired
	 private Environment env;

	@GetMapping("/members")
	public List<Member> retrieveAllMembers() {
		return memberRepository.findAll();
	}

	@GetMapping("/members/{id}")
	public Member retrieveMember(@PathVariable Long id) {
		
		Member member = memberRepository.findOne(id);
		
		 if (member == null) {
	            notifyService.addErrorMessage(env.getProperty("NotFound.member.id") + id);
	            //return "redirect:/";
	        }

		return member;
	}

	/* @RequestMapping({"/", "/index"})
	@RequestMapping("/list")
	public String getMembers() {

		return "member-list";
	}
*/
	@DeleteMapping("/members/{id}")
	public void deleteMember(@PathVariable Long id) {
		memberRepository.delete(id);
	}

	@PostMapping("/members")
	public ResponseEntity<Object> createMember(@RequestBody Member member) {
		Member savedMember = memberRepository.save(member);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedMember.getId()).toUri();

		return ResponseEntity.created(location).build();

	}

	@PutMapping("/members/{id}")
	public ResponseEntity<Object> updateMember(@RequestBody Member member, @PathVariable Long id) {

		//Member memberOptional = memberRepository.findOne(id);

		member.setId(id);

		memberRepository.save(member);
		
		//flush????
		//transaction????
		//log
		//audit

		return ResponseEntity.noContent().build();
	}

}
