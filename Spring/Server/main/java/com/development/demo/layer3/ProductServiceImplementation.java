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
	public String addProductService(Product product) {
		 try{
		      productrepository.addProduct(product);
		 }
      catch(Exception e){
        System.out.println(e.getMessage());
      }
		 return "AddProductService successful";
	}

	@Override
	public String updateProductService(Product product) {
		 try{
			 	productrepository.updateProduct(product);
		 }
		 	catch(Exception e){
		 		System.out.println(e.getMessage());
		 }
		 return "UpdateProductService successful";

	}

	@Override
	public String deleteProductService(int productId) {
		 try{
		   productrepository.deleteProduct(productId);
       return "DeleteProductService successful";
		 	}
		 	catch(Exception e){
		 		System.out.println(e.getMessage());
		 		return null;
		 }

	}


	@Override
	public Product getProductService(int productId) {
		 try{
		   return productrepository.getProduct(productId);
		 	}
		 	catch(Exception e){
		 		System.out.println(e.getMessage());
		 		return null;
		 	}

	 }


	@Override
	public List<Product> getAllProductsService() {
   try{
     return productrepository.getAllProducts();
    }
    catch(Exception e){
      System.out.println(e.getMessage());
      return null;
    }
	}
}
