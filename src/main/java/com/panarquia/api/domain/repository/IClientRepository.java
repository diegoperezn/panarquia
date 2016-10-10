package com.panarquia.api.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.panarquia.api.domain.Client;

@Repository
public interface IClientRepository extends JpaRepository<Client, Long>{

}
