package com.panarquia.api.controller.DTOs.impl;

import java.util.List;

import com.panarquia.api.domain.DTOs.IClientDTO;
import com.panarquia.api.domain.service.model.Order;

public class ClientDTO implements IClientDTO {

	private Long id;
	private String name;
	private String email;
	private String password;

	@Override
	public String getEmail() {
		return email;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public String getName() {
		return name;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// Properties not used for the client creation
	@Override
	public Boolean isAdmin() {
		return null;
	}

	@Override
	public List<Order> getOrders() {
		return null;
	}
}
