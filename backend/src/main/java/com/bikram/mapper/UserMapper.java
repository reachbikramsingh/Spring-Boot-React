package com.bikram.mapper;

import com.bikram.dto.UserDto;
import com.bikram.entity.User;


public class UserMapper {
	
    public static UserDto mapToUserDto(User user){
        UserDto userDto=new UserDto(user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail()
        );
        return userDto;
    }

    //convert UserDto int User JPA entity.

    public static User mapToUser(UserDto userDto){
        User user=new User(

                userDto.getId(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail()
        );
        return user;
    }
}