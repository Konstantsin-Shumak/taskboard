package com.taskboard.taskboard.repository;

import com.taskboard.taskboard.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}