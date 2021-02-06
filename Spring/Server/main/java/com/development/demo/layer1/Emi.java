package com.development.demo.layer1;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;


/**
 * The persistent class for the EMI database table.
 *
 */
@Entity
@NamedQuery(name="Emi.findAll", query="SELECT e FROM Emi e")
public class Emi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
  @GeneratedValue
	private int emiid;

	private String emidate;

	private int emispaid;

	private int monthlycharge;

	private int remainingemis;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="PRODUCTID")
	private Product product;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="USERNAME")
	private User user;

	public Emi() {
	}

	public int getEmiid() {
		return this.emiid;
	}

	public void setEmiid(int emiid) {
		this.emiid = emiid;
	}

	public String getEmidate() {
		return this.emidate;
	}

	public void setEmidate(String emidate) {
		this.emidate = emidate;
	}

	public int getEmispaid() {
		return this.emispaid;
	}

	public void setEmispaid(int emispaid) {
		this.emispaid = emispaid;
	}

	public int getMonthlycharge() {
		return this.monthlycharge;
	}

	public void setMonthlycharge(int monthlycharge) {
		this.monthlycharge = monthlycharge;
	}

	public int getRemainingemis() {
		return this.remainingemis;
	}

	public void setRemainingemis(int remainingemis) {
		this.remainingemis = remainingemis;
	}


	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}


	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
