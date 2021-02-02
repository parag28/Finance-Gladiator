package com.development.demo.layer3;

import com.development.demo.layer1.User;

public interface UserService {
  public String addUserService(User user);
  public User getUserService(String userName);
  public String updateUserService(User user);
}
