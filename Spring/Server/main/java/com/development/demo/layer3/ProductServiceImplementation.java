package com.development.demo.layer3;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.development.demo.layer1.Product;
import com.development.demo.layer2.ProductRepository;

@Service
public class ProductServiceImplementation  implements ProductService{
	@Autowired
	ProductRepository productrepository;

	@Override
	public String addProduct(Product product) {
		// TODO Auto-generated method stub
		 try{
	             productrepository.addProduct(product);
	             
	        }
	        catch(Exception e){
	        	System.out.println(e.getStackTrace());
	        }
		 return "AddProductService successful";
	}

	@Override
	public String updateProduct(Product product) {
		// TODO Auto-generated method stub
		 try{
			 
			 	productrepository.updateProduct(product);
			 			 	}
		 	catch(Exception e){
		 		System.out.println(e.getStackTrace());
        	}
		 return "UpdateProductService successful";

	}
	
	@Override
	public String deleteProduct(int productId) {
		// TODO Auto-generated method stub
		 try{
             	productrepository.deleteProduct(productId);
             	
		 	}
		 	catch(Exception e){
		 		System.out.println(e.getStackTrace());
        	}
		 return "DeleteProductService successful";
	}
	

	@Override
	public Product getProduct(int productId) {
		// TODO Auto-generated method stub
        Product product1=null;
		 try{
             	product1=productrepository.getProduct(productId);
             	
		 	}
		 	catch(Exception e){
		 		System.out.println(e.getStackTrace());
		 	}
		 	return product1;
	 }
	

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		 List<Product> product1=null;
		 try{
			 product1=productrepository.getAllProducts();
             
		 	}
		 	catch(Exception e){
		 		System.out.println(e.getStackTrace());
		 	}
		 	return product1;
	}	 
}
