package com.taskboard.taskboard.controller;

import com.taskboard.taskboard.domain.BoardColumn;
import com.taskboard.taskboard.dto.BoardColumnRequest;
import com.taskboard.taskboard.dto.BoardColumnResponse;
import com.taskboard.taskboard.service.BoardColumnService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/board-columns")
@RequiredArgsConstructor
public class BoardColumnController {

    private final BoardColumnService boardColumnService;

    @GetMapping
    public List<BoardColumnResponse> getAllBoardColumns() {
        return boardColumnService.getAllBoardColumnResponses();
    }

    @PostMapping
    public BoardColumnResponse createBoardColumn(@RequestBody BoardColumnRequest boardColumnRequest) {
        BoardColumn savedBoardColumn = boardColumnService.createBoardColumn(boardColumnRequest);
        return boardColumnService.toResponse(savedBoardColumn);
    }
}