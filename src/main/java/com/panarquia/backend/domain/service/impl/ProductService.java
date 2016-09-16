package com.panarquia.backend.domain.service.impl;

import java.util.List;

import com.panarquia.backend.domain.Product;
import com.panarquia.backend.domain.DTOs.ICreateProductDTO;
import com.panarquia.backend.domain.DTOs.IViewProductDTO;
import com.panarquia.backend.domain.DTOs.impl.ViewProductDTO;
import com.panarquia.backend.domain.repository.IProductRepository;
import com.panarquia.backend.domain.repository.impl.ProductRepository;
import com.panarquia.backend.domain.service.IProductService;

public class ProductService implements IProductService {
	
	private static final ProductService INSTANCE = new ProductService();
	public static ProductService getInstance() {
		return INSTANCE; 
	}
	
	private IProductRepository repository = ProductRepository.getInstance(); 
	
	@Override
	public void getProducts(List<IViewProductDTO> products) {
		List<Product> domainProducts = repository.retrieveAllProdcuts();
		
		for (Product product : domainProducts) {
			IViewProductDTO productDto = buildProductViewDTO(product);
			
			products.add(productDto);
		}
	}

	@Override
	public void getProductById(IViewProductDTO productDTO) {
		Product product = repository.getProduct(productDTO.getId());
			
		buildProductViewDTO(product, productDTO);
	}
	
	@Override
	public void createProduct(ICreateProductDTO productDTO) {
		Product product = new Product(productDTO.getName(), productDTO.getBriefDescription(), 
				productDTO.getDescription(), productDTO.getUrlPhoto(), null, null);
		
		this.repository.save(product);
	}
	
	private void buildProductViewDTO(Product product, IViewProductDTO productDto) {
		productDto.setBriefDescription(product.getBriefDescription());
		productDto.setDescription(product.getDescription());
		productDto.setId(product.getId());
		productDto.setName(product.getName());
		productDto.setUrlPhoto(product.getUrlPhoto());
	}

	private IViewProductDTO buildProductViewDTO(Product product) {
		IViewProductDTO productDTO = new ViewProductDTO();
		
		buildProductViewDTO(product, productDTO);
		
		return productDTO;
	}

}
