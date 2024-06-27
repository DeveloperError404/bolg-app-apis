package com.bikkadit.blog.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bikkadit.blog.entities.User;
import com.bikkadit.blog.payloads.UserDto;
import com.bikkadit.blog.repositories.UserRepo;
import com.bikkadit.blog.services.UserService;

public class UserServiceImpl implements UserService {

	// we need repository to createUser,UpdateUser,DeleteUser
	@Autowired
	private UserRepo userRepo;

	public UserDto createUser(UserDto user) {
		User user1 = this.dtoToUser(userToDto(null));
		User savedUser = this.userRepo.save(user1);

		return this.userToDto(savedUser);

	}

	public UserDto updatUser(UserDto user, Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	public UserDto getUserById(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<UserDto> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteUser(Integer userId) {
		// TODO Auto-generated method stub

	}

	private User dtoToUser(UserDto userDto) {
		User user = new User();
		user.setId(userDto.getId());
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		return user;

	}

	public UserDto userToDto(User user) {
		UserDto userDto = new UserDto();
		userDto.setId(user.getId());
		userDto.setName(user.getName());
		userDto.setEmail(user.getEmail());
		userDto.setPassword(user.getPassword());
		userDto.setAbout(user.getAbout());
		return userDto;

	}
}
