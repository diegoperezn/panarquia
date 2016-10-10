package com.panarquia.api.domain.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.panarquia.api.domain.Client;
import com.panarquia.api.domain.DTOs.IClientDTO;
import com.panarquia.api.domain.repository.IClientRepository;
import com.panarquia.api.domain.service.IClientService;

@Service
public class ClientService implements IClientService {

	@Autowired
	private IClientRepository repository;
	
	@Override
	public IClientDTO getById(long id) {
		return this.repository.findOne(id);
	}

	@Override
	public List<? extends IClientDTO> getAll() {
		return this.repository.findAll();
	}

	@Override
	public IClientDTO create(IClientDTO dto) {
		Client client = new Client(dto.getName(), dto.getEmail(), dto.getPassword());
		
		return this.repository.save(client);
	}

	@Override
	public void update(IClientDTO dto) {
		Client client = this.repository.findOne(dto.getId());
		
		client.update(dto.getName(), dto.getEmail(), dto.getPassword());
		
		this.repository.save(client);
	}

}
