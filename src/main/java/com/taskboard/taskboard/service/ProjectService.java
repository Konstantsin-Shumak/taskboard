package com.taskboard.taskboard.service;

import com.taskboard.taskboard.domain.Project;
import com.taskboard.taskboard.domain.User;
import com.taskboard.taskboard.dto.ProjectRequest;
import com.taskboard.taskboard.dto.ProjectResponse;
import com.taskboard.taskboard.repository.ProjectRepository;
import com.taskboard.taskboard.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;

    public Project createProject(ProjectRequest request) {
        User owner = userRepository.findById(request.getOwnerId())
                .orElseThrow();

        Project project = new Project();
        project.setTitle(request.getTitle());
        project.setOwner(owner);

        return projectRepository.save(project);
    }

    public ProjectResponse toResponse(Project project) {
        ProjectResponse response = new ProjectResponse();
        response.setId(project.getId());
        response.setTitle(project.getTitle());
        response.setOwnerId(project.getOwner().getId());
        response.setCreatedAt(project.getCreatedAt());
        return response;
    }

    public List<ProjectResponse> getAllProjectResponses() {
        return projectRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }
}