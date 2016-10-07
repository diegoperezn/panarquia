package com.panarquia.api.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import com.panarquia.api.domain.DTOs.IProductViewDTO;
import com.panarquia.api.utils.HistoricalArrayList;

@Entity
public class Product implements IProductViewDTO {

	@Id
	@GeneratedValue
	private long id;
	
	private String name;
	private String briefDescription;
	private String description;
	
	@ManyToOne
	private Category category;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "product_id")
	@OrderBy("from DESC")
	private HistoricalArrayList<Price> prices = new HistoricalArrayList<>();
	
	protected Product() {}
	
	public Product(String name, String briefDescription, String description,
			Price price, Category category) {
		this.name = name;
		this.briefDescription = briefDescription;
		this.description = description;
		this.category = category;

		this.prices.add(price);
	}
	

	public void update(String name, String briefDescription, String description,
			Price price, Category category) {
		this.name = name;
		this.briefDescription = briefDescription;
		this.description = description;
		this.category = category;

		this.prices.add(price);
	}	
	
	/* (non-Javadoc)
	 * @see com.panarquia.api.domain.IProductDTO#getId()
	 */
	@Override
	public long getId() {
		return id;
	}

	/* (non-Javadoc)
	 * @see com.panarquia.api.domain.IProductDTO#getName()
	 */
	@Override
	public String getName() {
		return name;
	}

	/* (non-Javadoc)
	 * @see com.panarquia.api.domain.IProductDTO#getBriefDescription()
	 */
	@Override
	public String getBriefDescription() {
		return briefDescription;
	}

	/* (non-Javadoc)
	 * @see com.panarquia.api.domain.IProductDTO#getDescription()
	 */
	@Override
	public String getDescription() {
		return description;
	}

	public List<Price> getPrices() {
		return prices;
	}

	/* (non-Javadoc)
	 * @see com.panarquia.api.domain.IProductDTO#getCategory()
	 */
	@Override
	public Category getCategory() {
		return category;
	}

	@Override
	public Price getPrice() {
		return (Price) this.prices.getCurrentElement();
	}
	
}







