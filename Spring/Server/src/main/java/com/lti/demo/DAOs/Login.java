package com.lti.demo.DAOs;

 import java.io.Serializable;
 import javax.persistence.*;
 import java.math.BigDecimal;

@Entity
public class Login implements Serializable {
    @Id
    private String userName;
    private String password;
    private BigDecimal userType;

    @OneToOne
    @JoinColumn(name="USERNAME")
    private User user;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BigDecimal getUserType() {
        return userType;
    }

    public void setUserType(BigDecimal userType) {
        this.userType = userType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
