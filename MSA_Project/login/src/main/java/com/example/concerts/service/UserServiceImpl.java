package com.example.concerts.service;

import com.example.concerts.dto.UserDTO;
import com.example.concerts.entity.User;
import com.example.concerts.mapper.UserMapper;
import com.example.concerts.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public boolean getUserById(Long userId, String pass) {
        Optional<User> optionalUser = userRepository.findById(userId);
        User user = optionalUser.get();
        String p = user.getPwd();
        if (Objects.equals(p, pass)){
            return true;
        }
        return false;
    }
}