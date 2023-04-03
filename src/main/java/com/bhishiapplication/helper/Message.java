package com.bhishiapplication.helper;

public class Message {

	
	private Object bhishiPayment;
	
	private int bhishiId;
	private int memberId;	
	
	
	
	public Message(Object bhishiPayment, int bhishiId, int memberId) {
		super();
		this.bhishiPayment = bhishiPayment;
		this.bhishiId = bhishiId;
		this.memberId = memberId;
	}
	
		
	
	public Object getBhishiPayment() {
		return bhishiPayment;
	}
	public void setBhishiPayment(Object bhishiPayment) {
		this.bhishiPayment = bhishiPayment;
	}
	public int getBhishiId() {
		return bhishiId;
	}
	public void setBhishiId(int bhishiId) {
		this.bhishiId = bhishiId;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	
}
