package com.development.demo.layer1;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


/**
 * The persistent class for the "USER" database table.
 *
 */
@Entity
@Table(name="\"USER\"")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String username;

	private String address;

	private String bankname;

	private String dateofbirth;

	private String email;

	private String ifsccode;

	private String name;

	private long phonenumber;

	private long savingsaccountnumber;

	//bi-directional one-to-one association to Card
	@OneToOne(mappedBy="user")
	private Card card;

	//bi-directional many-to-one association to Emi
	@OneToMany(mappedBy="user")
	private List<Emi> emis;

	//bi-directional one-to-one association to Login
	@OneToOne(mappedBy="user")
	private Login login;

	//bi-directional many-to-one association to Purchase
	@OneToMany(mappedBy="user")
	private List<Purchase> purchases;

	//bi-directional many-to-one association to Transaction
	@OneToMany(mappedBy="user")
	private List<Transaction> transactions;

	public User() {
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBankname() {
		return this.bankname;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname;
	}

	public String getDateofbirth() {
		return this.dateofbirth;
	}

	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIfsccode() {
		return this.ifsccode;
	}

	public void setIfsccode(String ifsccode) {
		this.ifsccode = ifsccode;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPhonenumber() {
		return this.phonenumber;
	}

	public void setPhonenumber(long phonenumber) {
		this.phonenumber = phonenumber;
	}

	public long getSavingsaccountnumber() {
		return this.savingsaccountnumber;
	}

	public void setSavingsaccountnumber(long savingsaccountnumber) {
		this.savingsaccountnumber = savingsaccountnumber;
	}
  @JsonIgnore
	public Card getCard() {
		return this.card;
	}

	public void setCard(Card card) {
		this.card = card;
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
		emi.setUser(this);

		return emi;
	}

	public Emi removeEmi(Emi emi) {
		getEmis().remove(emi);
		emi.setUser(null);

		return emi;
	}

	@JsonIgnore
	public Login getLogin() {
		return this.login;
	}

	public void setLogin(Login login) {
		this.login = login;
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
		purchas.setUser(this);

		return purchas;
	}

	public Purchase removePurchas(Purchase purchas) {
		getPurchases().remove(purchas);
		purchas.setUser(null);

		return purchas;
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
		transaction.setUser(this);

		return transaction;
	}

	public Transaction removeTransaction(Transaction transaction) {
		getTransactions().remove(transaction);
		transaction.setUser(null);

		return transaction;
	}

}
