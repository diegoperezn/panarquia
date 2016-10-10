package com.panarquia.api.domain.DTOs;

import com.panarquia.api.domain.Product;

public class ProductViewDTO implements IProductViewDTO {

	IProductDTO productDTO;
	
	public ProductViewDTO(IProductDTO productDTO) {
		
	}
	
	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getBriefDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IPriceDTO getPrice() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ICategoryDTO getCategory() {
		// TODO Auto-generated method stub
		return null;
	}

}
