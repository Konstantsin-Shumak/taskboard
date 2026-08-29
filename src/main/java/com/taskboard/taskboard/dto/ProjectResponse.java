package com.taskboard.taskboard.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ProjectResponse {
    private Long id;
    private String title;
    private Long ownerId;
    private LocalDateTime createdAt;
}