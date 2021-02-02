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
public class PurchaseServiceImplementation implements PurchaseRepository{
    @Autowired 
    PurchaseRepository purchaserepository;
	
    @Override
    public String addPurchase(Purchase purchase) {
    	try{
            purchaserepository.addPurchase(purchase);
            
       }
       catch(Exception e){
       	System.out.println(e.getStackTrace());
       }
	 return "Success";
    }

    @Override
    public Purchase getPurchase(int purchaseId) {
       Purchase purchase1=null;
		 try{
			 purchase1=purchaserepository.getPurchase(purchaseId);
          	
		 	}
		 	catch(Exception e){
		 		System.out.println(e.getStackTrace());
		 	}
		 	return purchase1;
    }

    @Override
    public List<Purchase> getAllPurchases() {
    	List<Purchase> purchase1=null;
		 try{
			 purchase1=purchaserepository.getAllPurchases();
            
		 	}
		 	catch(Exception e){
		 		System.out.println(e.getStackTrace());
		 	}
		 	return purchase1;
	}	 
 }