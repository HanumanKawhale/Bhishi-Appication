package com.bhishiapplication.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhishiapplication.entities.BhishiApp;
import com.bhishiapplication.entities.Member;
import com.bhishiapplication.exception.ResourceNotFoundException;
import com.bhishiapplication.repositories.BhishiAppRepository;
import com.bhishiapplication.repositories.MemberRepository;
import com.bhishiapplication.services.MemberService;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private BhishiAppRepository bhishiAppRepository;

	
	@Override
	public Member createMember(Member member) {
		
		BhishiApp app= this.bhishiAppRepository.findById(member.getBhishiApp().getBhishiId()).orElseThrow(null);
		member.setBhishiApp(app);
		Member member2 = this.memberRepository.save(member);
		return member2;
	} 
	

	@Override
	public Member UpdateMember(Member member, Integer memberId) {
		
		BhishiApp bhishiApp = this.bhishiAppRepository.findById(member.getBhishiApp().getBhishiId())
				.orElseThrow(()->new ResourceNotFoundException("bhishi", "id",member.getBhishiApp().getBhishiId()));
		
		Member member2 = this.memberRepository.findById(memberId)
				             .orElseThrow(()-> new ResourceNotFoundException("Member","id",memberId));
				
		member2.setName(member.getName());
		member2.setAdhar(member.getAdhar());
		member2.setAccountNo(member.getAccountNo());
        member2.setPassword(member.getPassword());
		member2.setMobileNo(member.getMobileNo());
		member2.setBhishiApp(member.getBhishiApp());
		member2.setBhishiApp(member.getBhishiApp());
		Member updatedMember =  this.memberRepository.save(member2);		
		return updatedMember;
	}

	
	@Override
	public Member getMember(Integer memberId) {
	
		Member member = this.memberRepository.findById(memberId)
				            .orElseThrow(()-> new ResourceNotFoundException("Member","id",memberId));		
		return member;
	}

	
	@Override
	public List<Member> getAllMember() {
	
		List<Member> memberList = this.memberRepository.findAll();
		return memberList;
	}

	
	@Override
	public void deleteMember(Integer memberId) {
	
	Member member = this.memberRepository.findById(memberId)
			            .orElseThrow(()-> new ResourceNotFoundException("Member","id",memberId));
	
	 this.memberRepository.delete(member);;
	}

}
