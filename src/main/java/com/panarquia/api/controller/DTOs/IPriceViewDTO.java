package com.panarquia.api.controller.DTOs;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.panarquia.api.domain.DTOs.IPriceDTO;

public interface IPriceViewDTO extends IPriceDTO {

	@JsonIgnore
	Long getId();

	@JsonFormat(pattern="dd-MM-yyyy HH:mm")
	Date getFrom();

	@JsonFormat(pattern="dd-MM-yyyy HH:mm")
	Date getTo();

}