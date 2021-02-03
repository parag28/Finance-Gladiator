package com.development.demo.layer3;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.development.demo.layer1.Product;
import com.development.demo.layer1.Purchase;
import com.development.demo.layer1.Transaction;
import com.development.demo.layer2.ProductRepository;
import com.development.demo.layer2.PurchaseRepository;
import com.development.demo.layer2.TransactionRepository;

@Service
public class PurchaseServiceImplementation implements PurchaseService{
    @Autowired
    PurchaseRepository purchaseRepository;

    @Override
    public String addPurchaseService(Purchase purchase) {
    	try{
    	  purchaseRepository.addPurchase(purchase);
        return "Success";
       }
       catch(Exception e){
       	System.out.println(e.getMessage());
       	return "fail";
       }
    }

    @Override
    public Purchase getPurchaseService(int purchaseId) {
		 try{
			 return purchaseRepository.getPurchase(purchaseId);
		 	}
		 	catch(Exception e){
		 		
		 		return null;
		 	}
    }

    @Override
    public List<Purchase> getAllPurchasesService() {
		 try{
			 return purchaseRepository.getAllPurchases();
		 }
		 	catch(Exception e) {
        System.out.println(e.getMessage());
        return null;
      }
	}
 }
