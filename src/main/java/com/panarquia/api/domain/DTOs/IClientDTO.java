package com.panarquia.api.domain.DTOs;

import java.util.List;

import com.panarquia.api.domain.service.model.Order;

public interface IClientDTO {

	Long getId();

	String getName();

	String getPassword();

	String getEmail();

	List<Order> getOrders();

	Boolean isAdmin();

}