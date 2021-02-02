package com.development.demo.layer3;
import java.util.List;

import com.development.demo.layer1.Product;

public interface ProductService {
	    public String addProduct(Product product);
	    public String updateProduct(Product product);
	    public String deleteProduct(int productId);
	    public Product getProduct(int productId);
	    public List<Product> getAllProducts();

}


