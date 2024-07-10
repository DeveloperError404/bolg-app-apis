package com.bikkadit.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/user")
@Validated
@Slf4j
public class UserController {

	@Autowired
	private UserService userService;

	// POST-create user
	@PostMapping("/") // it will execute when we call ("/api/users/") in postman

	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) { // we create Dto because we will
																						// not
		// expose directly from here
		log.info("Requesting to create a User");
		UserDto createUserDto = this.userService.createUser(userDto);
		log.info("Completed the request to create a User");
		return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);

	}

	// PUT-Update user
	@PutMapping("/{userId}") // {userId} this is path uri variable
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto,
			@PathVariable("userId") Integer userId) {
		log.info("Requesting to update a User of userId {}" + userId);
		UserDto updatedUser = this.userService.updatUser(userDto, userId);
		log.info("Completed the request to update a User of userId {}" + userDto);
		return ResponseEntity.ok(updatedUser);

	}

	// DELETE-delete user
	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") Integer userId) {
		log.info("Requesting to delete a User of userId {}" + userId);
		this.userService.deleteUser(userId);
		log.info("Completed the request to delete a User of userId {}" + userId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User Deleted Successfully", true), HttpStatus.OK);
	}

	// GET-get all user
	@GetMapping("/")
	ResponseEntity<List<UserDto>> getAllUsers() {
		log.info("Requesting to retrive all Users");
		log.info("Completed the request to get all Users");
		return ResponseEntity.ok(this.userService.getAllUsers());

	}

	// GET-get single user
	@GetMapping("/{userId}")
	ResponseEntity<UserDto> getSingleUsers(@PathVariable Integer userId) {
		log.info("Requesting to retrive a User of userId {}" + userId);
		log.info("Completed the request to get a User of userId {}" + userId);
		return ResponseEntity.ok(this.userService.getUserById(userId));

	}

}
