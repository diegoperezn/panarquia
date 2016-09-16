package com.panarquia.backend.domain.service.impl;

import java.util.List;

import com.panarquia.backend.domain.Product;
import com.panarquia.backend.domain.DTOs.IProductViewDTO;
import com.panarquia.backend.domain.DTOs.impl.ProductViewDTO;
import com.panarquia.backend.domain.repository.IProductRepository;
import com.panarquia.backend.domain.repository.impl.ProductRepository;
import com.panarquia.backend.domain.service.IProductService;

public class ProductService implements IProductService {
	
	private static final ProductService INSTANCE = new ProductService();
	public static ProductService getInstance() {
		return INSTANCE; 
	}
	
	private IProductRepository productRepository = ProductRepository.getInstance(); 
	
	@Override
	public void getProducts(List<IProductViewDTO> products) {
		List<Product> domainProducts = productRepository.retrieveAllProdcuts();
		
		for (Product product : domainProducts) {
			IProductViewDTO productDto = buildProductViewDTO(product);
			
			products.add(productDto);
		}
	}

	@Override
	public void getProductById(ProductViewDTO productDTO) {
		Product product = productRepository.getProduct(productDTO.getId());
			
		buildProductViewDTO(product, productDTO);
	}
	
	private void buildProductViewDTO(Product product, IProductViewDTO productDto) {
		productDto.setBriefDescription(product.getBriefDescription());
		productDto.setDescription(product.getDescription());
		productDto.setId(product.getId());
		productDto.setName(product.getName());
		productDto.setUrlPhoto(product.getUrlPhoto());
	}

	private IProductViewDTO buildProductViewDTO(Product product) {
		IProductViewDTO productDTO = new ProductViewDTO();
		
		buildProductViewDTO(product, productDTO);
		
		return productDTO;
	}

}
