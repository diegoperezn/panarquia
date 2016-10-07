package com.panarquia.api.domain.service;

import java.util.List;

import com.panarquia.api.domain.DTOs.IProductCreateDTO;
import com.panarquia.api.domain.DTOs.IProductViewDTO;

public interface IProductService {

	IProductViewDTO getById(long productId);

	List<? extends 	IProductViewDTO> getAll();

	void create(IProductCreateDTO productDTO);

	void update(IProductCreateDTO productDTO);

}
