package com.panarquia.api.domain;

import java.util.Date;

public class Price {

	private long id;
	private Date from;
	private Date to;
	private Double price;

	public Price(long id, Date from, Date to, Double price) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.price = price;
	}

	public long getId() {
		return id;
	}

	public Date getFrom() {
		return from;
	}

	public Date getTo() {
		return to;
	}

	public Double getPrice() {
		return price;
	}

}
