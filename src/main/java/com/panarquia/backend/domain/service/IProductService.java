package com.panarquia.backend.domain.service;

import java.util.List;

import com.panarquia.backend.domain.DTOs.ICreateProductDTO;
import com.panarquia.backend.domain.DTOs.IViewProductDTO;

public interface IProductService {

	void getProducts(List<IViewProductDTO> products);

	void getProductById(IViewProductDTO productDTO);

	void createProduct(ICreateProductDTO productDTO);
}
