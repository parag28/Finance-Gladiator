package com.development.demo.layer2;


import com.development.demo.layer1.Login;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
public class LoginRepositoryImplementation implements LoginRepository {
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public List<Login> getAllLogins() {
        //This returns all the unverified users
        //1 is approved, 0 is not approved -1 is rejected
        String queryString = " from Login";
        System.out.println("Entity Manager: "+entityManager);
        List<Login> resultList = entityManager.createQuery(queryString).getResultList();
        List<Login> returnList = new ArrayList<>();
        for(Login login:resultList){
          if(login.getUserApprovalStatus()==0)
            returnList.add(login);
        }
        return returnList;
    }

    @Transactional
    public String addLogin(Login login) {
        System.out.println("Entity Manager: "+entityManager);
        entityManager.persist(login);
        return "success";
    }

    @Override
    public Login getLogin(String userName) {
        String queryString = "select l from Login l where l.username='"+userName+"'";
        List<Login> resultList = entityManager.createQuery(queryString).getResultList();
        return resultList.get(0);
    }

    @Transactional
    public String updateLogin(Login login) {
        entityManager.merge(login);
        return "success";
    }
}
