package com.panarquia.api.domain.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.panarquia.api.domain.Product;
import com.panarquia.api.domain.DTOs.ICreateProductDTO;
import com.panarquia.api.domain.DTOs.IViewProductDTO;
import com.panarquia.api.domain.DTOs.impl.ViewProductDTO;
import com.panarquia.api.domain.repository.IProductRepository;
import com.panarquia.api.domain.service.IProductService;

@Service
public class ProductService implements IProductService {

	@Autowired
	private IProductRepository repository;

	@Override
	public void getProducts(List<IViewProductDTO> products) {
		List<Product> domainProducts = repository.findAll();

		for (Product product : domainProducts) {
			IViewProductDTO productDto = buildProductViewDTO(product);

			products.add(productDto);
		}
	}

	@Override
	public void getProductById(IViewProductDTO productDTO) {
		Product product = repository.findOne(productDTO.getId());

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
