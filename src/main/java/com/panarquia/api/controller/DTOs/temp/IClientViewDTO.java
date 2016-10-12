package com.panarquia.api.controller.DTOs.temp;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.panarquia.api.domain.DTOs.IClientDTO;
import com.panarquia.api.domain.service.model.Order;

public interface IClientViewDTO extends IClientDTO {

	@JsonIgnore
	Boolean isAdmin();

	@JsonIgnore
	List<Order> getOrders();
	
}
