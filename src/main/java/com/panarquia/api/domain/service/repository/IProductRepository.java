package com.panarquia.api.domain.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.panarquia.api.domain.service.model.Product;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long>{

	List<Product> getByCategoryId(Long categoryId);

}