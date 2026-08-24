package com.taskboard.taskboard.service;

import com.taskboard.taskboard.domain.Board;
import com.taskboard.taskboard.domain.BoardColumn;
import com.taskboard.taskboard.dto.BoardColumnRequest;
import com.taskboard.taskboard.dto.BoardColumnResponse;
import com.taskboard.taskboard.repository.BoardColumnRepository;
import com.taskboard.taskboard.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardColumnService {

    private final BoardColumnRepository boardColumnsRepository;
    private final BoardRepository boardRepository;

    public List<BoardColumnResponse> getAllBoardColumnResponses() {

        return boardColumnsRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public List<BoardColumnResponse> getBoardColumnResponsesByBoardId(Long boardId){
        return boardColumnsRepository.findByBoard_Id(boardId)
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public BoardColumn createBoardColumn(BoardColumnRequest request) {
        Board board = boardRepository.findById(request.getBoardId())
                .orElseThrow();

        BoardColumn boardColumn = new BoardColumn();
        boardColumn.setTitle(request.getTitle());
        boardColumn.setBoard(board);

        long existingCount = boardColumnsRepository.countByBoard_Id(boardColumn.getBoard().getId());
        boardColumn.setPosition((int) existingCount + 1);
        return boardColumnsRepository.save(boardColumn);
    }

    public BoardColumnResponse toResponse(BoardColumn boardColumn) {
        BoardColumnResponse response = new BoardColumnResponse();
        response.setId(boardColumn.getId());
        response.setTitle(boardColumn.getTitle());
        response.setPosition(boardColumn.getPosition());
        response.setCreatedAt(boardColumn.getCreatedAt());
        response.setBoardId(boardColumn.getBoard().getId());
        return response;
    }
}
