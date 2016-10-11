package com.panarquia.api.domain.DTOs;

import java.util.List;

import com.panarquia.api.domain.service.model.Order;

public interface IClientDTO {

	String getEmail();

	String getPassword();

	List<Order> getOrders();

	Long getId();

	String getName();

}