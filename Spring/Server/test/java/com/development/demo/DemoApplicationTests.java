package com.development.demo;

import com.development.demo.layer1.Emi;
import com.development.demo.layer1.Login;
import com.development.demo.layer1.Product;
import com.development.demo.layer1.User;
import com.development.demo.layer2.EMIRepository;
import com.development.demo.layer2.LoginRepository;
import com.development.demo.layer2.ProductRepository;
import com.development.demo.layer2.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {
  @Autowired
  UserRepository userRepository;

  @Autowired
  EMIRepository emiRepository;

  @Autowired
  ProductRepository productRepository;
  @Autowired
  LoginRepository loginRepository;
  @Test
  public void loginAddTest(){
    System.out.println("Login Repository is: "+loginRepository);
    Login login = new Login();
    login.setUsername("andy");
    login.setUserApprovalStatus(0);
    login.setPassword("HelloWorld");
    login.setUsertype(1);
    System.out.println("Login :"+login);
    loginRepository.addLogin(login);
  }
  @Test
  public void loginGetTest(){
    Login login = loginRepository.getLogin("andy");
    System.out.println(login.getUsername());
    System.out.println(login.getPassword());
  }
  @Test
  public void loginGetAllTest(){
    List<Login> loginList = loginRepository.getAllLogins();
    for(Login login:loginList){
      System.out.println(login.getUsername());
      System.out.println(login.getPassword());
    }
  }

  @Test
  public void loginUpdateTest(){
    Login login = loginRepository.getLogin("andy");
    login.setUsertype(0);
    System.out.println(loginRepository.updateLogin(login));
  }
  @Test
  public void addUserTest(){
    User user = new User();
    user.setAddress("BellwoodAvenue");
    user.setBankname("TD Bank");
    user.setDateofbirth("18/06/1998");
    user.setIfsccode("TDOTTAWA");
    user.setEmail("andy@shawshank.com");
    user.setUsername("andy1009");
    user.setPhonenumber(998293234);
    user.setSavingsaccountnumber(10200202);
    System.out.println(userRepository.addUser(user));
  }
  @Test
  public void getUserTest(){
    User user = userRepository.getUser("andy01");
    System.out.println("Name: "+user.getName());
    System.out.println("Address: "+user.getAddress());
  }

  @Test
  public void updateUserTest(){
    User user = userRepository.getUser("andy01");
    user.setName("Andy Duffrene");
    System.out.println(userRepository.updateUser(user));
  }

  @Test
  public void addProductTest(){
    Product product = new Product();
    product.setProductname("Book:Book 3 Test");
    product.setProductprice(100);
    product.setProductpicture("SomePath");
    product.setProductinformation("Be Dusted, Read this");
    product.setNumberofproducts(100);
    System.out.println(productRepository.addProduct(product));
  }
  @Test
  public void getProductTest(){
    Product product = productRepository.getProduct(101);
    System.out.println("Product Name: "+product.getProductname());
    System.out.println("Product Quantity: "+product.getNumberofproducts());
  }

  @Test
  public void getAllProductsTest(){
    List<Product> products = new ArrayList<Product>();
    products = productRepository.getAllProducts();
    for(Product product: products){
      System.out.println(product.getProductid()+" product Id");
      System.out.println(product.getProductname()+" product Name");
      System.out.println(product.getProductprice()+" product Price");
    }
  }
  @Test
  public void updateProductTest(){
    Product product = productRepository.getProduct(101);
    product.setNumberofproducts(product.getNumberofproducts()-1);
    System.out.println(productRepository.updateProduct(product));
  }
  @Test
  public void deleteProductTest(){
    System.out.println(productRepository.deleteProduct(101));
  }
  @Test
  public void addEmiTest(){
    Emi emi = new Emi();
    Product product = productRepository.getProduct(101);
    User user = userRepository.getUser("andy01");
    emi.setProduct(product);
    emi.setUser(user);
    emi.setEmidate("12/10/2009");
    emi.setMonthlycharge(1009);
    emi.setRemainingemis(2);
    emi.setEmispaid(1);
    System.out.println(emiRepository.addEMI(emi));
  }
  @Test
  public void getEmiTest(){
    Emi emi = emiRepository.getEMI(1002);
    System.out.println("EMI Number: "+emi.getEmiid());
    System.out.println("Product: "+emi.getProduct().getProductname());
    System.out.println("User: "+emi.getUser().getUsername());
  }
  @Test
  public void getAllEmisTest(){
    List<Emi> emis = new ArrayList<Emi>();
    emis = emiRepository.getAllEMIs();
    for(Emi emi:emis){
      System.out.println("EMI Number: "+emi.getEmiid());
      System.out.println("Product: "+emi.getProduct().getProductname());
      System.out.println("User: "+emi.getUser().getUsername());
    }
  }
  @Test
  public void updateEmisTest(){
    Emi emi = emiRepository.getEMI(1001);
    emi.setEmispaid(2);
    emi.setRemainingemis(1);
    System.out.println(emiRepository.updateEMI(emi));
  }
}



