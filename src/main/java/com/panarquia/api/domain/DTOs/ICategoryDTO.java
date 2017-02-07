package com.panarquia.api.domain.DTOs;

public interface ICategoryDTO {

	void setId(Long id);
	
	void setName(String name);
	
	void setDescription(String description);
	
	Long getId();
	
	String getName();
	
	String getDescription();
	
}
