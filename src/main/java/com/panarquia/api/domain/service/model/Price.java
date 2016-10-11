package com.panarquia.api.domain.service.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.panarquia.api.controller.DTOs.IPriceViewDTO;

@Entity
public class Price implements IPriceViewDTO {

	@Id
	@GeneratedValue
	private Long id;
	@Column(name = "from_date")
	private Date from;
	@Column(name = "to_date")
	private Date to;
	private Double price;

	protected Price() {
	}

	public Price(Double price) {
		this.from = new Date();
		this.price = price;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.panarquia.api.domain.IViewPriceDTO#getId()
	 */
	@Override
	public Long getId() {
		return id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.panarquia.api.domain.IViewPriceDTO#getFrom()
	 */
	@Override
	public Date getFrom() {
		return from;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.panarquia.api.domain.IViewPriceDTO#getTo()
	 */
	@Override
	public Date getTo() {
		return to;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.panarquia.api.domain.IViewPriceDTO#getPrice()
	 */
	@Override
	public Double getPrice() {
		return price;
	}

	public void setTo(Date to) {
		this.to = to;
	}

}
