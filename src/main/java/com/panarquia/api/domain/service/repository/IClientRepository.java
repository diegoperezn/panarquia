package com.panarquia.api.domain.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.panarquia.api.domain.service.model.Client;

@Repository
public interface IClientRepository extends JpaRepository<Client, Long>{

}
