package com.taskboard.taskboard.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class BoardColumnResponse {
    private Long id;
    private String title;
    private Integer position;
    private LocalDateTime createdAt;
    private Long boardId;
}
