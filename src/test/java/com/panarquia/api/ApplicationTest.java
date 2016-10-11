package com.panarquia.api;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.panarquia.api.domain.service.repository.ICategoryRepository;

public class ApplicationTest {
	
	@Autowired
	private ICategoryRepository categoryRepository;

    @Test
    public void contextLoads() throws Exception {
    	categoryRepository.count();
    }
	
}
