package com.lti.demo.repositories;

import com.lti.demo.POJOs.Card;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
@Repository
public class CardRepositoryImplementation implements CardRepository{
    @PersistenceContext
    EntityManager entityManager;
    @Transactional
    public String addCard(Card card) {
        entityManager.persist(card);
        return "success";
    }

    @Override
    public Card getCard(int cardId) {
        return entityManager.find(Card.class,cardId);
    }

    @Transactional
    public String updateCard(Card card) {
        entityManager.merge(card);
        return "success";
    }
}