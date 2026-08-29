package com.taskboard.taskboard.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserResponse {
    private Long id;
    private String name;
    private String login;
    private LocalDateTime createdAt;
}