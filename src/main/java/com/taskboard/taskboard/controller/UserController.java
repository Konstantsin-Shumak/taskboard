package com.taskboard.taskboard.controller;

import com.taskboard.taskboard.domain.User;
import com.taskboard.taskboard.dto.UserRequest;
import com.taskboard.taskboard.dto.UserResponse;
import com.taskboard.taskboard.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public UserResponse createUser(@RequestBody UserRequest request) {
        User savedUser = userService.createUser(request);
        return userService.toResponse(savedUser);
    }
}