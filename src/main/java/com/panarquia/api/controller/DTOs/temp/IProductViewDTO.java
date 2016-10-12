package com.panarquia.api.controller.DTOs.temp;

import com.panarquia.api.domain.DTOs.IProductDTO;

public interface IProductViewDTO extends IProductDTO {

	IPriceViewDTO getPrice();

}