package com.rms.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rms.dao.ProductRepo;
import com.rms.modal.Product;

@Service
public class ProductSeriveImpl implements ProductServiceI {

@Autowired
private ProductRepo productRepo;
	
	@Override
	public Product addProduct(Product product) {
		System.out.println("adding product");
		return productRepo.save(product);
	}

	@Override
	public Iterable<Product> getAllProduct() {
		System.out.println("fetching product");
		return productRepo.findAll();
	}

	@Override
	public Optional<Product> getSingleProduct(int productId) {
		System.out.println("fetching single product");
		return productRepo.findById(productId);
	}

	@Override
	public Product editProduct(Product product, int productId) {
		System.out.println("editing product");
		Product o=productRepo.findByProductId(productId);
		o.setProductName(product.getProductName());
		o.setDescription(product.getDescription());
		o.setCategory(product.getCategory());
		o.setQuantity(product.getQuantity());
		o.setPrice(product.getPrice());
		o.setAvailable(product.isAvailable());
		return productRepo.save(o);
	}

	@Override
	public void deleteProduct(int productId) {
		System.out.println("deleting product");
		productRepo.deleteById(productId);
	}

}
