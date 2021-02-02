package com.development.demo.layer2;


import com.development.demo.layer1.User;

public interface UserRepository {
    String addUser(User user);
    User getUser(String userId);
    String updateUser(User user);
}
