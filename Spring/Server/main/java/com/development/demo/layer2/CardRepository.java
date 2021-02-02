package com.development.demo.layer2;

import com.development.demo.layer1.Card;

public interface CardRepository {
    String addCard(Card card);
    Card getCard(int cardId);
    String updateCard(Card card);
}
