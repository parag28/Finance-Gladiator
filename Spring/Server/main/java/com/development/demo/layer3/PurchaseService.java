package com.development.demo.layer3;
import java.util.List;

import com.development.demo.layer1.*;

public interface PurchaseService {
    public String addPurchase(Purchase purchase);
    Purchase getPurchase(int PurchaseId);
    public List<Purchase> getAllPurchases();
 }