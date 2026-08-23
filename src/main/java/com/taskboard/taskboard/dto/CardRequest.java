package com.taskboard.taskboard.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CardRequest {
    private String title;
    private String description;
    private Long columnId;
}
