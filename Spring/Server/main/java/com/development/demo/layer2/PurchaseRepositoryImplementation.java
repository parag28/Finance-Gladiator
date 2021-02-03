package com.development.demo.layer2;
import com.development.demo.layer1.*;
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
    	return entityManager.find(Purchase.class,purchaseId );
    }

    @Override
    public List<Purchase> getAllPurchases() {
        String queryString = " from Purchase";
        List<Purchase> purchase = entityManager.createQuery(queryString).getResultList();
        return purchase;
    }


}