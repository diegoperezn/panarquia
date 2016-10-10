package com.panarquia.api.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.panarquia.api.domain.Product;

public interface IProductRepository extends JpaRepository<Product, Long>{

	List<Product> getByCategoryId(Long categoryId);

}