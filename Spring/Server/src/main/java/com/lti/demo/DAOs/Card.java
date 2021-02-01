package com.lti.demo.DAOs;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;
@Entity
@Table(name="CARDDETAILS")
public class Card implements Serializable {
    @Id
    private String userName;
    private BigDecimal cardNumber;
    private BigDecimal cardType;
    private BigDecimal creditRemaining;
    private Object validUpto;

    //bi-directional one-to-one association to Userdetail
    @OneToOne
    @JoinColumn(name = "USERNAME")
    private User user;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public BigDecimal getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(BigDecimal cardNumber) {
        this.cardNumber = cardNumber;
    }

    public BigDecimal getCardType() {
        return cardType;
    }

    public void setCardType(BigDecimal cardType) {
        this.cardType = cardType;
    }

    public BigDecimal getCreditRemaining() {
        return creditRemaining;
    }

    public void setCreditRemaining(BigDecimal creditRemaining) {
        this.creditRemaining = creditRemaining;
    }

    public Object getValidUpto() {
        return validUpto;
    }

    public void setValidUpto(Object validUpto) {
        this.validUpto = validUpto;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
