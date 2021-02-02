package com.development.demo.layer3;

import com.development.demo.layer1.User;
import com.development.demo.layer2.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplementation implements UserService{
  @Autowired
  UserRepository userRepository;

  @Override
  public String addUserService(User user) {
    try{
        return userRepository.addUser(user);
    }
    catch(Exception e){
      System.out.println(e.getMessage());
      return "fail";
    }
  }

  @Override
  public User getUserService(String userName) {
    try{
      return userRepository.getUser(userName);
    }
    catch(Exception e){
      System.out.println(e.getMessage());
      return null;
    }
  }

  @Override
  public String updateUserService(User user) {
    try{
      return userRepository.updateUser(user);
    }
    catch(Exception e){
      System.out.println(e.getMessage());
      return null;
    }
  }
}
