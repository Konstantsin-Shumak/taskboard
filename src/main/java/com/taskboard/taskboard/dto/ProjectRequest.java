package com.taskboard.taskboard.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjectRequest {
    private String title;
    private Long ownerId;
}