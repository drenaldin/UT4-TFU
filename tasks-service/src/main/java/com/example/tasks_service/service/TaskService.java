package com.example.tasks_service.service;
import com.example.tasks_service.model.Task;
import com.example.tasks_service.repository.TaskRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

@Service
public class TaskService {

    private final TaskRepository repository;
    private final Queue<Task> taskQueue = new ConcurrentLinkedQueue<>();

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    public Task queueTask(Task task) {
        taskQueue.add(task);
        System.out.println("Tarea encolada: " + task.getDescription());
        return task; 
    }

    @Scheduled(fixedRate = 5000) 
    public void processTasks() {
        if (!taskQueue.isEmpty()) {
            System.out.println("Procesando tareas en cola...");
            while (!taskQueue.isEmpty()) {
                Task task = taskQueue.poll();
                repository.save(task);
                System.out.println("Tarea guardada en DB: " + task.getDescription());
            }
        }
    }
}