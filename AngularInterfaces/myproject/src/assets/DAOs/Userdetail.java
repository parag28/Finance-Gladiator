package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the USERDETAILS database table.
 *
 */
@Entity
@Table(name="USERDETAILS")
@NamedQuery(name="Userdetail.findAll", query="SELECT u FROM Userdetail u")
public class Userdetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String username;

	private String address;

	private String bankname;

	private Object dateofbirth;

	private String email;

	private String ifsccode;

	private String name;

	private BigDecimal phonenumber;

	private BigDecimal savingsaccountnumber;

	//bi-directional one-to-one association to Carddetail
	@OneToOne(mappedBy="userdetail")
	private Carddetail carddetail;

	//bi-directional many-to-one association to Emidetail
	@OneToMany(mappedBy="userdetail")
	private List<Emidetail> emidetails;

	//bi-directional one-to-one association to Login
	@OneToOne(mappedBy="userdetail")
	private Login login;

	//bi-directional many-to-one association to Transaction
	@OneToMany(mappedBy="userdetail")
	private List<Transaction> transactions;
  /*
  Add ManyToOne relationship for PurchaseDetails
   */
  @ManyToMany
  @JoinTable(name="PURCHASEDETAILS",
  joinColumns={@JoinColumn(name="username")},
  inverseJoinColumns  = {@JoinColumn(name="productId")})
  private Set<Product> purchases;


  @ManyToMany
	@JoinTable(name="PurchaseTable",
		joinColumns= {@JoinColumn(name="UserName")},
		inverseJoinColumns= {@JoinColumn(name="ProductPurchased")})
	private List<Product> ProductsShopped;
>>>>>>> origin/master


	public List<Product> getProductsShopped() {
		return ProductsShopped;
	}

	public void setProductsShopped(List<Product> productsShopped) {
		ProductsShopped = productsShopped;
	}
	public Userdetail() {
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

	public Object getDateofbirth() {
		return this.dateofbirth;
	}

	public void setDateofbirth(Object dateofbirth) {
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

	public BigDecimal getPhonenumber() {
		return this.phonenumber;
	}

	public void setPhonenumber(BigDecimal phonenumber) {
		this.phonenumber = phonenumber;
	}

	public BigDecimal getSavingsaccountnumber() {
		return this.savingsaccountnumber;
	}

	public void setSavingsaccountnumber(BigDecimal savingsaccountnumber) {
		this.savingsaccountnumber = savingsaccountnumber;
	}

	public Carddetail getCarddetail() {
		return this.carddetail;
	}

	public void setCarddetail(Carddetail carddetail) {
		this.carddetail = carddetail;
	}

	public List<Emidetail> getEmidetails() {
		return this.emidetails;
	}

	public void setEmidetails(List<Emidetail> emidetails) {
		this.emidetails = emidetails;
	}

	public Emidetail addEmidetail(Emidetail emidetail) {
		getEmidetails().add(emidetail);
		emidetail.setUserdetail(this);

		return emidetail;
	}

	public Emidetail removeEmidetail(Emidetail emidetail) {
		getEmidetails().remove(emidetail);
		emidetail.setUserdetail(null);

		return emidetail;
	}

	public Login getLogin() {
		return this.login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public List<Transaction> getTransactions() {
		return this.transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public Transaction addTransaction(Transaction transaction) {
		getTransactions().add(transaction);
		transaction.setUserdetail(this);

		return transaction;
	}

	public Transaction removeTransaction(Transaction transaction) {
		getTransactions().remove(transaction);
		transaction.setUserdetail(null);

		return transaction;
	}

}
