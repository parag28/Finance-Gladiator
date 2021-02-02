package com.development.demo.layer3;

import java.util.List;

import com.development.demo.layer1.Transaction;

public interface TransactionsService  {
	public String addTransaction(Transaction transaction);
	Transaction getTransaction(int TransactionId);
	public List<Transaction> getAllTransactions();
}
