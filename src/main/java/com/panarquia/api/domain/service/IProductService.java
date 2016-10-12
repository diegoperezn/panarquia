package com.panarquia.api.domain.service;

import java.util.List;

import com.panarquia.api.domain.DTOs.IProductDTO;

public interface IProductService {

	IProductDTO getById(long productId);

	List<? extends IProductDTO> getAll();

	List<? extends IProductDTO> getProductsByCategoryId(Long categoryId);

	IProductDTO create(IProductDTO dto);

	void update(IProductDTO dto);

	void getById(Long id, IProductDTO product);

}
