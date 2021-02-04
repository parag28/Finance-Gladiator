package com.development.demo.layer4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.development.demo.layer1.Card;
import com.development.demo.layer3.CardService;

@RestController
@CrossOrigin
public class CardController {
	@Autowired
	CardService cardService;

	@PostMapping(path = "/addCard")
    @ResponseBody
    @CrossOrigin
    public String addCard(@RequestBody Card card){
        try {
        	return cardService.addCardService(card);
        }
        catch (Exception e){
            return "fail";
        }
    }

	 @GetMapping(value = "/getCard/{username}")
	 @ResponseBody
	 @CrossOrigin
	 public Card getCard(@PathVariable String username){

		 try {
			 return cardService.getCardService(username);
		 }
    catch (Exception e){
       return null;
    }


	 }


	 @PostMapping(path = "/updateCard")
	 @ResponseBody
	 @CrossOrigin
	 public String updateLogin(@RequestBody Card card){
		 try {
			  cardService.updateCardService(card);
			  return "success";
	     }
	     catch (Exception e){
		    return "fail";
	     }

	 }
}
