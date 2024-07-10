package com.bikkadit.blog.payloads;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class CategoryDto {

	private Integer categoryId;

	@NotBlank
	@Size(min = 5, message="min size of category title must be 4 ")
	private String categoryTitle;

	@NotBlank
	@Size(min = 10, message="min size of category description must be 10 ")
	private String categoryDescription;
}
