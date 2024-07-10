package com.bikkadit.blog.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bikkadit.blog.entities.Category;
import com.bikkadit.blog.exceptions.ResourceNotFoundException;
import com.bikkadit.blog.payloads.CategoryDto;
import com.bikkadit.blog.repositories.CategoryRepo;
import com.bikkadit.blog.services.CategoryService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		log.info("Initiating the service Dao Call to create a Category");
		Category category = this.modelMapper.map(categoryDto, Category.class);
		Category saved = this.categoryRepo.save(category);
		log.info("Completed the service layer to create a Category");
		return this.modelMapper.map(saved, CategoryDto.class);	
	}

	@Override
	public CategoryDto updateCategoryById(CategoryDto categoryDto, Integer categoryId) {
		log.info("Initiating the service Dao call to update a Category of categoryId: {}", categoryId);
		Category category = this.categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", categoryId));
		category.setCategoryTitle(categoryDto.getCategoryTitle());
		category.setCategoryDescription(categoryDto.getCategoryDescription());
		Category updatedCategory = this.categoryRepo.save(category);
		log.info("Completed the service Dao call to update a Category of categoryId: {}", categoryId);
		return this.modelMapper.map(updatedCategory, CategoryDto.class);
	}

	@Override
	public void deleteCategory(Integer categoryId) {
		log.info("Initiating the service Dao call to delete a Category of categoryId: {}", categoryId);
		Category category = this.categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", categoryId));
		log.info("Completed the service Dao call to delete a Category of categoryId: {}", categoryId);
		this.categoryRepo.delete(category);


	}

	@Override
	public CategoryDto getCategory(Integer categoryId) {
		log.info("Initiating the service Dao call to get a Category of categoryId: {}", categoryId);
		Category category = this.categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", categoryId));
		log.info("Completed the service Dao call to get a Category of categoryId: {}", categoryId);
		return this.modelMapper.map(category, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getAllCategory() {
		log.info("Initiating the service Dao call to get all Categories");
		List<Category> catagories = this.categoryRepo.findAll();
		// return (List<CategoryDto>) this.modelMapper.map(findAll, CategoryDto.class);
		List<CategoryDto> catDtos = catagories.stream().map((cat) -> this.modelMapper.map(cat, CategoryDto.class))
				.collect(Collectors.toList());
		log.info("Completed the service Dao call to get a Categories");
		return catDtos;

	}

	

}
