package com.panarquia.api.domain.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.panarquia.api.domain.DTOs.ICategoryDTO;
import com.panarquia.api.domain.service.ICategoryService;
import com.panarquia.api.domain.service.model.Category;
import com.panarquia.api.domain.service.repository.ICategoryRepository;

@Service
class CategoryService implements ICategoryService {

	@Autowired
	private ICategoryRepository repository;

	@Override
	public Long create(ICategoryDTO dto) {
		Category category = new Category(dto.getName(), dto.getDescription());

		return this.repository.save(category).getId();
	}

	@Override
	public void getById(ICategoryDTO categoryDTO) {
		Assert.notNull(categoryDTO.getId(), "The id of the category is required");

		Category category = this.repository.getOne(categoryDTO.getId());

		categoryDTO.setName(category.getName());
		categoryDTO.setDescription(category.getDescription());
	}

	@Override
	public void getAll(List<? extends ICategoryDTO> resultList) {
		List<Category> categoryList = this.repository.findAll();

		for (int i = 0; i < categoryList.size(); i++) {
			ICategoryDTO result = resultList.get(i);
			Category category = categoryList.get(i);
			
			result.setId(category.getId());
			result.setName(category.getName());
			result.setDescription(category.getDescription());	
		}
	}

	@Override
	public void update(ICategoryDTO dto) {
		Category category = this.repository.getOne(dto.getId());

		category.update(dto.getName(), dto.getDescription());

		this.repository.save(category);
	}

}
