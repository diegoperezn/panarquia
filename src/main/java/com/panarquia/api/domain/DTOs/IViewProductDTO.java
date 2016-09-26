package com.panarquia.api.domain.DTOs;

public interface IViewProductDTO {

	long getId();
	
	void setId(long id);

	void setName(String name);

	void setBriefDescription(String briefDescription);

	void setDescription(String description);

	void setUrlPhoto(String urlPhoto);

}