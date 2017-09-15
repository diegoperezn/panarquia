package com.panarquia.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.panarquia.api.controller.DTOs.impl.CreateProductDTO;
import com.panarquia.api.domain.DTOs.IProductDTO;
import com.panarquia.api.domain.service.IProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private IProductService productService;

	@RequestMapping(method = RequestMethod.GET)
	public List<? extends IProductDTO> getProducts() {
		return productService.getAll();
	}

	@RequestMapping(value = "/byCategory/{categoryId}", method = RequestMethod.GET)
	public List<? extends IProductDTO> getProductsByCategoryId(@PathVariable("categoryId") Long categoryId) {
		return productService.getProductsByCategoryId(categoryId);
	}

	@RequestMapping(value = "/{productId}", method = RequestMethod.GET)
	public IProductDTO getProductById(@PathVariable("productId") Long productId) {
		return productService.getById(productId);
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.PUT)
	public IProductDTO createProduct(@RequestBody CreateProductDTO productDTO) {
		return productService.create(productDTO);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public void updateProduct(@RequestBody CreateProductDTO productDTO) {
		productService.update(productDTO);
	}
}
