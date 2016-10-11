package com.panarquia.api.controller.DTOs.impl;

import java.util.Date;

import com.panarquia.api.domain.DTOs.IPriceDTO;

public class PricetDTO implements IPriceDTO {

	private Double price;

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public Double getPrice() {
		return price;
	}

	// unused getters
	@Override
	public Long getId() {
		return null;
	}

	@Override
	public Date getFrom() {
		return null;
	}

	@Override
	public Date getTo() {
		return null;
	}

}
