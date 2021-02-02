package com.development.demo.layer1;

import javax.persistence.*;
import java.io.Serializable;


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

	@Column(name="\"UserApprovalStatus\"")
	private int userApprovalStatus;

	private int usertype;

	//bi-directional one-to-one association to User
	@OneToOne
	@JoinColumn(name="USERNAME")
	private User user;

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

	public int getUserApprovalStatus() {
		return this.userApprovalStatus;
	}

	public void setUserApprovalStatus(int userApprovalStatus) {
		this.userApprovalStatus = userApprovalStatus;
	}

	public int getUsertype() {
		return this.usertype;
	}

	public void setUsertype(int usertype) {
		this.usertype = usertype;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
