package com.panarquia.api.domain.service.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.panarquia.api.domain.DTOs.IClientDTO;

@Entity
public class Client implements IClientDTO {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(length = 25, nullable = false, unique = true)
	private String name;
	
	@Column(length = 50, nullable = false, unique = true)
	private String email;
	
	@Column(length = 25, nullable = false, unique = false)
	private String password;
	
	@Column(nullable = false)
	private Boolean isAdmin = Boolean.FALSE;
	
	@Transient
	List<Order> orders = new ArrayList<>();

	protected Client() {}
	
	public Client(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public void update(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
	}

	@Override
	public String getEmail() {
		return email;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public List<Order> getOrders() {
		return orders;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public Boolean isAdmin() {
		return isAdmin;
	}

}
