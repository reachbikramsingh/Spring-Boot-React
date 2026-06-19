package com.bikram.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bikram.dto.UserDto;
@Service
public interface UserService {
	
	
	  public UserDto createUser(UserDto userDto);
	   public UserDto getUserById(Long userId);
	   List<UserDto> getAllUsers();
	    UserDto updateUser(UserDto userDto);
	    void deleteUser(Long userId);

}
