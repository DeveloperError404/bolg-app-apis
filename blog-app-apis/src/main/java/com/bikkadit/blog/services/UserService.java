package com.bikkadit.blog.services;

import java.util.List;

import com.bikkadit.blog.payloads.UserDto;

public interface UserService {
	
   UserDto createUser(UserDto user);                      // we create these method for create,update,delet,and for get user
   
   UserDto 	updatUser(UserDto user,Integer userId);
   
   UserDto getUserById(Integer  userId);
   
   List<UserDto> getAllUsers();
   
   void deleteUser(Integer userId);
   

}
