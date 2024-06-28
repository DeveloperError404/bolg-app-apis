package com.bikkadit.blog.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bikkadit.blog.entities.User;
import com.bikkadit.blog.exceptions.ResourceNotFoundException;
import com.bikkadit.blog.payloads.UserDto;
import com.bikkadit.blog.repositories.UserRepo;
import com.bikkadit.blog.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	// we need repository to createUser,UpdateUser,DeleteUser
	@Autowired
	private UserRepo userRepo;

	@Autowired
	private ModelMapper modelMapper;

	public UserDto createUser(UserDto userDto) {
		User user = this.dtoToUser(userDto);
		User savedUser = this.userRepo.save(user);

		return this.userToDto(savedUser);

	}

	public UserDto updatUser(UserDto userDto, Integer userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", userId)); // here we get the error bcz we
																							// not created the class so
																							// go in exceptions package
																							// and create class for that

		user.setName(userDto.getName()); // first we get then here we set
		user.setEmail(userDto.getEmail());
		user.setPassword(user.getPassword());
		user.setAbout(userDto.getAbout());
		User updatedUser = this.userRepo.save(user); // then convert into DTO
		UserDto userDto1 = this.userToDto(updatedUser);

		return userDto1;
	}

	public UserDto getUserById(Integer userId) {

		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId)); // or else throw means suppose
																							// we didnt get o/p then we
																							// need to throw that
																							// exceotion so creste user
																							// define exception

		return this.userToDto(user);

	}

	public List<UserDto> getAllUsers() {
		List<User> users = this.userRepo.findAll();

		// here we need to send list of user to userDto
		// so we need to convert user to Dto

		List<UserDto> userDtos = users.stream().map(user -> this.userToDto(user)).collect(Collectors.toList());

		return userDtos;
	}

	public void deleteUser(Integer userId) {
		// First get the user

		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));

		// for delete user
		this.userRepo.delete(user);
	}

	// model mapper to convert dto to entity

	private User dtoToUser(UserDto userDto) {
		User user = this.modelMapper.map(userDto, User.class);

//		user.setId(userDto.getId());
//		user.setName(userDto.getName());
//		user.setEmail(userDto.getEmail());
//		user.setPassword(userDto.getPassword());
//		user.setAbout(userDto.getAbout());
		return user;

	}

	// model mapper to convert entity to dto

	public UserDto userToDto(User user) {

		UserDto userDto = this.modelMapper.map(user, UserDto.class);

//		userDto.setId(user.getId());
//		userDto.setName(user.getName());
//		userDto.setEmail(user.getEmail());
//		userDto.setPassword(user.getPassword());
//		userDto.setAbout(user.getAbout());
		return userDto;

	}
}
