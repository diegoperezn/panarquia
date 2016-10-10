package com.panarquia.api.domain.service;

import java.util.List;

import com.panarquia.api.domain.DTOs.ICategoryDTO;

public interface ICategoryService {
	
	ICategoryDTO getById(long id);

	List<? extends 	ICategoryDTO> getAll();

	ICategoryDTO create(ICategoryDTO dto);

	void update(ICategoryDTO dto);

}
