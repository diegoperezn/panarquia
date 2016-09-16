package com.panarquia.backend.domain.repository;

import java.util.List;

import com.panarquia.backend.domain.Product;

public interface IProductRepository {

	List<Product> retrieveAllProdcuts();
	
	void save(Product product);
	
	Product getProduct(Long id);
}
