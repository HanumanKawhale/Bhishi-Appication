package com.bhishiapplication.services;

import org.springframework.stereotype.Service;

import com.bhishiapplication.entities.BhishiPayment;
import com.bhishiapplication.helper.MonthWiseAmountSum;

@Service
public interface BhishiPaymentService {

	
	BhishiPayment createBhishiPayment(BhishiPayment bhishiPayment,Integer MemberId,Integer BhishiAppId);
	
	BhishiPayment updateBhishiPayment(BhishiPayment bhishiPayment,Integer bhishiPaymentId );
	
	void deleteBhishiPayment(Integer BhishiPaymentId);
	
	BhishiPayment getBhishiPayment(Integer BhishiPaymentId);
	
	MonthWiseAmountSum getMonthWise(int month);
 	
	
}
