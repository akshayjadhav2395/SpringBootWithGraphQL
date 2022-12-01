package com.rms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rms.modal.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
	
	public Product findByProductId(int productId);

}
