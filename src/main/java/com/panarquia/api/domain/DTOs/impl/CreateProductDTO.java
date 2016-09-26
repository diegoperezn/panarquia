package com.panarquia.api.domain.DTOs.impl;

import com.panarquia.api.domain.DTOs.ICreateProductDTO;

public class CreateProductDTO implements ICreateProductDTO {

	private String name;
	private String briefDescription;
	private String description;
	private String urlPhoto;
	private Long categoryId;

	public void setName(String name) {
		this.name = name;
	}

	public void setBriefDescription(String briefDescription) {
		this.briefDescription = briefDescription;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setUrlPhoto(String urlPhoto) {
		this.urlPhoto = urlPhoto;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getBriefDescription() {
		return briefDescription;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public String getUrlPhoto() {
		return urlPhoto;
	}

	@Override
	public Long getCategoryId() {
		return categoryId;
	}
	
}
