package com.panarquia.api.domain.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.panarquia.api.domain.DTOs.ICategoryDTO;
import com.panarquia.api.domain.service.ICategoryService;
import com.panarquia.api.domain.service.model.Category;
import com.panarquia.api.domain.service.repository.ICategoryRepository;

@Service
class CategoryService implements ICategoryService {

	@Autowired
	private ICategoryRepository repository;
	
	@Override
	public Category create(ICategoryDTO dto) {
		Category category = new Category(dto.getName(), dto.getDescription());
		
		return this.repository.save(category);
	}

	@Override
	public Category getById(long id) {
		return this.repository.findOne(id);
	}

	@Override
	public List<Category> getAll() {
		return this.repository.findAll();
	}

	@Override
	public void update(ICategoryDTO dto) {
		Category category = this.repository.getOne(dto.getId());
		
		category.update(dto.getName(), dto.getDescription());
		
		this.repository.save(category);
	}
	
}
