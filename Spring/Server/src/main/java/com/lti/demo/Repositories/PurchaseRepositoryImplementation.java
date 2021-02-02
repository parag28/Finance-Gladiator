package com.lti.demo.Repositories;

import com.lti.demo.POJOs.Purchase;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
@Repository
public class PurchaseRepositoryImplementation implements PurchaseRepository{
    @PersistenceContext
    EntityManager entityManager;


    @Transactional
    public String addPurchase(Purchase purchase) {
        entityManager.persist(purchase);
        return "success";
    }

    @Override
    public Purchase getPurchase(int purchaseId) {
        String queryString = "select p from Purchase p where p.purchaseid = "+purchaseId;
        List<Purchase> purchase = entityManager.createQuery(queryString).getResultList();
        return purchase.get(0);
    }

    @Override
    public List<Purchase> getAllPurchases() {
        String queryString = " from Purchase";
        List<Purchase> purchase = entityManager.createQuery(queryString).getResultList();
        return purchase;
    }


}