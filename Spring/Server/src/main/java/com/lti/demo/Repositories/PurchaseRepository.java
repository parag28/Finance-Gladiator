package com.lti.demo.Repositories;

import com.lti.demo.POJOs.Purchase;

import java.util.List;

public interface PurchaseRepository {
    public String addPurchase(Purchase purchase);
    Purchase getPurchase(int PurchaseId);
    public List<Purchase> getAllPurchases();
 }
