package com.lti.Repositories;

import java.util.List;

import com.lti.POJOs.Transaction;

public interface TransactionRepository {
    public String addTransaction(Transaction transaction);
    Transaction getTransaction(int TransactionId);
    public List<Transaction> getAllTransactions();
 }
