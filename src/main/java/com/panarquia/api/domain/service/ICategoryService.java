package com.panarquia.api.domain.service;

import java.util.List;

import com.panarquia.api.domain.DTOs.ICategoryDTO;

public interface ICategoryService {

	void getById(ICategoryDTO category);

	void getAll(List<? extends ICategoryDTO> resultList);

	Long create(ICategoryDTO dto);

	void update(ICategoryDTO dto);

}
