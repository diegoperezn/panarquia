package com.panarquia.api.domain.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.panarquia.api.domain.service.model.Category;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Long>{

}
