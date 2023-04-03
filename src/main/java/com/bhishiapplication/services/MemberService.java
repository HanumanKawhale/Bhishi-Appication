package com.bhishiapplication.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bhishiapplication.entities.Member;

@Service
public interface MemberService {

	Member createMember(Member member);
	
	Member UpdateMember(Member member ,Integer memberId);
	
	Member getMember(Integer memberId);
	
	List<Member> getAllMember();
	
	void deleteMember(Integer memberId);
	
	
}
