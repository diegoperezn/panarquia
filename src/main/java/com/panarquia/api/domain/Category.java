package com.panarquia.api.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.panarquia.api.domain.DTOs.ICategoryDTO;

@Entity
public class Category implements ICategoryDTO {

	@Id
	@GeneratedValue
	private Long id;

	private String name;
	private String description;

	protected Category() {
	}

	public Category(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public Category(Long categoryId) {
		this.id = categoryId;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

}
