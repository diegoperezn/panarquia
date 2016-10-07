package com.panarquia.api.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.panarquia.api.domain.Category;

public interface ICategoryRepository extends JpaRepository<Category, Long>{

}
