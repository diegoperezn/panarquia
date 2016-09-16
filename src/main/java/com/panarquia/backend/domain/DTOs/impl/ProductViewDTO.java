package com.panarquia.backend.domain.DTOs.impl;

import com.panarquia.backend.domain.DTOs.IProductViewDTO;

public class ProductViewDTO implements IProductViewDTO {

	private long id;
	private String name;
	private String briefDescription;
	private String description;
	private String urlPhoto;

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getBriefDescription() {
		return briefDescription;
	}

	public String getDescription() {
		return description;
	}

	public String getUrlPhoto() {
		return urlPhoto;
	}

	@Override
	public void setId(long id) {
		this.id = id;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void setBriefDescription(String briefDescription) {
		this.briefDescription = briefDescription;
	}

	@Override
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public void setUrlPhoto(String urlPhoto) {
		this.urlPhoto = urlPhoto;
	}
	
}
