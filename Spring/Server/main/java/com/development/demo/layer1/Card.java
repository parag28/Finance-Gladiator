package com.development.demo.layer1;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;


/**
 * The persistent class for the CARD database table.
 *
 */
@Entity
@NamedQuery(name="Card.findAll", query="SELECT c FROM Card c")
public class Card implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String username;

	private long cardnumber;

	private int cardtype;

	private int creditremaining;

	private String validupto;

	//bi-directional one-to-one association to User
	@OneToOne
	@JoinColumn(name="USERNAME")
	private User user;

	public Card() {
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public long getCardnumber() {
		return this.cardnumber;
	}

	public void setCardnumber(long cardnumber) {
		this.cardnumber = cardnumber;
	}

	public int getCardtype() {
		return this.cardtype;
	}

	public void setCardtype(int cardtype) {
		this.cardtype = cardtype;
	}

	public int getCreditremaining() {
		return this.creditremaining;
	}

	public void setCreditremaining(int creditremaining) {
		this.creditremaining = creditremaining;
	}

	public String getValidupto() {
		return this.validupto;
	}

	public void setValidupto(String validupto) {
		this.validupto = validupto;
	}
  @JsonIgnore
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
