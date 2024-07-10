package com.bikkadit.blog.payloads;

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
	private String categoryTitle;
	private String categoryDescription;
}
