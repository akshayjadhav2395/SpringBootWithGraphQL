package com.rms.service;

import java.util.Optional;

import com.rms.modal.Product;

public interface ProductServiceI {

	public Product addProduct(Product product);
	public Iterable<Product> getAllProduct();
	public Optional<Product> getSingleProduct(int productId);
	public Product editProduct(Product product, int productId);
	public void deleteProduct(int productId);

}
