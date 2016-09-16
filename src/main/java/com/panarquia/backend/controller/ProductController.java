package com.panarquia.backend.controller;

import java.util.ArrayList;
import java.util.List;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.Named;
import com.panarquia.backend.domain.DTOs.IViewProductDTO;
import com.panarquia.backend.domain.DTOs.impl.CreateProductDTO;
import com.panarquia.backend.domain.DTOs.impl.ViewProductDTO;
import com.panarquia.backend.domain.service.IProductService;
import com.panarquia.backend.domain.service.impl.ProductService;

@Api(name = "products", version = "1")
public class ProductController {

	private IProductService productService = ProductService.getInstance();

	@ApiMethod(path = "list", name = "listAll", httpMethod = ApiMethod.HttpMethod.GET)
	public List<IViewProductDTO> getProducts() {
		List<IViewProductDTO> products = new ArrayList<>();

		productService.getProducts(products);

		return products;
	}

	@ApiMethod(path = "product/{id}", name = "productById", httpMethod = ApiMethod.HttpMethod.GET)
	public IViewProductDTO getProductById(@Named("id") Long id) {
		IViewProductDTO productDTO = new ViewProductDTO();
		productDTO.setId(id);

		productService.getProductById(productDTO);

		return productDTO;
	}

//	@ApiMethod(path = "create", name = "createProduct", httpMethod = ApiMethod.HttpMethod.POST)
//	public void createProduct(@Named("product") CreateProductDTO productDTO) {
//
//		productService.createProduct(productDTO);
//
//	}

}
