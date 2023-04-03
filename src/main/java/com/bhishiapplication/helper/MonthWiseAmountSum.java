package com.bhishiapplication.helper;

public class MonthWiseAmountSum {

	
	private  long noOfmember;
	
	private long totaAmount;

	public MonthWiseAmountSum(long noOfmember, long totaAmount) {
		super();
		this.noOfmember = noOfmember;
		this.totaAmount = totaAmount;
	}

	public MonthWiseAmountSum() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getNoOfmember() {
		return noOfmember;
	}

	public void setNoOfmember(int noOfmember) {
		this.noOfmember = noOfmember;
	}

	public long getTotaAmount() {
		return totaAmount;
	}

	public void setTotaAmount(long totaAmount) {
		this.totaAmount = totaAmount;
	}

	@Override
	public String toString() {
		return "MonthWiseAmountSum [noOfmember=" + noOfmember + ", totaAmount=" + totaAmount + "]";
	}
	
	
	
	
}
