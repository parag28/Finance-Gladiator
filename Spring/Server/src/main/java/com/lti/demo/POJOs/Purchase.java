package com.lti.demo.POJOs;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity(name="Purchase")
public class Purchase {

	@Id
	@Column(name="purchaseid")
	@GeneratedValue
	private int purchaseId;
	
	@ManyToOne
	@JoinColumn(name="username")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="productid")
	private Product product;
	
	@Column(name="purchaseddate")
	private String purchasedDate;

	public int getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(int purchaseId) {
		this.purchaseId = purchaseId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getPurchasedDate() {
		return purchasedDate;
	}
	//Using String so that there won't be any type mismatches
	public void setPurchasedDate(String purchasedDate) {
		this.purchasedDate = purchasedDate;
	}
}


