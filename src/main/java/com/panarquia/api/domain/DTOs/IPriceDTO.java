package com.panarquia.api.domain.DTOs;

import java.util.Date;

public interface IPriceDTO {

	Long getId();

	Double getPrice();

	Date getFrom();

	Date getTo();
}