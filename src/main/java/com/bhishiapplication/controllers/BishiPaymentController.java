package com.bhishiapplication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bhishiapplication.entities.BhishiPayment;
import com.bhishiapplication.helper.Message;
import com.bhishiapplication.helper.MonthWiseAmountSum;
import com.bhishiapplication.services.BhishiPaymentService;

@RestController
@RequestMapping("/")
public class BishiPaymentController {

	@Autowired
	BhishiPaymentService bhishiPaymentService;
	
	
	
	@PostMapping(value="/bhishiApp/{bhishiId}/member/{memberId}/bhishiPayment",consumes = {"application/json"} )
	public ResponseEntity<Message> createBhishiPayment( @RequestBody BhishiPayment bhishiPayment,
			@PathVariable("bhishiId") Integer bhishiId,
            @PathVariable("memberId") Integer memberId) {
				
		BhishiPayment bhishiPayment2 = this.bhishiPaymentService.createBhishiPayment( bhishiPayment, memberId, bhishiId);
		
		int  id = bhishiPayment2.getListOfBhishi().getBhishiId();
		
		int  id2 = bhishiPayment2.getMember().getMemberId();
		
		Message message = new Message(bhishiPayment2, id, id2);
		
		return new ResponseEntity<Message>(message,HttpStatus.CREATED);
		
	}
	
	
	
	@GetMapping("/bhishiPayment/{bhishiPaymentId}")
	public ResponseEntity<Message> getBhishiPayment(@PathVariable ("bhishiPaymentId") int id) {
		
		BhishiPayment bhishiPayment = bhishiPaymentService.getBhishiPayment(id);
		int bhishiId = bhishiPayment.getListOfBhishi().getBhishiId();
		int memberId = bhishiPayment.getMember().getMemberId();
		
		Message message = new  Message(bhishiPayment,bhishiId,memberId);
		return new ResponseEntity<Message>(message,HttpStatus.OK);
	}
	
	
	@GetMapping("/bhishiPayment/month/{month}")
	public ResponseEntity<MonthWiseAmountSum> getMonthWiseData(@PathVariable("month") int month) {
	//	System.out.println(month);
		//List<BhishiPayment> listMonthWise = bhishiPaymentService.getMonthWise(month);
		
		MonthWiseAmountSum monthWiseAmountSum  =  bhishiPaymentService.getMonthWise(month); 

		
		return new ResponseEntity<MonthWiseAmountSum>(monthWiseAmountSum,HttpStatus.OK);
	}
	
	
	
}
