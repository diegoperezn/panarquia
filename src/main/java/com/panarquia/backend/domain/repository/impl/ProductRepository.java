package com.panarquia.backend.domain.repository.impl;

import java.util.ArrayList;
import java.util.List;

import com.panarquia.backend.domain.Product;
import com.panarquia.backend.domain.repository.IProductRepository;

public class ProductRepository implements IProductRepository {

	private static final ProductRepository INSTANCE = new ProductRepository();

	public static ProductRepository getInstance() {
		return INSTANCE;
	}

	private List<Product> storedProducts = new ArrayList<>();

	public ProductRepository() {
		for (int i = 0; i < 100; i++) {
			storedProducts.add(i ,new Product(Long.valueOf(i), "Nombre " + i, "briefDescription " + i, "description " + i,
					"urlPhoto " + i, null, null));
		}
	}

	@Override
	public List<Product> retrieveAllProdcuts() {
		return this.storedProducts;
	}

	@Override
	public void save(Product product) {
		this.storedProducts.add(storedProducts.size(), product);
	}

	@Override
	public Product getProduct(Long id) {
		return this.storedProducts.get(id.intValue());
	}

}
