package com.development.demo.layer3;

import com.development.demo.layer1.Card;

public interface CardService {
	 public	String addCardService(Card card);
	 public Card getCardService(String userName);
	 public String updateCardService(Card card);
}
