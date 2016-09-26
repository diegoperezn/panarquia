package com.panarquia.api.domain.service;

import java.util.List;

import com.panarquia.api.domain.DTOs.ICreateProductDTO;
import com.panarquia.api.domain.DTOs.IViewProductDTO;

public interface IProductService {

	void getProducts(List<IViewProductDTO> products);

	void getProductById(IViewProductDTO productDTO);

	void createProduct(ICreateProductDTO productDTO);
}
