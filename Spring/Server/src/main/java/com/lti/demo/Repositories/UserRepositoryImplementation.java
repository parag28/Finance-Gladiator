package com.lti.demo.Repositories;

import com.lti.demo.POJOs.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
@Repository
public class UserRepositoryImplementation implements UserRepository{
    @PersistenceContext
    EntityManager entityManager;
    @Transactional
    public String addUser(User user) {
        entityManager.persist(user);
        return "success";
    }

    @Override
    public User getUser(int userId) {
        return entityManager.find(User.class,userId);
    }

    @Transactional
    public String updateUser(User user) {
        entityManager.merge(user);
        return "success";
    }
}
