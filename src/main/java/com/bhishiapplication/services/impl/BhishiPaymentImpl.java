package com.bhishiapplication.services.impl;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhishiapplication.entities.BhishiApp;
import com.bhishiapplication.entities.BhishiPayment;
import com.bhishiapplication.entities.Member;
import com.bhishiapplication.exception.ResourceNotFoundException;
import com.bhishiapplication.helper.MonthWiseAmountSum;
import com.bhishiapplication.repositories.BhishiAppRepository;
import com.bhishiapplication.repositories.BhishiPaymentRepository;
import com.bhishiapplication.repositories.MemberRepository;
import com.bhishiapplication.services.BhishiPaymentService;

@Service
public class BhishiPaymentImpl implements BhishiPaymentService {

	@Autowired
	private BhishiPaymentRepository bhishiPaymentRepository; 
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private BhishiAppRepository bhishiAppRepository;
	
	@Override
	public BhishiPayment createBhishiPayment(BhishiPayment bhishiPayment ,Integer memberId , Integer bhishiAppId) {
		
		Member member = this.memberRepository.findById(memberId)
	            .orElseThrow(()-> new ResourceNotFoundException("Member","id",memberId));
	    		
		BhishiApp bhishiApp = this.bhishiAppRepository.findById(bhishiAppId)
				.orElseThrow(()->new ResourceNotFoundException("BhishiApp","id",bhishiAppId));
		
		bhishiPayment.setListOfBhishi(bhishiApp);
		bhishiPayment.setMember(member);
	   
		BhishiPayment bhishiPayment2 = this.bhishiPaymentRepository.save(bhishiPayment) ;
		return  bhishiPayment2;
	}
	

	@Override
	public BhishiPayment updateBhishiPayment(BhishiPayment bhishiPayment, Integer bhishiPaymentId) {
		
		BhishiPayment bhishiPayment2 =this.bhishiPaymentRepository.findById(bhishiPaymentId)
				.orElseThrow(()->new ResourceNotFoundException("BhishiPayment","id",bhishiPaymentId));
		
		
		return null;
	}
	

	@Override
	public void deleteBhishiPayment(Integer bhishiPaymentId) {
		
		BhishiPayment bhishiPayment  = this.bhishiPaymentRepository.findById(bhishiPaymentId)
				.orElseThrow(()->new ResourceNotFoundException("BhishiPayment","id",bhishiPaymentId));
		
		
		this.bhishiPaymentRepository.delete(bhishiPayment);
	}

	
	@Override
	public BhishiPayment getBhishiPayment(Integer BhishiPaymentId) {
		
		BhishiPayment bhishiPayment = this.bhishiPaymentRepository.findById(BhishiPaymentId)
				.orElseThrow(()->new ResourceNotFoundException("BhishiPayment","id",BhishiPaymentId));
		
		return bhishiPayment;
	} 


	
	@Override
	public MonthWiseAmountSum getMonthWise(int month) {
	
		 List<BhishiPayment> list =  this.bhishiPaymentRepository.findAll();
		
		 
		 
		 List<BhishiPayment> listMonthWise = list.stream().filter(l->l.getDate().getMonth()== month ).collect(Collectors.toList()); 
		 
		
		 
		 Long totalMember = listMonthWise.stream().count();
		 
		 Integer totalamount  = listMonthWise.stream().mapToInt(BhishiPayment::getAmount).sum();
		 
		 MonthWiseAmountSum monthWiseAmountSum = new MonthWiseAmountSum(totalMember,totalamount);
		 
		 
		 
		return monthWiseAmountSum;
	}


}
