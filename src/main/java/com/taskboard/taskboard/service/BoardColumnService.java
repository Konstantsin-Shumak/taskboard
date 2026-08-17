package com.taskboard.taskboard.service;

import com.taskboard.taskboard.domain.BoardColumn;
import com.taskboard.taskboard.repository.BoardColumnRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardColumnService {

    private final BoardColumnRepository boardColumnsRepository;

    public List<BoardColumn> getAllBoardColumns() {
        return boardColumnsRepository.findAll();
    }

    public BoardColumn createBoardColumn(BoardColumn boardColumn) {
        long existingCount = boardColumnsRepository.countByBoardId(boardColumn.getBoardId());
        boardColumn.setPosition((int) existingCount + 1);
        return boardColumnsRepository.save(boardColumn);
    }
}
