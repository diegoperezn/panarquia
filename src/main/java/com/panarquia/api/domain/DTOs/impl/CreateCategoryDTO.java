package com.panarquia.api.domain.DTOs.impl;

import com.panarquia.api.domain.DTOs.ICreateCategoryDTO;

public class CreateCategoryDTO implements ICreateCategoryDTO {

	private String name;
	private String description;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
