package com.taskboard.taskboard.controller;

import com.taskboard.taskboard.domain.Board;
import com.taskboard.taskboard.dto.BoardColumnResponse;
import com.taskboard.taskboard.service.BoardColumnService;
import com.taskboard.taskboard.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/boards")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;
    private final BoardColumnService boardColumnService;

    @GetMapping
    public List<Board> getAllBoards() {
        return boardService.getAllBoards();
    }

    @PostMapping
    public Board createBoard(@RequestBody Board board) {
        return boardService.createBoard(board);
    }

    @GetMapping("/{boardId}/columns")
    public List<BoardColumnResponse> getColumnsByBoard(@PathVariable Long boardId) {
        return boardColumnService.getBoardColumnResponsesByBoardId(boardId);
    }
}