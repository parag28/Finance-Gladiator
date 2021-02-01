package com.lti.demo.POJOs;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.*;

@Entity
public class Product implements Serializable {
    @Id
    @GeneratedValue
    private int productId;
    private String productInformation;
    private String productName;
    private String productPicture;
    private BigDecimal productPrice;

    @OneToMany(mappedBy="product")
    private List<EMI> emis;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductInformation() {
        return productInformation;
    }

    public void setProductInformation(String productInformation) {
        this.productInformation = productInformation;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductPicture() {
        return productPicture;
    }

    public void setProductPicture(String productPicture) {
        this.productPicture = productPicture;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public List<EMI> getEmis() {
        return emis;
    }

    public void setEmis(List<EMI> emis) {
        this.emis = emis;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    @OneToMany(mappedBy="product")
    private List<Transaction> transactions;

}
