package com.panarquia.backend.domain.service;

import java.util.List;

import com.panarquia.backend.domain.DTOs.IProductViewDTO;
import com.panarquia.backend.domain.DTOs.impl.ProductViewDTO;

public interface IProductService {

	void getProducts(List<IProductViewDTO> products);

	void getProductById(ProductViewDTO productDTO);
}
