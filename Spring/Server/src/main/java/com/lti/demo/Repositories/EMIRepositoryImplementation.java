package com.lti.demo.Repositories;

import com.lti.demo.POJOs.EMI;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
@Repository
public class EMIRepositoryImplementation implements EMIRepository{
    @PersistenceContext
    EntityManager entityManager;


    @Transactional
    public String addEMI(EMI emi) {
        entityManager.persist(emi);
        return "success";
    }

    @Override
    public EMI getEMI(int emiId) {
        String queryString = "select e from EMI e where e.emiid = "+emiId;
        List<EMI> emis = entityManager.createQuery(queryString).getResultList();
        return emis.get(0);
    }

    @Override
    public List<EMI> getAllEMIs() {
        String queryString = " from EMI";
        List<EMI> emis = entityManager.createQuery(queryString).getResultList();
        return emis;
    }

    @Override
    public String updateEMI(EMI emi) {
        entityManager.merge(emi);
        return "success";
    }
}
