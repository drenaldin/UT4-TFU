package com.example.tasks_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableAsync
@EnableScheduling
public class TasksServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(TasksServiceApplication.class, args);
	}
}