package com.bikram.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bikram.dto.UserDto;
import com.bikram.service.UserService;

@RestController
//@RequestMapping
@CrossOrigin(origins = "*")
@RequestMapping("api/users")
public class UserController {
	
	
	 @GetMapping("/hello")
	    public String sayHello() {
	        return "Hello Bikram, your Spring Boot app is running!";
	    }
  
	    private final UserService userService;

	    // Spring injects automatically
	    public UserController(UserService userService) {
	        this.userService = userService;
	    }
	    
	    //build create User rest API
	    @PostMapping
	    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
	    	//need to call service methods
	        UserDto savedUser=userService.createUser(userDto);
	        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
	    }
	    
	    //Retrieving user information user @getMapping
	    @GetMapping("{id}")
	    public ResponseEntity<UserDto> getUser(@PathVariable("id") Long userId){
	    	//need to call service methods
	    	UserDto userDto=userService.getUserById(userId);	
	    return new ResponseEntity<>(userDto,HttpStatus.OK);
	    	
	    }
	    
	    
	    @GetMapping
	    public ResponseEntity<List<UserDto>> getAllUsers(){
	    	//need to call service methods
	    	List<UserDto> users=userService.getAllUsers();	    	
			return new ResponseEntity<>(users,HttpStatus.OK);
	    	
	    }
	    
	    @DeleteMapping("{id}")
	    public ResponseEntity<String> deleteUserbyId(@PathVariable("id")Long userId){
	    	//need to call service methods
	    	userService.deleteUser(userId);    	
	    	return new ResponseEntity<String>("Record deleted successfully",HttpStatus.OK);
	    }
	    
	   @PutMapping("{id}") 
	 public ResponseEntity<UserDto> updateUserRecord(@PathVariable("id")Long userId, @RequestBody UserDto userDto){
		 userDto.setId(userId);
		 UserDto updatedUserDto=userService.updateUser(userDto);
		 return new ResponseEntity<>(updatedUserDto,HttpStatus.OK);
	    	
	    }
	
	    
	    

}
