package com.bhishiapplication.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bhishiapplication.entities.Member;
import com.bhishiapplication.services.MemberService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@Autowired
	ObjectMapper objectMapper;
	
	//add member
	@PostMapping("/")
	public ResponseEntity<Member> createMember(@Valid @RequestBody Member member){
			
	
		Member member1 = this.memberService.createMember(member);
	
		return new ResponseEntity<>(member1 ,HttpStatus.CREATED);
	}
	
	
	
	@PutMapping("/{memberId}")
	public ResponseEntity<Member> updateMember(@Valid @RequestBody Member member 
			,@PathVariable ("memberId") Integer memberId
			,@PathVariable ("bhishiId") Integer bhishiId){
		
		Member updatedMember = this.memberService.UpdateMember(member, memberId);
		
		return  ResponseEntity.ok(updatedMember);
	}
	
	
	
	@DeleteMapping("/{memberId}")
	public ResponseEntity<String> deleteMember(@PathVariable ("memberId") Integer memberId) {
		
		this.memberService.deleteMember(memberId);
		  
		return new ResponseEntity<String>("delete successfully",HttpStatus.OK);	
	} 
	
	
	
	@GetMapping
	public ResponseEntity<String> getAllMember() throws JsonProcessingException {
		
		List<Member> listMember = this.memberService.getAllMember();
		
		
		String strListMember = objectMapper.writeValueAsString(listMember);
		return new ResponseEntity<>(strListMember,HttpStatus.OK);
	}
	
	
	
	@GetMapping("/{memberId}")
	public ResponseEntity<Member> getMember(@PathVariable("memberId") Integer memberId) {
		
		Member member = this.memberService.getMember(memberId);
			
		return new ResponseEntity<>(member,HttpStatus.OK);
	}
	

}

