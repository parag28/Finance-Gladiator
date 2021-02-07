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

import com.development.demo.layer1.Login;
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
            return loginService.addLoginService(login);
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
          return loginService.getLoginService(username);
		 }
		 catch (Exception e){
		   Login login = new Login();
		   login.setUsername("erroruser");
		   login.setPassword("erroruser");
		   return login;
      }


	 }
	 @GetMapping("/getAllLogin")
	 @ResponseBody
	 @CrossOrigin
	 public List<Login> getAllLogin(){
     return loginService.getAllLoginsService();
	 }

	 @PostMapping(path = "/updateLogin")
	 @ResponseBody
	 @CrossOrigin
	 public String updateLogin(@RequestBody Login login){
     System.out.println("Entered Update Login in Controller");
		 try {
	            loginService.updateLoginService(login);
              return "success";
	     }
	     catch (Exception e){
          return "fail";
	     }

	 }

	 /*
	 getAllLogin for the logins with a zero approval status.
	 This is for all the ones
	  */
  @GetMapping("/getAllLoginsAll")
  @ResponseBody
  @CrossOrigin
  public List<Login> getAllLoginsAll(){
    return loginService.getAllLoginsAllService();
  }

}
