package com.panarquia.backend.domain;

import java.util.List;

public class Product {

	private long id;
	private String name;
	private String briefDescription;
	private String description;
	private String urlPhoto;
	private List<Price> prices;
	private Category category;

	@Deprecated
	public Product(long id, String name, String briefDescription, String description, String urlPhoto,
			List<Price> prices, Category category) {
		this.id = id;
		this.name = name;
		this.briefDescription = briefDescription;
		this.description = description;
		this.urlPhoto = urlPhoto;
		this.prices = prices;
		this.category = category;
	}

	public Product(String name, String briefDescription, String description, String urlPhoto,
			List<Price> prices, Category category) {
		this.name = name;
		this.briefDescription = briefDescription;
		this.description = description;
		this.urlPhoto = urlPhoto;
		this.prices = prices;
		this.category = category;
	}
	
	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getBriefDescription() {
		return briefDescription;
	}

	public String getDescription() {
		return description;
	}

	public String getUrlPhoto() {
		return urlPhoto;
	}

	public List<Price> getPrices() {
		return prices;
	}

	public Category getCategory() {
		return category;
	}
	
}