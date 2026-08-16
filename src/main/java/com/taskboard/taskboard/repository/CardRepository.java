package com.taskboard.taskboard.repository;

import com.taskboard.taskboard.domain.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Long> {
}