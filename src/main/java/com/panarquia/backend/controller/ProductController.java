package com.panarquia.backend.controller;

import java.util.ArrayList;
import java.util.List;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.panarquia.backend.domain.DTOs.IProductViewDTO;
import com.panarquia.backend.domain.service.IProductService;
import com.panarquia.backend.domain.service.impl.ProductService;

@Api(name = "product", version = "1")
public class ProductController {

	private IProductService productService = ProductService.getInstance();
	
	@ApiMethod(path = "listAll", name = "listAll",
		    httpMethod = ApiMethod.HttpMethod.GET)
	public List<IProductViewDTO> getAllProducts(){
		List<IProductViewDTO> products = new ArrayList<>();

		productService.getProducts(products);
		
		return products;
	}
	
}
