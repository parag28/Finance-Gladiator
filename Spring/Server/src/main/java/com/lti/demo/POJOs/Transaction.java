package com.lti.demo.POJOs;
 import java.io.Serializable;
 import javax.persistence.*;
 import java.math.BigDecimal;


/**
 * The persistent class for the TRANSACTIONS database table.
 *
 */
@Entity
@Table(name="TRANSACTION")
public class Transaction implements Serializable {

    private BigDecimal productQuantity;
    private BigDecimal transactionStatus;
    private BigDecimal transactionAmount;
    @Id
    @GeneratedValue
    private String transactionId;

    @ManyToOne
    @JoinColumn(name="PRODUCTID")
    private Product product;

    public BigDecimal getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(BigDecimal productQuantity) {
        this.productQuantity = productQuantity;
    }

    public BigDecimal getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(BigDecimal transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public BigDecimal getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(BigDecimal transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne()
    @JoinColumn(name="USERNAME")
    private User user;

}
