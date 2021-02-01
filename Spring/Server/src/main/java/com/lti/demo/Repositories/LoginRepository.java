package com.lti.demo.Repositories;

import com.lti.demo.POJOs.Login;

import java.util.List;

public interface LoginRepository {
    List<Login> getAllLogins();
    String addLogin(Login login);
    Login getLogin(String userName);
    String updateLogin(Login login);
}
