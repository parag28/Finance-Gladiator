package com.development.demo.layer3;

import com.development.demo.layer1.Login;

import java.util.List;

public interface LoginService {
  public String addLoginService(Login login);
  public Login getLoginService(String userName);
  public List<Login> getAllLoginsService();
  public String updateLoginService(Login login);
}
