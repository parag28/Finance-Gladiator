package com.development.demo.layer4;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.development.demo.layer1.Product;
import com.development.demo.layer3.ProductService;

@RestController
@CrossOrigin
public class ProductController {

	@Autowired
    ProductService productService;
	
	@RequestMapping("/getAllProducts")
    @ResponseBody
    @CrossOrigin
    public List<Product> getAllProducts(){
        List<Product> productList= (List<Product>)productService.getAllProductsService();
		return productList;
    }
	
	@RequestMapping("/getProduct")
	@ResponseBody
	@CrossOrigin
	public Product getProduct(int productId)
	{
		try {
			return productService.getProductService(productId);
		}catch(Exception e) {
			System.out.println("Exception");
			return null;
		}	
	}
	
	@PostMapping(path="/updateProduct")
	@ResponseBody
	@CrossOrigin
	public String updateProduct(@RequestBody Product product)
	{
		try {
			return productService.updateProductService(product);
		}catch(Exception e) {
			return "fail";
		}
	}
	
	@PostMapping(path="/addProduct")
	@ResponseBody
	@CrossOrigin
	public String addProduct(@RequestBody Product product)
	{
		try {
			productService.addProductService(product);
			return "success";
		}catch(Exception e) {
			return "fail";
		}
	}
	
	 @DeleteMapping(value = "/deleteProduct/{id}")
	 @ResponseBody
	 @CrossOrigin
	 public String deleteProduct(@PathVariable int id){
		 return productService.deleteProductService(id);
	 }
}
