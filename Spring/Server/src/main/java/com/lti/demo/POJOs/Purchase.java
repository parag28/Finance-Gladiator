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
	private int purchaseid;
	
	@ManyToOne
	@JoinColumn(name="username")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="product")
	private Product product;
	
	@Column(name="purchaseddate")
	private Date purchaseddate;

	public int getPurchaseid() {
		return purchaseid;
	}

	public void setPurchaseid(int purchaseid) {
		this.purchaseid = purchaseid;
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

	public Date getPurchaseddate() {
		return purchaseddate;
	}

	public void setPurchaseddate(Date purchaseddate) {
		this.purchaseddate = purchaseddate;
	}
}


