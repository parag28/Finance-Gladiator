package com.development.demo.layer3;
import java.util.List;

import com.development.demo.layer1.*;

public interface PurchaseService {
    public String addPurchaseService(Purchase purchase);
    Purchase getPurchaseService(int PurchaseId);
    public List<Purchase> getAllPurchasesService();
 }
