package com.development.demo.layer3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.development.demo.layer1.Card;
import com.development.demo.layer2.CardRepository;

@Service
public class CardServiceImplementation implements CardService {
	@Autowired
	CardRepository cardRepository;
	@Override
	public String addCardService(Card card) {
		try {
			return cardRepository.addCard(card);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		    return "fail";
		}
	}

	@Override
	public Card getCardService(String userName) {
		try {
			return cardRepository.getCard(userName);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		      return null;
		}
	}

	@Override
	public String updateCardService(Card card) {
		try {
			return cardRepository.updateCard(card);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		    return null;
		}
	}

}
