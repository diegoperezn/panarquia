package com.panarquia.api.domain.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.panarquia.api.domain.Category;
import com.panarquia.api.domain.Price;
import com.panarquia.api.domain.Product;
import com.panarquia.api.domain.DTOs.IProductDTO;
import com.panarquia.api.domain.repository.IProductRepository;
import com.panarquia.api.domain.service.IProductService;

@Service
public class ProductService implements IProductService {

	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private IProductRepository repository;

	@Override
	public List<Product> getAll() {
		return repository.findAll();
	}

	@Override
	public List<Product> getProductsByCategoryId(Long categoryId) {
		return repository.getByCategoryId(categoryId);
	}

	@Override
	public Product getById(long id) {
		return repository.findOne(id);
	}
	
	@Override
	public Product create(IProductDTO dto) {
		Price price = new Price(dto.getPrice().getPrice());
		Category category = this.categoryService.getById(dto.getCategory().getId());
		
		Product product = new Product(dto.getName(), dto.getBriefDescription(),
				dto.getDescription(), price, category);

		return this.repository.save(product);
	}

	@Override
	public void update(IProductDTO dto) {
		Product product = this.repository.findOne(dto.getId());
		Category category = this.categoryService.getById(dto.getCategory().getId());
		
		Price price = null;
		if (!dto.getPrice().equals(product.getPrice().getPrice())) {
			price = new Price(dto.getPrice().getPrice());
		}
		
		product.update(dto.getName(), dto.getBriefDescription(),
				dto.getDescription(), price, category);

		this.repository.save(product);
	}

}
