package com.panarquia.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.panarquia.api.domain.DTOs.IClientDTO;
import com.panarquia.api.domain.service.IClientService;

@RestController
@RequestMapping("/client")
public class ClientController {

	@Autowired
	private IClientService clientService;

	@RequestMapping(method = RequestMethod.GET)
	public List<? extends IClientDTO> getClients() {
		return clientService.getAll();
	}

	@RequestMapping(value = "/{clientId}", method = RequestMethod.GET)
	public IClientDTO getClientById(@PathVariable("clientId") Long clientId) {
		return clientService.getById(clientId);
	}

	@RequestMapping(value = "/create", method = RequestMethod.PUT)
	public IClientDTO createClient(@RequestBody IClientDTO clientDTO) {
		return clientService.create(clientDTO);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public void updateClient(@RequestBody IClientDTO clientDTO) {
		clientService.update(clientDTO);
	}

}
