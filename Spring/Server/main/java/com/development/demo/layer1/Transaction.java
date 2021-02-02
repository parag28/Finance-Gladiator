package com.development.demo.layer1;

import javax.persistence.*;
import java.io.Serializable;


/**
 * The persistent class for the TRANSACTIONS database table.
 *
 */
@Entity
@Table(name="TRANSACTIONS")
@NamedQuery(name="Transaction.findAll", query="SELECT t FROM Transaction t")
public class Transaction implements Serializable {
	private static final long serialVersionUID = 1L;

	private int productquantity;

	private float transactionamount;
	@Id
  @GeneratedValue
	private int transactionid;

	private int transactionstatus;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="PRODUCTID")
	private Product product;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="USERNAME")
	private User user;

	public Transaction() {
	}

	public int getProductquantity() {
		return this.productquantity;
	}

	public void setProductquantity(int productquantity) {
		this.productquantity = productquantity;
	}

	public float getTransactionamount() {
		return this.transactionamount;
	}

	public void setTransactionamount(float transactionamount) {
		this.transactionamount = transactionamount;
	}

	public int getTransactionid() {
		return this.transactionid;
	}

	public void setTransactionid(int transactionid) {
		this.transactionid = transactionid;
	}

	public int getTransactionstatus() {
		return this.transactionstatus;
	}

	public void setTransactionstatus(int transactionstatus) {
		this.transactionstatus = transactionstatus;
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
