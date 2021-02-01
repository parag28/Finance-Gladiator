package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the CARDDETAILS database table.
 * 
 */
@Entity
@Table(name="CARDDETAILS")
@NamedQuery(name="Carddetail.findAll", query="SELECT c FROM Carddetail c")
public class Carddetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String username;

	private BigDecimal cardnumber;

	private BigDecimal cardtype;

	private BigDecimal creditremaining;

	private Object validupto;

	//bi-directional one-to-one association to Userdetail
	@OneToOne
	@JoinColumn(name="USERNAME")
	private Userdetail userdetail;

	public Carddetail() {
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public BigDecimal getCardnumber() {
		return this.cardnumber;
	}

	public void setCardnumber(BigDecimal cardnumber) {
		this.cardnumber = cardnumber;
	}

	public BigDecimal getCardtype() {
		return this.cardtype;
	}

	public void setCardtype(BigDecimal cardtype) {
		this.cardtype = cardtype;
	}

	public BigDecimal getCreditremaining() {
		return this.creditremaining;
	}

	public void setCreditremaining(BigDecimal creditremaining) {
		this.creditremaining = creditremaining;
	}

	public Object getValidupto() {
		return this.validupto;
	}

	public void setValidupto(Object validupto) {
		this.validupto = validupto;
	}

	public Userdetail getUserdetail() {
		return this.userdetail;
	}

	public void setUserdetail(Userdetail userdetail) {
		this.userdetail = userdetail;
	}

}