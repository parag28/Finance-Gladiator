package com.lti.Repositories;

import java.util.List;


public interface PurchaseRepository {
    public String addPurchase(Purchase purchase);
    Purchase getPurchase(int PurchaseId);
    public List<Purchase> getAllPurchases();
 }
