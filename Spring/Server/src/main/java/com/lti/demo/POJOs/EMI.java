package com.lti.demo.POJOs;

 import java.io.Serializable;
 import javax.persistence.*;
 import java.math.BigDecimal;

@Entity
@Table(name= "EMI")
public class EMI implements Serializable {
    @Id
    private String emiId;
    private String emiDate;
    private BigDecimal emisPaid;
    private BigDecimal monthlyCharge;
    private BigDecimal remainingEMIs;

    @ManyToOne
    @JoinColumn(name="PRODUCTID")
    private Product product;

    @ManyToOne
    @JoinColumn(name="USERNAME")
    private User user;

    public String getEmiId() {
        return emiId;
    }

    public void setEmiId(String emiId) {
        this.emiId = emiId;
    }

    public String getEmiDate() {
        return emiDate;
    }

    public void setEmiDate(String emiDate) {
        this.emiDate = emiDate;
    }

    public BigDecimal getEmisPaid() {
        return emisPaid;
    }

    public void setEmisPaid(BigDecimal emisPaid) {
        this.emisPaid = emisPaid;
    }

    public BigDecimal getMonthlyCharge() {
        return monthlyCharge;
    }

    public void setMonthlyCharge(BigDecimal monthlyCharge) {
        this.monthlyCharge = monthlyCharge;
    }

    public BigDecimal getRemainingEMIs() {
        return remainingEMIs;
    }

    public void setRemainingEMIs(BigDecimal remainingEMIs) {
        this.remainingEMIs = remainingEMIs;
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
}
