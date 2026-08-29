package com.taskboard.taskboard.controller;

import com.taskboard.taskboard.domain.Project;
import com.taskboard.taskboard.dto.ProjectRequest;
import com.taskboard.taskboard.dto.ProjectResponse;
import com.taskboard.taskboard.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping
    public List<ProjectResponse> getAllProjects() {
        return projectService.getAllProjectResponses();
    }

    @PostMapping
    public ProjectResponse createProject(@RequestBody ProjectRequest request) {
        Project savedProject = projectService.createProject(request);
        return projectService.toResponse(savedProject);
    }
}