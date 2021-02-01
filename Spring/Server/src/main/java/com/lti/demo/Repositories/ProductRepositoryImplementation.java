package com.lti.demo.Repositories;

import com.lti.demo.POJOs.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
@Repository
public class ProductRepositoryImplementation implements ProductRepository{
    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public String addProduct(Product product) {
        entityManager.persist(product);
        return "success";
    }

    @Transactional
    public String updateProduct(Product product) {
        entityManager.merge(product);
        return "success";
    }

    @Transactional
    public String deleteProduct(int productId) {
        Product product = entityManager.find(Product.class,productId);
        entityManager.remove(product);
        return "success";
    }

    @Override
    public Product getProduct(int productId) {
        return entityManager.find(Product.class,productId);
    }

    @Override
    public List<Product> getAllProducts() {
       List<Product> products;
        products = (List<Product>) entityManager.createQuery(" from Product");
        return products;
    }
}
