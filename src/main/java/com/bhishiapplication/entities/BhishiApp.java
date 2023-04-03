package com.bhishiapplication.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "BhishiApp")
public class BhishiApp   {

	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bhishiId;

	@NotBlank(message = "please enter Name")
	private String bhishiName;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date startDate;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date endDate;
		
	@Range(max = 12,min = 12,message = "no of member is 12")
	private int noOfMember;
	
	
	private int amount;
	
	@NotEmpty(message = "please enter discription")
	private String discription;
   
	
	@OneToMany(mappedBy = "bhishiApp")
	@JsonIgnore
	private List<Member> listMember = new ArrayList<Member>() ;
	

  
	@OneToMany(mappedBy = "listOfBhishi")
	@JsonIgnore
	private List<BhishiPayment> bhishiPayment;
	

	
	
	
	public List<Member> getListMember() {
		return listMember;
	}

	public void setListMember(List<Member> listMember) {
		this.listMember = listMember;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public int getBhishiId() {
		return bhishiId;
	}

	public void setBhishiId(int bhishiId) {
		this.bhishiId = bhishiId;
	}

	public String getBhishiName() {
		return bhishiName;
	}

	public void setBhishiName(String bhishiName) {
		this.bhishiName = bhishiName;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}


	public int getNoOfMember() {
		return noOfMember;
	}

	public void setNoOfMember(int noOfMember) {
		this.noOfMember = noOfMember;
	}


  
    
	public List<BhishiPayment> getBhishiPayment() {
		return bhishiPayment;
	}

	public void setBhishiPayment(List<BhishiPayment> bhishiPayment) {
		this.bhishiPayment = bhishiPayment;
	}
	
	
}
