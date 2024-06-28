package com.bikkadit.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bikkadit.blog.payloads.UserDto;
import com.bikkadit.blog.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;

	// POST-create user
	@GetMapping("/") // it will execute when we call ("/api/users/")

	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) { // we create Dto because we will not
																				// expose directly from here

		UserDto createUserDto = this.userService.createUser(userDto);
		return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);

	}

	// PUT-Update user

	// DELETE-delete user

	// GET-get user

}
