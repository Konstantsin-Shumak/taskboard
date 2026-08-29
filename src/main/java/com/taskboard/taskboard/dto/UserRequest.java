package com.taskboard.taskboard.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {
    private String name;
    private String login;
    private String password;
}