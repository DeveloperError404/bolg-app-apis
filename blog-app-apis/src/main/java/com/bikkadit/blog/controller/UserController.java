package com.bikkadit.blog.controller;

import java.util.List;
import java.util.Map;

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
	@DeleteMapping("/user/{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") Integer uid) {
		this.deleteUser(uid);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User Deleted Successfully", true), HttpStatus.OK);
	}

	// GET-get all user
	@GetMapping("/user")
	ResponseEntity<List<UserDto>> getAllUsers() {
		return ResponseEntity.ok(this.userService.getAllUsers());

	}

	// GET-get single user
	@GetMapping("/user{userId}")
	ResponseEntity<UserDto> getSingleUsers(@PathVariable Integer userId) {
		return ResponseEntity.ok(this.userService.getUserById(userId));

	}

}
