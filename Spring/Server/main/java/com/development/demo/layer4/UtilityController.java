package com.development.demo.layer4;

import com.development.demo.DTO.UserInitializeDTO;
import com.development.demo.layer1.Card;
import com.development.demo.layer1.Login;
import com.development.demo.layer1.User;
import com.development.demo.layer3.CardService;
import com.development.demo.layer3.LoginService;
import com.development.demo.layer3.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@CrossOrigin
public class UtilityController {
  @Autowired
  LoginService loginService;

  @Autowired
  UserService userService;

  @Autowired
  CardService cardService;

  private long generateCardNumber(){
    Random r = new Random( System.currentTimeMillis() );
    return ((1 + r.nextInt(2)) * 10000 + r.nextInt(10000));
  }
  @PostMapping(path = "/initializeUser")
  @ResponseBody
  @CrossOrigin
  public String initializeUser(@RequestBody UserInitializeDTO userInitializeDTO){
    User user = new User();
    user.setName(userInitializeDTO.getName());
    user.setDateofbirth(userInitializeDTO.getDateOfBirth());
    user.setPhonenumber(userInitializeDTO.getPhoneNumber());
    user.setEmail(userInitializeDTO.getEmail());
    user.setSavingsaccountnumber(userInitializeDTO.getAccountNumber());
    user.setUsername(userInitializeDTO.getUserName());
    user.setIfsccode(userInitializeDTO.getIfscCode());
    user.setAddress(userInitializeDTO.getAddress());
    String message = userService.addUserService(user);
    if(message.contains("fail")){
      return "fail";
    }
    String password = userInitializeDTO.getPassword();
    int cardType = userInitializeDTO.getCardType();
    Card card = new Card();
    Login login = new Login();
    login.setUsertype(0);
    login.setUserApprovalStatus(0);
    login.setUsername(user.getUsername());
    login.setPassword(password);
    int creditRemaining = 0;
    if(cardType==1){
      creditRemaining=10000;
    }
    else {
      creditRemaining=8000;
    }
    String validUpto="12/32";
    card.setCardnumber(generateCardNumber());
    card.setCreditremaining(creditRemaining);
    card.setCardtype(cardType);
    card.setUsername(user.getUsername());
    message = cardService.addCardService(card);
    if(message.contains("fail")){
      return "fail";
    }
    message = loginService.addLoginService(login);
    if(message.contains("fail")){
      return "fail";
    }
    return "success";
  }
}
