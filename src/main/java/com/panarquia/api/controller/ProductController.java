package com.panarquia.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.panarquia.api.domain.DTOs.IViewProductDTO;
import com.panarquia.api.domain.DTOs.impl.CreateProductDTO;
import com.panarquia.api.domain.DTOs.impl.ViewProductDTO;
import com.panarquia.api.domain.service.IProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private IProductService productService;

	@RequestMapping("/list")
	public List<IViewProductDTO> getProducts() {
		List<IViewProductDTO> products = new ArrayList<>();

		productService.getProducts(products);

		return products;
	}

	@RequestMapping(value ="/{productId}")
	public IViewProductDTO getProductById(@PathVariable("productId") Long productId) {
		IViewProductDTO productDTO = new ViewProductDTO();
		productDTO.setId(productId);

		productService.getProductById(productDTO);

		return productDTO;
	}

	@RequestMapping(value ="/create")
	public void createProduct(@RequestBody CreateProductDTO productDTO) {
		productService.createProduct(productDTO);
	}

}
