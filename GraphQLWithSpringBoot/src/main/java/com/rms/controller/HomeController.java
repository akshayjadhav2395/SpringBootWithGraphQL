package com.rms.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.Arguments;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.rms.modal.Product;
import com.rms.service.ProductSeriveImpl;
import com.rms.service.ProductServiceI;

@Controller
@CrossOrigin(origins = "*")
public class HomeController {

	@Autowired
	private ProductServiceI productSeriveImpl;
	
	
	@MutationMapping("addProducts")
	public Product addProduct(@Arguments ProductInput product)
	{
		Product pi=new Product();
		pi.setProductName(product.getProductName());
		pi.setCategory(product.getCategory());
		pi.setDescription(product.getDescription());
		pi.setPrice(product.getPrice());
		pi.setQuantity(product.getQuantity());
		pi.setAvailable(true);
		
		return productSeriveImpl.addProduct(pi);
	}
	
	@QueryMapping("getAllProduct")
	public Iterable<Product> getAllProduct()
	{
		return productSeriveImpl.getAllProduct();
	}
	
	@QueryMapping("getSingleProduct")
	public Optional<Product> getSingleProduct(@Argument int productId)
	{
		return productSeriveImpl.getSingleProduct(productId);
	}
	
//	@PutMapping("/product/{productId}")
//	public Product editProduct(@RequestBody Product product, @PathVariable int productId)
//	{
//		return productSeriveImpl.editProduct(product, productId);
//	}
//	
//	@DeleteMapping("/product/{productId}")
//	public void deleteProduct(@PathVariable int productId)
//	{
//		productSeriveImpl.deleteProduct(productId);
//	}

}


class ProductInput {
	
	private String productName;
	private String category;
	private String description;
	private double price;
	private int quantity;
	private boolean isAvailable;
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	@Override
	public String toString() {
		return "ProductInput [productName=" + productName + ", category=" + category + ", description=" + description
				+ ", price=" + price + ", quantity=" + quantity + ", isAvailable=" + isAvailable + "]";
	}
}

