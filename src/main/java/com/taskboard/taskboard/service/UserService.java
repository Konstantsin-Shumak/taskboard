package com.taskboard.taskboard.service;

import com.taskboard.taskboard.domain.User;
import com.taskboard.taskboard.dto.UserRequest;
import com.taskboard.taskboard.dto.UserResponse;
import com.taskboard.taskboard.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User createUser(UserRequest request) {
        User user = new User();
        user.setName(request.getName());
        user.setLogin(request.getLogin());
        user.setPasswordHash(passwordEncoder.encode(request.getPassword()));
        return userRepository.save(user);
    }

    public UserResponse toResponse(User user) {
        UserResponse response = new UserResponse();
        response.setId(user.getId());
        response.setName(user.getName());
        response.setLogin(user.getLogin());
        response.setCreatedAt(user.getCreatedAt());
        return response;
    }
}