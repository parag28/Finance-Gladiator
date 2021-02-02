package com.lti.demo.Repositories;

import com.lti.demo.POJOs.Transaction;
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
        String queryString = "select t from Transaction t where t.Transactionid = "+TransactionId;
        List<Transaction> transaction = entityManager.createQuery(queryString).getResultList();
        return transaction.get(0);
    }

    @Override
    public List<Transaction> getAllTransactions() {
        String queryString = " from Transaction";
        List<Transaction> transaction = entityManager.createQuery(queryString).getResultList();
        return transaction;
    }


}