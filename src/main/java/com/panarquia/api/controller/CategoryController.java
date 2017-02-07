package com.panarquia.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.Factory;
import org.apache.commons.collections.list.LazyList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.panarquia.api.controller.DTOs.impl.CategoryDTO;
import com.panarquia.api.domain.service.ICategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private ICategoryService categoryService;

	@RequestMapping(method = RequestMethod.GET)
	public List<CategoryDTO> getcategories() {
		Factory factory = new Factory() {

			@Override
			public Object create() {
				return new CategoryDTO();
			}
		};

		List<CategoryDTO> result = LazyList.decorate(new ArrayList<CategoryDTO>(), factory);

		categoryService.getAll(result);

		return result;
	}

	@RequestMapping(value = "/{categoryId}", method = RequestMethod.GET)
	public CategoryDTO getcategoryById(@PathVariable("categoryId") Long categoryId) {
		CategoryDTO category = new CategoryDTO();
		category.setId(categoryId);

		categoryService.getById(category);

		return category;
	}

	@RequestMapping(value = "/create", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public Long createcategory(@RequestBody CategoryDTO categoryDTO) {
		return categoryService.create(categoryDTO);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public void updatecategory(@RequestBody CategoryDTO categoryDTO) {
		categoryService.update(categoryDTO);
	}

}
