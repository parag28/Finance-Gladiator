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

import com.development.demo.layer1.Emi;
import com.development.demo.layer3.EmiService;

@RestController
@CrossOrigin
public class EMIController {

	@Autowired
	EmiService emiService;
	@GetMapping(value="/getEMI/{EMIId}")
	@ResponseBody
	@CrossOrigin
	public Emi getEMI(@PathVariable int EMIId)
	{
		try {
			return emiService.getEMIService(EMIId);
		}catch(Exception e) {
			System.out.println("Exception");
			return null;
		}

	}

	@GetMapping("/getAllEMIs")
	@ResponseBody
	@CrossOrigin
	public List<Emi>getAllEMIs(){
    return emiService.getAllEMIsService();
	}

	@PostMapping(path="/addEMI")
	@ResponseBody
	@CrossOrigin
	public String addEMI(@RequestBody Emi emi)
	{
		try {
			return emiService.addEMIService(emi);
		}catch(Exception e) {
      System.out.println(e.getMessage());
			return e.getMessage();
		}
	}

	@PostMapping(path="/updateEMI")
	@ResponseBody
	@CrossOrigin
	public String updateEMI(@RequestBody Emi emi)
	{
		try {
			return emiService.updateEMIService(emi);
		}catch(Exception e) {
			return "fail";
		}
	}
}
