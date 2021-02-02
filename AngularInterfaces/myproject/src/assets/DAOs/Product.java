package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
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
	private String productid;

	private String productcategory;

	private String productinformation;

	private String productname;

	private String productpicture;

	private BigDecimal productprice;

	//bi-directional many-to-one association to Emidetail
	@OneToMany(mappedBy="product")
	private List<Emidetail> emidetails;

	//bi-directional many-to-one association to Transaction
	@OneToMany(mappedBy="product")
	private List<Transaction> transactions;

  @ManyToMany
	@JoinTable(name="PurchaseTable",
		joinColumns= {@JoinColumn(name="ProductPurchased")},
		inverseJoinColumns= {@JoinColumn(name="UserName")})
	private List<Userdetail> UserShopped;


	public List<Userdetail> getUserShopped() {
		return UserShopped;
	}

	public void setUserShopped(List<Userdetail> userShopped) {
		UserShopped = userShopped;
	}

	public Product() {
	}

	public String getProductid() {
		return this.productid;
	}

	public void setProductid(String productid) {
		this.productid = productid;
	}

	public String getProductcategory() {
		return this.productcategory;
	}

	public void setProductcategory(String productcategory) {
		this.productcategory = productcategory;
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

	public BigDecimal getProductprice() {
		return this.productprice;
	}

	public void setProductprice(BigDecimal productprice) {
		this.productprice = productprice;
	}

	public List<Emidetail> getEmidetails() {
		return this.emidetails;
	}

	public void setEmidetails(List<Emidetail> emidetails) {
		this.emidetails = emidetails;
	}

	public Emidetail addEmidetail(Emidetail emidetail) {
		getEmidetails().add(emidetail);
		emidetail.setProduct(this);

		return emidetail;
	}

	public Emidetail removeEmidetail(Emidetail emidetail) {
		getEmidetails().remove(emidetail);
		emidetail.setProduct(null);

		return emidetail;
	}

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

}
