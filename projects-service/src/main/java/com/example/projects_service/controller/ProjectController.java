package com.example.projects_service.controller;

import com.example.projects_service.model.Project;
import com.example.projects_service.repository.ProjectRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectRepository repository;

    public ProjectController(ProjectRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Project> getAllProjects() {
        return repository.findAll();
    }

    @PostMapping
    public Project createProject(@RequestBody Project project) {
        return repository.save(project);
    }
}
