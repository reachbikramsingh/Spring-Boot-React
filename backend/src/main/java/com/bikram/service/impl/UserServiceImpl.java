package com.bikram.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.bikram.dto.UserDto;
import com.bikram.entity.User;
import com.bikram.mapper.UserMapper;
import com.bikram.repository.UserRepository;
import com.bikram.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDto createUser(UserDto userDto) {
		User user = UserMapper.mapToUser(userDto);
		User savedUser = userRepository.save(user);
		UserDto userdto = UserMapper.mapToUserDto(savedUser);
		return userdto;
	}

	@Override
	public UserDto getUserById(Long userId) {
		Optional<User> optionalUser = userRepository.findById(userId);
		User user = optionalUser.get();
		UserDto userDto = UserMapper.mapToUserDto(user);
		return userDto;
	}


	 @Override
	    public List<UserDto> getAllUsers() {
	        List<User> users= userRepository.findAll();
	        return users.stream().map(UserMapper::mapToUserDto).collect(Collectors.toList());
	    }

	 @Override
	 public void deleteUser(Long userId) {
		userRepository.deleteById(userId);
		
	 }

	 @Override
	 public UserDto updateUser(UserDto userDto) {	 
	     Long id=userDto.getId();
	     User existingUser=userRepository.findById(userDto.getId()).get();  
	     existingUser.setFirstName(userDto.getFirstName());
	     existingUser.setLastName(userDto.getLastName());
	     existingUser.setEmail(userDto.getEmail());
	    User updatedUser= userRepository.save(existingUser);
		return UserMapper.mapToUserDto(updatedUser);
	 }

}
