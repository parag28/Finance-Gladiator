package com.development.demo.layer4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.development.demo.layer1.User;
import com.development.demo.layer3.UserService;

@RestController
@CrossOrigin
public class UserController {
	@Autowired
	UserService userService;

	@PostMapping(path = "/addUser")
    @ResponseBody
    @CrossOrigin
    public String addUser(@RequestBody User user){
        try {
            userService.addUserService(user);
            return "success";
        }
        catch (Exception e){
            return "fail";
        }
    }

	 @GetMapping(value = "/getUser/{username}")
	 @ResponseBody
	 @CrossOrigin
	 public User getUser(@PathVariable String username){

		 try {
       return userService.getUserService(username);
		 }
    catch (Exception e){
       return null;
    }


	 }

	 @PostMapping(path = "/updateUser")
	 @ResponseBody
	 @CrossOrigin
	 public String updateUser(@RequestBody User user){
		 try {
	            userService.updateUserService(user);
	            return "success";
	     }
	     catch (Exception e){
	            return "fail";
	     }

	 }
}
