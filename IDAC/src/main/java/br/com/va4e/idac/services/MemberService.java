package br.com.va4e.idac.services;

import java.util.List;

import br.com.va4e.idac.entity.Member;

public interface MemberService {

	
	Member getMember(Integer id);
	List<Member> listMembers();
	
	
}