package com.bhishiapplication.entities;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Member")
public class Member   {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int memberId;
	
	@NotBlank
	@Size(min = 2,message="username must required")
	private String name;
		
	private long adhar;
	
	private long mobileNo;
	
	
	@Column(unique = true)
	private long accountNo;
	
	@NotBlank(message = "password is required")
	private String password;
	
	@Column(name = "createdDate")
	private Date createdDate;
	
    @Column(name="updatedDate")
	private Date updatedDate;
		
	@ManyToOne	
	private BhishiApp bhishiApp;
	
  
	@OneToMany(mappedBy = "member")
 //   @JsonIgnoreProperties(value = {"member"},allowSetters = true)
	private List<BhishiPayment> listOPayment;

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getAdhar() {
		return adhar;
	}

	public void setAdhar(long adhar) {
		this.adhar = adhar;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
		
	public long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public BhishiApp getBhishiApp() {
		return bhishiApp;
	}

	public void setBhishiApp(BhishiApp bhishiApp) {
		this.bhishiApp = bhishiApp;
	}

	public List<BhishiPayment> getListOPayment() {
		return listOPayment;
	}

	public void setListOPayment(List<BhishiPayment> listOPayment) {
		this.listOPayment = listOPayment;
	}

	
	
	
	
	
}
