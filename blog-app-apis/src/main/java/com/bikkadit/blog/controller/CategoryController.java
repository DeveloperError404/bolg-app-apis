package com.bikkadit.blog.controller;

//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bikkadit.blog.payloads.ApiResponse;
import com.bikkadit.blog.payloads.CategoryDto;
import com.bikkadit.blog.services.CategoryService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/categories")
@Slf4j
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	// CREATE
	@PostMapping("/")
	public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto) {
		log.info("Requesting to create a Category");
		CategoryDto category = this.categoryService.createCategory(categoryDto);
		log.info("Completed the request to create a Category");
		return new ResponseEntity<CategoryDto>(category, HttpStatus.CREATED);
	}

	// UPDATE
	@PutMapping("/{categoryId}")
	public ResponseEntity<CategoryDto> updateCategoryById(@Valid @RequestBody CategoryDto categoryDto,
			@PathVariable Integer categoryId) {
		log.info("Requesting to update a Category of categoryId: {}" + categoryId);
		CategoryDto updateCategoryById = this.categoryService.updateCategoryById(categoryDto, categoryId);
		log.info("Complete the request to update a Category of categoryId: {}" + categoryId);
		return new ResponseEntity<CategoryDto>(updateCategoryById, HttpStatus.OK);
	}

	// DELETEById
	@DeleteMapping("/{categoryId}")
	public ResponseEntity<ApiResponse> deleteCategoryById(@PathVariable Integer categoryId) {
		log.info("Requesting to delete a Category of categoryId: {}" + categoryId);
		this.categoryService.deleteCategory(categoryId);
		log.info("Complete the request to delete a Category of categoryId: {}" + categoryId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Categoty deleted successfully !!", true),
				HttpStatus.OK);
	}

	// GETById
	@GetMapping("/{categoryId}")
	public ResponseEntity<CategoryDto> getCategoryById(@PathVariable Integer categoryId) {
		log.info("Requesting to get a category of categoryId: {}" + categoryId);
		CategoryDto categoryById = this.categoryService.getCategory(categoryId);
		log.info("Complete the request to get a Category of categoryId: {}" + categoryId);
		return new ResponseEntity<CategoryDto>(categoryById, HttpStatus.OK);
	}

	// GETALL
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> getAllCategory() {
		log.info("Requesting to get all Categories");
		List<CategoryDto> allCategory = this.categoryService.getAllCategory();
		log.info("Complete the request to get all Categories");
		return new ResponseEntity<List<CategoryDto>>(allCategory, HttpStatus.OK);
	}

}