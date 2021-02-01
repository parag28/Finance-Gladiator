package com.lti.demo.repositories;

import com.lti.demo.POJOs.Card;

public interface CardRepository {
    String addCard(Card card);
    Card getCard(int cardId);
    String updateCard(Card card);
}