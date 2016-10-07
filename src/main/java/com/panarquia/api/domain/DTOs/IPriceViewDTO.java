package com.panarquia.api.domain.DTOs;

import java.util.Date;

public interface IPriceViewDTO extends IPriceDTO {

	long getId();

	Date getFrom();

	Date getTo();

}