package com.bikkadit.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bikkadit.blog.payloads.UserDto;
import com.bikkadit.blog.services.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserService userService;

	// POST-create user
	@PostMapping("/user") // it will execute when we call ("/api/users/") in postman

	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) { // we create Dto because we will not
																				// expose directly from here

		UserDto createUserDto = this.userService.createUser(userDto);
		return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);

	}

	// PUT-Update user
	@PutMapping("/user/{userId}") // {userId} this is path uri variable
	public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto, @PathVariable("userId") Integer uid) {
		UserDto updatedUser = this.userService.updatUser(userDto, uid);
		return ResponseEntity.ok(updatedUser);

	}

	// DELETE-delete user

	// GET-get user

}
