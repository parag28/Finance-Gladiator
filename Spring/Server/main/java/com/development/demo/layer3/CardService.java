package com.development.demo.layer3;

import com.development.demo.layer1.Card;

public interface CardService {
	 public	String addCardService(Card card);
	 public Card getCardService(int cardId);
	 public String updateCardService(Card card);
}
