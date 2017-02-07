package com.panarquia.api.domain.service.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Category {

	@Id
	@GeneratedValue
	private Long id;

	@Column(length = 25, nullable = false, unique = true)
	private String name;
	
	@Column(length = 250, nullable = false, unique = true)
	private String description;

	protected Category() {
	}

	public Category(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public void update(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public Category(Long categoryId) {
		this.id = categoryId;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

}
