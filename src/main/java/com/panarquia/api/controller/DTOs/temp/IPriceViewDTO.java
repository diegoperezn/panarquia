package com.panarquia.api.controller.DTOs.temp;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.panarquia.api.domain.DTOs.IPriceDTO;

@JsonInclude(Include.NON_NULL)
public interface IPriceViewDTO extends IPriceDTO {

	@JsonIgnore
	Long getId();

	@JsonFormat(pattern="dd-MM-yyyy HH:mm")
	Date getFrom();

	@JsonFormat(pattern="dd-MM-yyyy HH:mm")
	Date getTo();

}