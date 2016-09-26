package com.panarquia.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.panarquia.api.domain.DTOs.IViewProductDTO;
import com.panarquia.api.domain.service.IProductService;

@RestController
public class ProductController {

	@Autowired
	private IProductService productService;

	@RequestMapping("/list")
	public List<IViewProductDTO> getProducts() {
		List<IViewProductDTO> products = new ArrayList<>();

		productService.getProducts(products);

		return products;
	}

//	@ApiMethod(path = "product/{id}", name = "productById", httpMethod = ApiMethod.HttpMethod.GET)
//	public IViewProductDTO getProductById(@Named("id") Long id) {
//		IViewProductDTO productDTO = new ViewProductDTO();
//		productDTO.setId(id);
//
//		productService.getProductById(productDTO);
//
//		return productDTO;
//	}

//	@ApiMethod(path = "create", name = "createProduct", httpMethod = ApiMethod.HttpMethod.POST)
//	public void createProduct(@Named("product") CreateProductDTO productDTO) {
//
//		productService.createProduct(productDTO);
//
//	}

}
