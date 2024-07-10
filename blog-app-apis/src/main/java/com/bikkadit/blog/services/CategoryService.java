package com.bikkadit.blog.services;

import java.util.List;

import com.bikkadit.blog.payloads.CategoryDto;

public interface CategoryService {

	//CREATE
	public CategoryDto createCategory(CategoryDto categoryDto);
	
	
	//UPDATE
	public CategoryDto updateCategoryById(CategoryDto categoryDto,Integer categoryId);
	
	//DELETE
	
	public void  deleteCategory(Integer  categoryId);
	
	//GET
	
	public CategoryDto getCategory(Integer categoryId);
	
	//GET ALL
	 
	List<CategoryDto> getAllCategory();
	
}
