package com.panarquia.api.domain.DTOs;

public interface IProductDTO {

	Long getId();

	String getName();

	String getBriefDescription();

	String getDescription();

	IPriceDTO getPrice();

	ICategoryDTO getCategory();
}