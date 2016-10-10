package com.panarquia.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.panarquia.api.controller.DTOs.impl.CategoryDTO;
import com.panarquia.api.domain.DTOs.ICategoryDTO;
import com.panarquia.api.domain.service.ICategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private ICategoryService categoryService;

	@RequestMapping(method = RequestMethod.GET)
	public List<? extends ICategoryDTO> getcategorys() {
		return categoryService.getAll();
	}

	@RequestMapping(value = "/{categoryId}", method = RequestMethod.GET)
	public ICategoryDTO getcategoryById(@PathVariable("categoryId") Long categoryId) {
		return categoryService.getById(categoryId);
	}

	@RequestMapping(value = "/create", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ICategoryDTO createcategory(@RequestBody CategoryDTO categoryDTO) {
		return categoryService.create(categoryDTO);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public void updatecategory(@RequestBody CategoryDTO categoryDTO) {
		categoryService.update(categoryDTO);
	}

}
