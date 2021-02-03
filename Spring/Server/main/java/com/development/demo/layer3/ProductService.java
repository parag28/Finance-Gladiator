package com.development.demo.layer3;
import java.util.List;

import com.development.demo.layer1.Product;

public interface ProductService {
	    public String addProductService(Product product);
	    public String updateProductService(Product product);
	    public String deleteProductService(int productId);
	    public Product getProductService(int productId);
	    public List<Product> getAllProductsService();

}


