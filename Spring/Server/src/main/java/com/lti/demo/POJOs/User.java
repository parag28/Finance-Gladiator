package com.lti.demo.POJOs;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name= "USER")
public class User implements Serializable {
    @Id
    private String userName;
    private String address;
    private String bankName;
    private Object dateOfBirth;
    private String email;
    private String ifscCode;
    private String name;
    private BigDecimal phoneNumber;
    private BigDecimal savingsAccountNumber;

    @OneToOne(mappedBy="user")
    private Card card;

    @OneToMany(mappedBy="user")
    private List<EMI> emis;

    @OneToOne(mappedBy="user")
    private Login login;

    @OneToMany(mappedBy="user")
    private List<Transaction> transactions;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public Object getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Object dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(BigDecimal phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public BigDecimal getSavingsAccountNumber() {
        return savingsAccountNumber;
    }

    public void setSavingsAccountNumber(BigDecimal savingsAccountNumber) {
        this.savingsAccountNumber = savingsAccountNumber;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public List<EMI> getEmis() {
        return emis;
    }

    public void setEmis(List<EMI> emis) {
        this.emis = emis;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
