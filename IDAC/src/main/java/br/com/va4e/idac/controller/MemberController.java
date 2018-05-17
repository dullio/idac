package br.com.va4e.idac.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.va4e.idac.entity.Member;
import br.com.va4e.idac.repository.MemberRepository;

//@Controller
@RestController
// @RequestMapping("/member")
public class MemberController {

	@Autowired
	private MemberRepository memberRepository;

	@GetMapping("/members")
	public List<Member> retrieveAllStudents() {
		return memberRepository.findAll();
	}

	@GetMapping("/members/{id}")
	public Member retrieveMember(@PathVariable long id) {
		Member member = memberRepository.findOne(id);

		return member;
	}

	// @RequestMapping({"/", "/index"})
	@RequestMapping("/list")
	public String getMembers() {

		return "member-list";
	}

	@DeleteMapping("/members/{id}")
	public void deleteMember(@PathVariable long id) {
		memberRepository.delete(id);
	}

	@PostMapping("/members")
	public ResponseEntity<Object> createMember(@RequestBody Member member) {
		Member savedMember = memberRepository.save(member);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedMember.getId()).toUri();

		return ResponseEntity.created(location).build();

	}

	@PutMapping("/mebers/{id}")
	public ResponseEntity<Object> updateMember(@RequestBody Member member, @PathVariable long id) {

		//Member memberOptional = memberRepository.findOne(id);

		member.setId(id);

		memberRepository.save(member);

		return ResponseEntity.noContent().build();
	}

}
