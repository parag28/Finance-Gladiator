package com.development.demo.layer1;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


/**
 * The persistent class for the PRODUCT database table.
 *
 */
@Entity
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
  @GeneratedValue
	private int productid;

	private int numberofproducts;

	private String productinformation;

	private String productname;

	private String productpicture;

	private float productprice;

	//bi-directional many-to-one association to Transaction
	@OneToMany(mappedBy="product")
	private List<Transaction> transactions;

	//bi-directional many-to-one association to Emi
	@OneToMany(mappedBy="product")
	private List<Emi> emis;

	//bi-directional many-to-one association to Purchase
	@OneToMany(mappedBy="product")
	private List<Purchase> purchases;

	public Product() {
	}

	public int getProductid() {
		return this.productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public int getNumberofproducts() {
		return this.numberofproducts;
	}

	public void setNumberofproducts(int numberofproducts) {
		this.numberofproducts = numberofproducts;
	}

	public String getProductinformation() {
		return this.productinformation;
	}

	public void setProductinformation(String productinformation) {
		this.productinformation = productinformation;
	}

	public String getProductname() {
		return this.productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getProductpicture() {
		return this.productpicture;
	}

	public void setProductpicture(String productpicture) {
		this.productpicture = productpicture;
	}

	public float getProductprice() {
		return this.productprice;
	}

	public void setProductprice(float productprice) {
		this.productprice = productprice;
	}
  @JsonIgnore
	public List<Transaction> getTransactions() {
		return this.transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}


	public Transaction addTransaction(Transaction transaction) {
		getTransactions().add(transaction);
		transaction.setProduct(this);

		return transaction;
	}

	public Transaction removeTransaction(Transaction transaction) {
		getTransactions().remove(transaction);
		transaction.setProduct(null);

		return transaction;
	}
  @JsonIgnore
	public List<Emi> getEmis() {
		return this.emis;
	}

	public void setEmis(List<Emi> emis) {
		this.emis = emis;
	}

	public Emi addEmi(Emi emi) {
		getEmis().add(emi);
		emi.setProduct(this);

		return emi;
	}

	public Emi removeEmi(Emi emi) {
		getEmis().remove(emi);
		emi.setProduct(null);

		return emi;
	}
  @JsonIgnore
	public List<Purchase> getPurchases() {
		return this.purchases;
	}

	public void setPurchases(List<Purchase> purchases) {
		this.purchases = purchases;
	}

	public Purchase addPurchas(Purchase purchas) {
		getPurchases().add(purchas);
		purchas.setProduct(this);

		return purchas;
	}

	public Purchase removePurchas(Purchase purchas) {
		getPurchases().remove(purchas);
		purchas.setProduct(null);

		return purchas;
	}

}
