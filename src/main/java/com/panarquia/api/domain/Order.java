package com.panarquia.api.domain;

import java.util.Date;
import java.util.List;

import com.panarquia.api.domain.DTOs.IClientDTO;

public class Order {

	private long id;
	private IClientDTO client;
	private Date created;
	private Date delivered;
	private List<OrderState> historicStates;

	public Order(long id, IClientDTO client, Date created, Date delivered, List<OrderState> historicStates) {
		super();
		this.id = id;
		this.client = client;
		this.created = created;
		this.delivered = delivered;
		this.historicStates = historicStates;
	}

	public long getId() {
		return id;
	}

	public IClientDTO getClient() {
		return client;
	}

	public Date getCreated() {
		return created;
	}

	public Date getDelivered() {
		return delivered;
	}

	public List<OrderState> getHistoricStates() {
		return historicStates;
	}

}
