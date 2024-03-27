package com.example.concerts.mapper;

import com.example.concerts.dto.UserDTO;
import com.example.concerts.entity.User;

public class UserMapper {

    // Convert User JPA Entity into UserDto
    public static UserDTO mapToUserDto(User user){
        UserDTO userDto = new UserDTO(
                user.getUid(),
                user.getPwd()
        );
        return userDto;
    }
    // Convert UserDto into User JPA Entity
    public static User mapToUser(UserDTO userDto){
        User user = new User(
                userDto.getUid(),
                userDto.getPwd()
        );
        return user;
    }
}