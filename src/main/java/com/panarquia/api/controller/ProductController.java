package com.panarquia.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.panarquia.api.domain.DTOs.IProductDTO;
import com.panarquia.api.domain.DTOs.IProductViewDTO;
import com.panarquia.api.domain.DTOs.impl.CreateProductDTO;
import com.panarquia.api.domain.service.IProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private IProductService productService;

	@RequestMapping("/")
	public List<? extends IProductViewDTO> getProducts() {
		return productService.getAll();
	}

	@RequestMapping(value ="/{productId}")
	public IProductDTO getProductById(@PathVariable("productId") Long productId) {
		return productService.getById(productId);
	}

	@RequestMapping(value ="/create")
	public void createProduct(@RequestBody CreateProductDTO productDTO) {
		productService.create(productDTO);
	}

	@RequestMapping(value ="/update")
	public void updateProduct(@RequestBody CreateProductDTO productDTO) {
		productService.update(productDTO);
	}
}
