package com.panarquia.api.domain.service;

import java.util.List;

import com.panarquia.api.domain.DTOs.IClientDTO;

public interface IClientService {

	IClientDTO getById(long id);

	List<? extends IClientDTO> getAll();

	IClientDTO create(IClientDTO dto);

	void update(IClientDTO dto);

}
