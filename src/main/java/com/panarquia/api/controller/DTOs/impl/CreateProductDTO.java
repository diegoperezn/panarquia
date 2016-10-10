package com.panarquia.api.controller.DTOs.impl;

import com.panarquia.api.domain.DTOs.ICategoryDTO;
import com.panarquia.api.domain.DTOs.IPriceDTO;
import com.panarquia.api.domain.DTOs.IProductDTO;

public class CreateProductDTO implements IProductDTO {

	private Long id;
	private String name;
	private String briefDescription;
	private String description;
	private Double price;
	private Long categoryId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBriefDescription() {
		return briefDescription;
	}

	public void setBriefDescription(String briefDescription) {
		this.briefDescription = briefDescription;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public IPriceDTO getPrice() {
		PricetDTO dto = new PricetDTO();
		
		dto.setPrice(this.price);
		
		return dto;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public ICategoryDTO getCategory() {
		CategoryDTO dto = new CategoryDTO();
		
		dto.setId(categoryId);
		
		return dto;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
