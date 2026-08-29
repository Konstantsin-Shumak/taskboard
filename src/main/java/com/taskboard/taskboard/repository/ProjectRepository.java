package com.taskboard.taskboard.repository;

import com.taskboard.taskboard.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}