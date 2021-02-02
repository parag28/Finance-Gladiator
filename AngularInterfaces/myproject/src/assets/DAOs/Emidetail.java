package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the EMIDETAILS database table.
 * 
 */
@Entity
@Table(name="EMIDETAILS")
@NamedQuery(name="Emidetail.findAll", query="SELECT e FROM Emidetail e")
public class Emidetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String emiid;

	private String emidate;

	private BigDecimal emispaid;

	private BigDecimal monthlycharge;

	private BigDecimal remainingemis;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="PRODUCTID")
	private Product product;

	//bi-directional many-to-one association to Userdetail
	@ManyToOne
	@JoinColumn(name="USERNAME")
	private Userdetail userdetail;

	public Emidetail() {
	}

	public String getEmiid() {
		return this.emiid;
	}

	public void setEmiid(String emiid) {
		this.emiid = emiid;
	}

	public String getEmidate() {
		return this.emidate;
	}

	public void setEmidate(String emidate) {
		this.emidate = emidate;
	}

	public BigDecimal getEmispaid() {
		return this.emispaid;
	}

	public void setEmispaid(BigDecimal emispaid) {
		this.emispaid = emispaid;
	}

	public BigDecimal getMonthlycharge() {
		return this.monthlycharge;
	}

	public void setMonthlycharge(BigDecimal monthlycharge) {
		this.monthlycharge = monthlycharge;
	}

	public BigDecimal getRemainingemis() {
		return this.remainingemis;
	}

	public void setRemainingemis(BigDecimal remainingemis) {
		this.remainingemis = remainingemis;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Userdetail getUserdetail() {
		return this.userdetail;
	}

	public void setUserdetail(Userdetail userdetail) {
		this.userdetail = userdetail;
	}

}