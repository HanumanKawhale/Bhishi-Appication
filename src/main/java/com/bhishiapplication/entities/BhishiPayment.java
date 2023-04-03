package com.bhishiapplication.entities;




import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;



@Entity
@Table(name = "bhishipayment")
public class BhishiPayment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "paymentId")
	private int id;
	
	@Column(name = "amount of bhishi")
	private int amount;
	
    
	@Column(name = "Updated date of payment")
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date date;

	@Column(name="mode of payment")
	private String mode;
	
	@Column(name="status of payment")
	private boolean status;
	

	@ManyToOne(cascade =CascadeType.ALL)
	@JoinColumn(name = "memberId")
//	@JsonIgnoreProperties(value= {"listOPayment"} ,allowSetters = true)
	@JsonIgnore
	private Member member ;
	
	
    @ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "BhishiId")
//    @JsonIgnoreProperties(value = {"bhishiPayment"} ,allowSetters = true)
    
    private BhishiApp listOfBhishi;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}


	public Date getDate() {
	
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public String getMode() {
		return mode;
	}


	public void setMode(String mode) {
		this.mode = mode;
	}


	public boolean isStatus() {
		return status;
	}


	public void setStatus(boolean status) {
		this.status = status;
	}


	public Member getMember() {
		return member;
	}


	public void setMember(Member member) {
		this.member = member;
	}


	public BhishiApp getListOfBhishi() {
		return listOfBhishi;
	}


	public void setListOfBhishi(BhishiApp listOfBhishi) {
		this.listOfBhishi = listOfBhishi;
	}


    
    
   

	
	
}
