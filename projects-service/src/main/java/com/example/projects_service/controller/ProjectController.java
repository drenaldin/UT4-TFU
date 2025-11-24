package com.example.projects_service.controller;

import com.example.projects_service.model.Project;
import com.example.projects_service.service.ProjectService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectService service; 

    public ProjectController(ProjectService service) {
        this.service = service;
    }

    @GetMapping
    public List<Project> getAllProjects() {
        return service.getAllProjects();
    }

    @PostMapping
    public Project createProject(@RequestBody Project project) {
        return service.createProject(project);
    }
}