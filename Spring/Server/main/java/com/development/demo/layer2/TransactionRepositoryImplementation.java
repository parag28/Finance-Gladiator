package com.development.demo.layer2;
import com.development.demo.layer1.*;
import org.springframework.stereotype.Repository;



import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
@Repository
public class TransactionRepositoryImplementation implements TransactionRepository{
    @PersistenceContext
    EntityManager entityManager;


    @Transactional
    public String addTransaction(Transaction transaction) {
        entityManager.persist(transaction);
        return "success";
    }

    @Override
	public Transaction getTransaction(int TransactionId) {
       return entityManager.find(Transaction.class,TransactionId );
    }

    @Override
    public List<Transaction> getAllTransactions() {
        String queryString = " from Transaction";
        List<Transaction> transaction = entityManager.createQuery(queryString).getResultList();
        return transaction;
    }


}