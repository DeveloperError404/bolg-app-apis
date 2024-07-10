package com.bikkadit.blog.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class UserDto {          //user for data transfer 
	private int id;
	
	
	
	@NotEmpty
	@Size(min =4, message = "Username must be minimum of four character")
	private String name;
	
	@Email(message = "your email address is not valid !!")
	private String email;
	
	@NotEmpty
	@Size(min = 3, max = 10, message = "Password must be minimum 3 character and maximum of 10 char!!")
	
	private String password;
	
	@NotEmpty
	private String about;
	

}
