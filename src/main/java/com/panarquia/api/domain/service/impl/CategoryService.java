package com.panarquia.api.domain.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.panarquia.api.domain.Category;
import com.panarquia.api.domain.DTOs.ICategoryDTO;
import com.panarquia.api.domain.DTOs.ICreateCategoryDTO;
import com.panarquia.api.domain.repository.ICategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private ICategoryRepository categoryRepository;
	
	public void create(ICreateCategoryDTO categoryDTO) {
		Category category = new Category(categoryDTO.getName(), categoryDTO.getDescription());
		
		this.categoryRepository.save(category);
	}
	
	public void getAll(List<ICategoryDTO> categoryDTOs) {
		categoryDTOs.addAll(this.categoryRepository.findAll());
	}
	
	public Category findById(long id) { 
		return this.categoryRepository.getOne(id);
		
	}
	
}
