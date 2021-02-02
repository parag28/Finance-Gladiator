package com.lti.demo;

 import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lti.demo.POJOs.Product;
import com.lti.demo.POJOs.Purchase;
import com.lti.demo.POJOs.User;
import com.lti.demo.Repositories.PurchasesRepository;
import com.lti.demo.Repositories.PurchasesRepositoryImplementation;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;


@SpringBootTest
class ServerApplicationTests {
	
	@Autowired
	PurchasesRepositoryImplementation pr;
	
    @Test
    void contextLoads() {
    	Date date=new Date();
		Purchase pur=new Purchase();
		pur.setPurchaseid(1);
		User u1=new User();
		u1.setName("manoj");
		Product p1=new Product();
		p1.setProductName("pen");
		pur.setUser(u1);
		pur.setProduct(p1);
		pur.setPurchaseddate(date);
		
		pr.addPurchase(pur);
    }
    
   	

}
