package com.development.demo.layer4;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.development.demo.layer1.Purchase;
import com.development.demo.layer3.PurchaseService;

@RestController
@CrossOrigin
public class PurchaseController {
	@Autowired
	PurchaseService purchaseservice;
	
	@PostMapping(path = "/addPurchase")
    @ResponseBody
    @CrossOrigin
    public String addPurchase(@RequestBody Purchase purchase){
        try {
        	purchaseservice.addPurchaseService(purchase);
            return "success";
        }
        catch (Exception e){
            return "fail";
        }
    }
	
	 @GetMapping(value = "/getPurchase/{PurchaseId}")
	 @ResponseBody
	 @CrossOrigin
	 public Purchase getPurchase(@PathVariable int PurchaseId){
		 
		 try {
			 Purchase purchase1=purchaseservice.getPurchaseService(PurchaseId);
	           return purchase1;
	        }
	        catch (Exception e){
	        	 return null;
	        }
		 

	 }
	 @GetMapping("/getAllPurchases")
	 @ResponseBody
	 @CrossOrigin
	 public List<Purchase> getAllPurchases(){
		 List<Purchase> PurchaseList = (List<Purchase>) purchaseservice.getAllPurchasesService();
	     return PurchaseList;
	 

	 } 
}