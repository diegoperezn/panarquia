package com.panarquia.api.domain.service.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import com.panarquia.api.domain.DTOs.IProductDTO;

@Entity
public class Product implements IProductDTO {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(length = 25, nullable = false, unique = true)
	private String name;
	
	@Column(length = 75, nullable = false, unique = true)
	private String briefDescription;
	
	@Column(length = 250, nullable = false, unique = true)
	private String description;
	
	@ManyToOne
	private Category category;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "product_id")
	@OrderBy("from DESC")
	private List<Price> prices = new ArrayList<>();
	
	protected Product() {}
	
	public Product(String name, String briefDescription, String description,
			Price price, Category category) {
		this.name = name;
		this.briefDescription = briefDescription;
		this.description = description;
		this.category = category;

		this.addPrice(price);
	}
	

	public void update(String name, String briefDescription, String description,
			Price price, Category category) {
		this.name = name;
		this.briefDescription = briefDescription;
		this.description = description;
		this.category = category;

		if (price != null) {
			this.addPrice(price);
		}
	}	
	
	/* (non-Javadoc)
	 * @see com.panarquia.api.domain.IProductDTO#getId()
	 */
	@Override
	public Long getId() {
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

	private void addPrice(Price price) {
		if (!this.prices.isEmpty()) {
			this.getPrice().setTo(price.getFrom());
		}
		
		this.prices.add(price);
	}
	
	@Override
	public Price getPrice() {
		for (Price price : prices) {
			if (price.getTo() == null) {
				return price;
			}
		}
		
		return null;
	}
	
}







