package com.lti.Repositories;

import com.lti.POJOs.Card;

public interface CardRepository {
    String addCard(Card card);
    Card getCard(int cardId);
    String updateCard(Card card);
}