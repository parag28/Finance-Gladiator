package com.development.demo.layer2;

import com.development.demo.layer1.Login;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoginRepository {
    List<Login> getAllLogins();
    String addLogin(Login login);
    Login getLogin(String userName);
    String updateLogin(Login login);
}
