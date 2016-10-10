package com.panarquia.api.domain.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.panarquia.api.domain.Category;
import com.panarquia.api.domain.DTOs.ICategoryDTO;
import com.panarquia.api.domain.repository.ICategoryRepository;
import com.panarquia.api.domain.service.ICategoryService;

@Service
public class CategoryService implements ICategoryService {

	@Autowired
	private ICategoryRepository categoryRepository;
	
	@Override
	public Category create(ICategoryDTO dto) {
		Category category = new Category(dto.getName(), dto.getDescription());
		
		return this.categoryRepository.save(category);
	}

	@Override
	public Category getById(long id) {
		return this.categoryRepository.findOne(id);
	}

	@Override
	public List<Category> getAll() {
		return this.categoryRepository.findAll();
	}

	@Override
	public void update(ICategoryDTO dto) {
		Category category = this.categoryRepository.getOne(dto.getId());
		
		category.update(dto.getName(), dto.getDescription());
		
		this.categoryRepository.save(category);
	}
	
}
