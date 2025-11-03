package com.example.tasks_service.repository;

import com.example.tasks_service.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
