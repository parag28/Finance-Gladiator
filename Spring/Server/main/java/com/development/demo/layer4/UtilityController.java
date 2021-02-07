package com.development.demo.layer4;

import com.development.demo.DTO.PurchaseProductDTO;
import com.development.demo.DTO.UserInitializeDTO;
import com.development.demo.layer1.*;
import com.development.demo.layer1.Emi;
import com.development.demo.layer3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@CrossOrigin
public class UtilityController {
  @Autowired
  LoginService loginService;

  @Autowired
  UserService userService;

  @Autowired
  CardService cardService;

  @Autowired
  ProductService productService;

  @Autowired
  PurchaseService purchaseService;


  @Autowired
  TransactionService transactionService;

  @Autowired
  EmiService emiService;

  private long generateCardNumber(){
    Random r = new Random( System.currentTimeMillis() );
    return ((1 + r.nextInt(2)) * 100000 + r.nextInt(100000));
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
    user.setBankname(userInitializeDTO.getBankName());
    user.setIfsccode(userInitializeDTO.getIfscCode());
    user.setAddress(userInitializeDTO.getAddress());
    String message = userService.addUserService(user);
    System.out.println("User service message"+message);
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
    int creditRemaining;
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
    card.setValidupto(validUpto);
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
  @PostMapping(path = "/purchaseProduct")
  @ResponseBody
  @CrossOrigin
  public String purchaseProduct(@RequestBody PurchaseProductDTO purchaseProductDTO){
    int numberOfEmis = purchaseProductDTO.getNumberOfEmis();
    int productId = purchaseProductDTO.getProductId();
    String userName = purchaseProductDTO.getUserName();
    int quantity = purchaseProductDTO.getQuantity();

    Purchase purchase = new Purchase();
    Date date = Calendar.getInstance().getTime();
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    String strDate = dateFormat.format(date);
    purchase.setPurchasedate(strDate);
    purchase.setUser(userService.getUserService(userName));
    purchase.setProduct(productService.getProductService(productId));
    String message = purchaseService.addPurchaseService(purchase);
    System.out.println(message);
    Transaction transaction = new Transaction();
    transaction.setUser(userService.getUserService(userName));
    transaction.setProduct(productService.getProductService(productId));

    /*10 % is first month and the rest is given to EMIS distributed over the number of months*/
    /*
    * Address the credit unavailable condition
    * */
    int transactionAmount ;
    int totalCost = productService.getProductService(productId).getProductprice()*quantity;
    transactionAmount = totalCost/10;
    int emiAmount = ((totalCost/10)*9)/numberOfEmis;
    transaction.setTransactionamount(transactionAmount);
    transaction.setTransactionstatus(1);
    message = transactionService.addTransactionService(transaction);
    System.out.println(message);
    //message for debugging and adding further conditions
    //if message is something return something kind

    Product product = productService.getProductService(productId);
    product.setNumberofproducts(product.getNumberofproducts()-quantity);
    message = productService.updateProductService(product);
    System.out.println(message);

    Card card = cardService.getCardService(userName);
    card.setCreditremaining(card.getCreditremaining()-totalCost+transactionAmount);
    cardService.updateCardService(card);

    Emi emi = new Emi();
    emi.setEmidate(strDate);
    emi.setEmispaid(1);
    emi.setRemainingemis(numberOfEmis);
    emi.setMonthlycharge(emiAmount);
    emi.setUser(userService.getUserService(userName));
    emi.setProduct(productService.getProductService(productId));
    message = emiService.addEMIService(emi);
    System.out.println(message);
    return "success";
  }

  @GetMapping("/getAllUserEMIs/{userName}")
  @ResponseBody
  @CrossOrigin
  public List<Emi> getAllUserEMIs(@PathVariable String userName){
    //We need only the EMIs that are
    List<Emi> bufferList = emiService.getAllEMIsService();
    List<Emi> returnList = new ArrayList<Emi>();
    for(Emi emi:bufferList){
      if(emi.getUser().getUsername().equals(userName) && (emi.getRemainingemis() > 0)){
        returnList.add(emi);
      }
    }
    return returnList;
  }

  @GetMapping("/getAllUserOrders/{userName}")
  @ResponseBody
  @CrossOrigin
  public List<Purchase> getAllUserOrders(@PathVariable String userName){
    //We need only the EMIs that are
    List<Purchase> bufferList = purchaseService.getAllPurchasesService();
    List<Purchase> returnList = new ArrayList<Purchase>();
    for(Purchase purchase:bufferList){
      if(purchase.getUser().getUsername().equals(userName)){
        returnList.add(purchase);
      }
    }
    return returnList;
  }

  @GetMapping("/getAllTransactionsByUserName/{userName}")
  @ResponseBody
  @CrossOrigin
  public List<Transaction> getAllTransactionsByUserName(@PathVariable String userName){
    //We need only the EMIs that are
    List<Transaction> bufferList = transactionService.getAllTransactionsService();
    List<Transaction> returnList = new ArrayList<Transaction>();
    for(Transaction transaction:bufferList){
      if(transaction.getUser().getUsername().equals(userName)){
        returnList.add(transaction);
      }
    }
    return returnList;
  }

  @GetMapping(value = "/payEmi/{emiId}")
  @ResponseBody
  @CrossOrigin
  public String payEMI(@PathVariable int emiId){
    Emi emi = emiService.getEMIService(emiId);
    int transactionAmount = emi.getMonthlycharge();
    Date date = Calendar.getInstance().getTime();
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    String strDate = dateFormat.format(date);
    Transaction transaction = new Transaction();
    transaction.setUser(emi.getUser());
    transaction.setProductquantity(0);
    transaction.setProduct(emi.getProduct());
    transaction.setTransactionstatus(1);
    transaction.setTransactionamount(emi.getMonthlycharge());
    String message = transactionService.addTransactionService(transaction);
    System.out.println(message);
    Card card = cardService.getCardService(emi.getUser().getUsername());
    card.setCreditremaining(card.getCreditremaining()+transactionAmount);
    message = cardService.updateCardService(card);
    System.out.println(message);
    //if remaining emis are less than zero, login in Angular

    emi.setRemainingemis(emi.getRemainingemis()-1);
    emi.setEmispaid(emi.getEmispaid()+1);
    message = emiService.updateEMIService(emi);
    System.out.println(message);
    return "success";
  }
}
