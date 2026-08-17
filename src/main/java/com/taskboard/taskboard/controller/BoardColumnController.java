package com.taskboard.taskboard.controller;

import com.taskboard.taskboard.domain.BoardColumn;
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
    public List<BoardColumn> getAllBoardColumns() {
        return boardColumnService.getAllBoardColumns();
    }

    @PostMapping
    public BoardColumn createBoardColumn(@RequestBody BoardColumn boardColumn) {
        return boardColumnService.createBoardColumn(boardColumn);
    }
}