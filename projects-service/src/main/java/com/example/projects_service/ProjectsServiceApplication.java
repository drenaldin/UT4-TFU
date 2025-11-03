package com.example.projects_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching //Habilito enablecaching
@SpringBootApplication
public class ProjectsServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectsServiceApplication.class, args);
    }
}
