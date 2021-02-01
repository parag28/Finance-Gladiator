package com.lti.demo.repositories;

import com.lti.demo.POJOs.Transaction;

import java.util.List;

public interface TransactionRepository {
    public String addTransaction(Transaction transaction);
    Transaction getTransaction(int TransactionId);
    public List<Transaction> getAllTransactions();
 }
