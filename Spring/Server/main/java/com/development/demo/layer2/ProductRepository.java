package com.development.demo.layer2;



import com.development.demo.layer1.Product;

import java.util.List;

public interface ProductRepository {
    public String addProduct(Product product);
    public String updateProduct(Product product);
    public String deleteProduct(int productId);
    public Product getProduct(int productId);
    public List<Product> getAllProducts();
}
