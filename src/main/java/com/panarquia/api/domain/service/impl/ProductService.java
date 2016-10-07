package com.panarquia.api.domain.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.panarquia.api.domain.Category;
import com.panarquia.api.domain.Price;
import com.panarquia.api.domain.Product;
import com.panarquia.api.domain.DTOs.IProductCreateDTO;
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
	public Product getById(long id) {
		return repository.findOne(id);
	}

	@Override
	public void create(IProductCreateDTO productDTO) {
		Price price = new Price(productDTO.getPrice());
		Category category = this.categoryService.findById(productDTO.getCategoryId());
		
		Product product = new Product(productDTO.getName(), productDTO.getBriefDescription(),
				productDTO.getDescription(), price, category);

		this.repository.save(product);
	}

	@Override
	public void update(IProductCreateDTO productDTO) {
		Product product = this.repository.findOne(productDTO.getId());
		
		Price price = new Price(productDTO.getPrice());
		Category category = this.categoryService.findById(productDTO.getCategoryId());
		
		product.update(productDTO.getName(), productDTO.getBriefDescription(),
				productDTO.getDescription(), price, category);

		this.repository.save(product);
	}

}
