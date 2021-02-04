package com.development.demo;

import com.development.demo.layer1.Emi;
import com.development.demo.layer1.Login;
import com.development.demo.layer1.Product;
import com.development.demo.layer1.User;
import com.development.demo.layer2.EMIRepository;
import com.development.demo.layer2.LoginRepository;
import com.development.demo.layer2.ProductRepository;
import com.development.demo.layer2.UserRepository;
import com.development.demo.layer3.ProductService;

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
  
  @Autowired
  ProductService productService;
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
    Product product = productRepository.getProduct(1);
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
    Product product = productRepository.getProduct(1);
    product.setNumberofproducts(product.getNumberofproducts()-1);
    System.out.println(productRepository.updateProduct(product));
  }
  @Test
  public void deleteProductTest(){
    System.out.println(productRepository.deleteProduct(1));
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

	

	@Test
	public void AddProductServiceTest() {
		Product product1 = new Product();
	    product1.setProductname("iphone");
	    product1.setProductprice(10000);
	    product1.setProductpicture(".jpg");
	    product1.setProductinformation("new latest iphone");
	    product1.setNumberofproducts(5);
		String s1=productService.addProductService(product1);
		
		
	}
	@Test
	public void GetProductServiceTest() {
		Product p1=productService.getProductService(2);
		System.out.println("Product name"+p1.getProductname());
		System.out.println("product info"+p1.getProductinformation());
	}
	@Test
	public void GetAllProductServiceTest() {
		List<Product> productlist=new ArrayList<Product>();
		productlist=productService.getAllProductsService();
		for(Product product:productlist) {
			System.out.println("Product name"+product.getProductname());
			System.out.println("product info"+product.getProductinformation());
		
		}	
	}
	@Test
	public void UpdateProductServiceTest() {
		Product p1=productService.getProductService(2);
		p1.setProductinformation("new innovative and at low price");
		productService.updateProductService(p1);
		System.out.println("Product name"+p1.getProductname());
		System.out.println("product info"+p1.getProductinformation());

	}
	@Test
	public void DeleteProductServiceTest() {
		productService.deleteProductService(3);
	}
	
	@Test
	public void AddProductServiceTest() {
		Product product1 = new Product();
	    product1.setProductname("HP Pavillion 4");
	    product1.setProductprice(70000);
	    product1.setProductpicture("https://images.unsplash.com/photo-1575024357670-2b5164f470c3?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1500&q=80");
	    product1.setProductinformation("HP Pavilion is a line of consumer-oriented laptop and desktop computers produced by HP Inc.It was introduced in 1995 by erstwhile Hewlett-Packard.");
	    product1.setNumberofproducts(50);
		String s1=productService.addProductService(product1);
		
		
	}
	@Test
	public void AddProductServiceTest2() {
		Product product1 = new Product();
	    product1.setProductname("Canon EOS T6");
	    product1.setProductprice(60000);
	    product1.setProductpicture("https://images.unsplash.com/photo-1492850298657-e81006f7a54c?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=750&q=80");
	    product1.setProductinformation("Canon EOS (Electro-Optical System) is an autofocus single-lens reflex camera (SLR) and mirrorless camera series produced by Canon Inc.");
	    product1.setNumberofproducts(50);
		String s1=productService.addProductService(product1);
		
		
	}
	@Test
	public void AddProductServiceTest3() {
		Product product1 = new Product();
	    product1.setProductname("iPhone 6+");
	    product1.setProductprice(20000);
	    product1.setProductpicture("https://images.unsplash.com/photo-1510878933023-e2e2e3942fb0?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=751&q=80");
	    product1.setProductinformation("The iPhone 6 and 6 Plus include larger 4.7 and 5.5 inches (120 and 140 mm) displays,a faster processor, upgraded cameras, improved LTE and Wi-Fi connectivity");
	    product1.setNumberofproducts(50);
		String s1=productService.addProductService(product1);
		
		
	}
	@Test
	public void AddProductServiceTest4() {
		Product product1 = new Product();
	    product1.setProductname("Dining Table");
	    product1.setProductprice(30000);
	    product1.setProductpicture("https://images.unsplash.com/photo-1565320690707-1d3d10541559?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=750&q=80");
	    product1.setProductinformation("A beautiful minimalistic dining table designed by Randy Fath. It fits in the small area also.");
	    product1.setNumberofproducts(50);
		String s1=productService.addProductService(product1);
		
		
	}
	@Test
	public void AddProductServiceTest5() {
		Product product1 = new Product();
	    product1.setProductname("Mini Bookshelf");
	    product1.setProductprice(25000);
	    product1.setProductpicture("https://images.unsplash.com/photo-1611486212557-88be5ff6f941?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=750&q=80");
	    product1.setProductinformation("Beautifully designed minimalistic book shelf which can store 10 books at a time and it's top can be used as tea-poy.");
	    product1.setNumberofproducts(50);
		String s1=productService.addProductService(product1);
		
		
	}
	@Test
	public void AddProductServiceTest6() {
		Product product1 = new Product();
	    product1.setProductname("Sofa");
	    product1.setProductprice(40000);
	    product1.setProductpicture("https://images.unsplash.com/photo-1484101403633-562f891dc89a?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=753&q=80");
	    product1.setProductinformation("Rich sofa design by kernado janpi, gives decent look to the living room. It has wooden built at the base.");
	    product1.setNumberofproducts(50);
		String s1=productService.addProductService(product1);
		
		
	}
	@Test
	public void AddProductServiceTest7() {
		Product product1 = new Product();
	    product1.setProductname("King's Cooker");
	    product1.setProductprice(5000);
	    product1.setProductpicture("https://images.unsplash.com/photo-1584990347955-2ec0431a6e8f?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=750&q=80");
	    product1.setProductinformation("King's cooker comes in 4+1 set which consists of 1 cooker along with 2 Pans and other utensils.It has aluminium finish with 2 year warranty");
	    product1.setNumberofproducts(50);
		String s1=productService.addProductService(product1);
		
		
	}

	@Test
	public void AddProductServiceTest8() {
		Product product1 = new Product();
	    product1.setProductname("Prime's Vending Machine");
	    product1.setProductprice(10000);
	    product1.setProductpicture("https://images.unsplash.com/photo-1588931196804-75b9cb0cd2a1?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=750&q=80");
	    product1.setProductinformation("It is an automated vending machine which is having a electric as welll as battery support.It has specific settings for each items individually, Highly recommended");
	    product1.setNumberofproducts(50);
		String s1=productService.addProductService(product1);
		
		
	}
	@Test
	public void AddProductServiceTest9() {
		Product product1 = new Product();
	    product1.setProductname("Surya's Stove");
	    product1.setProductprice(9000);
	    product1.setProductpicture("https://images.unsplash.com/photo-1527195575508-5b138d14a35b?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=751&q=80");
	    product1.setProductinformation("Introducing Surya's Deluxe Glass tops GTD 02 SS,Heat Resistant Gas stove, with 2 Year Warranty on Full Product. Body Material: Glass, Stainless Steel, Easy to clean.");
	    product1.setNumberofproducts(50);
		String s1=productService.addProductService(product1);
		
		
	}

	
}
