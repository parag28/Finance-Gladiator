package com.development.demo.layer3;

import com.development.demo.layer1.Login;
import com.development.demo.layer2.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class LoginServiceImplementation implements LoginService{
  @Autowired
  LoginRepository loginRepository;
  @Override
  public String addLoginService(Login login) {
  try {
    String message=loginRepository.addLogin(login);
    System.out.println(message);
    return "success";
  }
  catch (Exception e){
    System.out.println(e.getMessage());
    return "fail";
  }
  }

  @Override
  public Login getLoginService(String userName) {
    try{
      return loginRepository.getLogin(userName);
    }
    catch (Exception e){
      Login login = new Login();
      login.setUsername("erroruser");
      return  login;
    }
  }

  @Override
  public List<Login> getAllLoginsService() {
    try{
      return loginRepository.getAllLogins();
    }
    catch(Exception e){
      System.out.println(e.getMessage());
      return null;
    }
  }

  @Override
  public List<Login> getAllLoginsAllService() {
    try{
      return loginRepository.getAllLoginsAll();
    }
    catch(Exception e){
      System.out.println(e.getMessage());
      return new ArrayList<Login>();
    }
  }

  @Override
  public String updateLoginService(Login login) {
    System.out.println("Entered update Login Service");
    try{
      return loginRepository.updateLogin(login);
    }
    catch(Exception e){
      System.out.println(e.getMessage());
      return "fail";
    }
  }
}
