package com.development.demo.layer3;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.development.demo.layer1.Product;
import com.development.demo.layer1.Transaction;
import com.development.demo.layer2.ProductRepository;
import com.development.demo.layer2.TransactionRepository;

@Service
public class TransactionServiceImplementation implements TransactionRepository{
    @Autowired 
    TransactionRepository transactionrepository;
	
    @Override
    public String addTransaction(Transaction transaction) {
    	try {
    		transactionrepository.addTransaction(transaction);
    	}
    	catch(Exception e){
        	System.out.println(e.getStackTrace());
        }
	 return "Success";
    }

   // @Override
	public Transaction getTransaction(int TransactionId) {
    	Transaction transaction1=null;
		 try{
			 transaction1=TransactionRepository.getTransaction(TransactionId);
            	
		 	}
		 	catch(Exception e){
		 		System.out.println(e.getStackTrace());
		 	}
		 	return transaction1;
	 }

    @Override
    public List<Transaction> getAllTransactions() {
		// TODO Auto-generated method stub
		 List<Transaction> transaction1=null;
		 try{
			 transaction1=transactionrepository.getAllTransactions();
             
		 	}
		 	catch(Exception e){
		 		System.out.println(e.getStackTrace());
		 	}
		 	return transaction1;
    }


}