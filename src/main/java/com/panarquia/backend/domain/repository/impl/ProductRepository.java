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

	private List<Product> StoredProducts = new ArrayList<>();
	
	public ProductRepository() {
		for (int i = 0; i < 100; i++) {
			StoredProducts.add(new Product(Long.valueOf(i), "Nombre " + i, "briefDescriptio n"  + i, "description "  + i, 
					"urlPhoto "  + i, null, null));
		}
	}
	
	@Override
	public List<Product> retrieveAllProdcuts() {
		return this.StoredProducts;
	}

	@Override
	public void save(Product product) {
		this.StoredProducts.add(product);
	}

	@Override
	public Product getProduct(long id) {
		for (Product product : StoredProducts) {
			if (product.getId() == id) {
				return product;
			}
		}
		
		return null;
	}
	
}
