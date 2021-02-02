package com.development.demo.layer3;

import com.development.demo.layer1.Login;
import com.development.demo.layer2.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LoginServiceImplementation implements LoginService{
  @Autowired
  LoginRepository loginRepository;
  @Override
  public String addLoginService(Login login) {
  try {
    String message=loginRepository.addLogin(login);
    System.out.println(message);//debug purpose
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
      System.out.println("Exception");
      return  null;
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
  public String updateLoginService(Login login) {
    try{
      return loginRepository.updateLogin(login);
    }
    catch(Exception e){
      System.out.println(e.getMessage());
      return "fail";
    }
  }
}
