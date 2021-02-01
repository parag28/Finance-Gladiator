package com.lti.demo.Repositories;

import com.lti.demo.POJOs.User;

public interface UserRepository {
    String addUser(User user);
    User getUser(int userId);
    String updateUser(User user);
}
