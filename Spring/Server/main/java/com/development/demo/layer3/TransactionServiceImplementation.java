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
public class TransactionServiceImplementation implements TransactionService{
  @Autowired
  TransactionRepository transactionRepository;
  @Override
  public String addTransactionService(Transaction transaction) {
    try{
      return transactionRepository.addTransaction(transaction);
    }
    catch(Exception e){
      System.out.println(e.getMessage());
      return null;
    }
  }

  @Override
  public Transaction getTransactionService(int transactionId) {
    try{
      return transactionRepository.getTransaction(transactionId);
    }
    catch(Exception e){
      System.out.println(e.getMessage());
      return null;
    }
  }

  @Override
  public List<Transaction> getAllTransactionsService() {
    try {
      return transactionRepository.getAllTransactions();
    }
    catch(Exception e){
      System.out.println(e.getMessage());
      return null;
    }
  }
}
