package com.taskboard.taskboard.repository;

import com.taskboard.taskboard.domain.BoardColumn;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardColumnRepository extends JpaRepository<BoardColumn, Long> {
    long countByBoard_Id(Long boardId);

    List<BoardColumn> findByBoard_Id(Long boardId);
}