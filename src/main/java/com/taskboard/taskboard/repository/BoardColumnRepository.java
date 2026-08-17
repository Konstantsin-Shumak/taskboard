package com.taskboard.taskboard.repository;

import com.taskboard.taskboard.domain.BoardColumn;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardColumnRepository extends JpaRepository<BoardColumn, Long> {
    long countByBoardId(Long boardId);
}