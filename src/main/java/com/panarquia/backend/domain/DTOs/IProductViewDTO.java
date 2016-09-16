package com.panarquia.backend.domain.DTOs;

public interface IProductViewDTO {

	long getId();
	
	void setId(long id);

	void setName(String name);

	void setBriefDescription(String briefDescription);

	void setDescription(String description);

	void setUrlPhoto(String urlPhoto);

}