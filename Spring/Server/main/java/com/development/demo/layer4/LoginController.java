package com.development.demo.layer4;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.development.demo.layer1.Login;
import com.development.demo.layer1.Test;
import com.development.demo.layer3.LoginService;

@RestController
@CrossOrigin
public class LoginController {
	@Autowired
	LoginService loginService;
	
	@PostMapping(path = "/addLogin")
    @ResponseBody
    @CrossOrigin
    public String addLogin(@RequestBody Login login){
        try {
            loginService.addLoginService(login);
            return "success";
        }
        catch (Exception e){
            return "fail";
        }
    }
	
	 @GetMapping(value = "/getLogin/{username}")
	 @ResponseBody
	 @CrossOrigin
	 public Login getLogin(@PathVariable String username){
		 
		 try {
	           Login log=loginService.getLoginService(username);
	           return log;
	        }
	        catch (Exception e){
	        	 return null;
	        }
		 

	 }
	 @GetMapping("/getAllLogin")
	 @ResponseBody
	 @CrossOrigin
	 public List<Login> getAllLogin(){
		 List<Login> LoginList = (List<Login>) loginService.getAllLoginsService();
	     return LoginList;
	 }
	 
	 @PostMapping(path = "/updateLogin")
	 @ResponseBody
	 @CrossOrigin
	 public String updateLogin(@RequestBody Login login){
		 try {
	            loginService.updateLoginService(login);
	            return "success";
	     }
	     catch (Exception e){
	            return "fail";
	     }

	 } 
}
