package com.panarquia.api.domain.DTOs;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public interface IPriceViewDTO extends IPriceDTO {

	long getId();

	@JsonFormat(pattern="dd-MM-yyyy HH:mm")
	Date getFrom();

	@JsonFormat(pattern="dd-MM-yyyy HH:mm")
	Date getTo();

}