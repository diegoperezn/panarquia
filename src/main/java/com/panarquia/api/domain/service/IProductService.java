package com.panarquia.api.domain.service;

import java.util.List;

import com.panarquia.api.domain.DTOs.IProductCreateDTO;
import com.panarquia.api.domain.DTOs.IProductViewDTO;

public interface IProductService {

	IProductViewDTO getById(long productId);

	List<? extends 	IProductViewDTO> getAll();

	List<? extends 	IProductViewDTO> getProductsByCategoryId(Long categoryId);
	
	IProductViewDTO create(IProductCreateDTO dto);

	void update(IProductCreateDTO dto);

}
