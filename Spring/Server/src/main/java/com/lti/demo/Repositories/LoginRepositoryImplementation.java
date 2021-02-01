package com.lti.demo.Repositories;

import com.lti.demo.POJOs.EMI;
import com.lti.demo.POJOs.Login;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
@Repository
public class LoginRepositoryImplementation implements LoginRepository{
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public List<Login> getAllLogins() {
        //This returns all the unverified users
        //1 is approved, 0 is not approved -1 is rejected
        String queryString = "select l from Login l where l.UserApprovalStatus=0";
        List<Login> resultList = entityManager.createQuery(queryString).getResultList();
        return resultList;
    }

    @Transactional
    public String addLogin(Login login) {
        entityManager.persist(login);
        return "success";
    }

    @Override
    public Login getLogin(String userName) {
        String queryString = "select l from Login l where l.userName="+userName;
        List<Login> resultList = entityManager.createQuery(queryString).getResultList();
        return resultList.get(0);
    }

    @Transactional
    public String updateLogin(Login login) {
        entityManager.merge(login);
        return "success";
    }
}
