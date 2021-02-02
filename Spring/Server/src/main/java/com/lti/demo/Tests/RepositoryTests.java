package com.lti.demo.Tests;

import com.lti.demo.POJOs.Login;
import com.lti.demo.POJOs.Product;
import com.lti.demo.POJOs.Transaction;
import com.lti.demo.POJOs.User;
import com.lti.demo.Repositories.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;

public class RepositoryTests {
    @Autowired
    UserRepository userRepository;
    @Test
    void testAddUser(){
        User user = new User();
        user.setDateOfBirth("12/02/2001");
        user.setUserName("Andy");
        user.setBankName("BOI");
        user.setAddress("Bellwood Ave");
        user.setEmail("b@a.com");
        user.setIfscCode("IHGHG");
        user.setName("Hol");
        user.setPhoneNumber(BigDecimal.valueOf(90191910));
        user.setSavingsAccountNumber(BigDecimal.valueOf(909209102));
        userRepository.addUser(user);

    }

}
