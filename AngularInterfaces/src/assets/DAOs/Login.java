package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the LOGIN database table.
 * 
 */
@Entity
@NamedQuery(name="Login.findAll", query="SELECT l FROM Login l")
public class Login implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String username;

	private String password;

	private BigDecimal usertype;

	//bi-directional one-to-one association to Userdetail
	@OneToOne
	@JoinColumn(name="USERNAME")
	private Userdetail userdetail;

	public Login() {
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public BigDecimal getUsertype() {
		return this.usertype;
	}

	public void setUsertype(BigDecimal usertype) {
		this.usertype = usertype;
	}

	public Userdetail getUserdetail() {
		return this.userdetail;
	}

	public void setUserdetail(Userdetail userdetail) {
		this.userdetail = userdetail;
	}

}