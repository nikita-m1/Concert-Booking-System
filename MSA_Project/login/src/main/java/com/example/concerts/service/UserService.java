package com.example.concerts.service;

import com.example.concerts.dto.UserDTO;

import java.util.List;

public interface UserService {

    boolean getUserById(Long userId, String pass);

}
