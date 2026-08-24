package com.taskboard.taskboard.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardColumnRequest {
    private String title;
    private Long boardId;
}
