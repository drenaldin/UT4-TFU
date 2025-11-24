package com.example.projects_service.service;

import com.example.projects_service.model.Project;
import com.example.projects_service.repository.ProjectRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    private final ProjectRepository repository;

    public ProjectService(ProjectRepository repository) {
        this.repository = repository;
    }

    @Cacheable(value = "projects")
    public List<Project> getAllProjects() {
        try { Thread.sleep(3000); } catch (InterruptedException e) {}
        return repository.findAll();
    }

    @CacheEvict(value = "projects", allEntries = true)
    public Project createProject(Project project) {
        return repository.save(project);
    }
}