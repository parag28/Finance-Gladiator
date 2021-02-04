package com.development.demo.layer4;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.development.demo.layer1.Transaction;
import com.development.demo.layer3.TransactionService;

@RestController
@CrossOrigin
public class TransactionController {
	@Autowired
	TransactionService transactionservice;

	@PostMapping(path = "/addTransaction")
    @ResponseBody
    @CrossOrigin
    public String addTransaction(@RequestBody Transaction transaction){
        try {
            transactionservice.addTransactionService(transaction);
            return "success";
        }
        catch (Exception e){
            return "fail";
        }
    }

	 @GetMapping(value = "/getTransaction/{transactionId}")
	 @ResponseBody
	 @CrossOrigin
	 public Transaction getTransaction(@PathVariable int transactionId){

		 try {
		   return transactionservice.getTransactionService(transactionId);
		 }
      catch (Exception e){
       return null;
      }
	 }
	 @GetMapping("/getAllTransactions")
	 @ResponseBody
	 @CrossOrigin
	 public List<Transaction> getAllTransactions(){
	  try{
      return transactionservice.getAllTransactionsService();
    }
	  catch (Exception e){
      System.out.println("Encountered Exception");
      return null;
    }
	 }

	 }
