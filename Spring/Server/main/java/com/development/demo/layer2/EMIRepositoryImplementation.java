package com.development.demo.layer2;

import com.development.demo.layer1.Emi;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class EMIRepositoryImplementation implements EMIRepository {
    @PersistenceContext
    EntityManager entityManager;


    @Transactional
    public String addEMI(Emi emi) {
        entityManager.persist(emi);
        return "success";
    }

    @Override
    public Emi getEMI(int emiId) {
        String queryString = "select e from Emi e where e.emiid = "+emiId;
        List<Emi> emis = entityManager.createQuery(queryString).getResultList();
        return emis.get(0);
    }

    @Override
    public List<Emi> getAllEMIs() {
        String queryString = " from Emi";
        List<Emi> emis = entityManager.createQuery(queryString).getResultList();
        return emis;
    }

    @Transactional
    public String updateEMI(Emi emi) {
      System.out.println(entityManager);
        entityManager.merge(emi);
        return "success";
    }
}
