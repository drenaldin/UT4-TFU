package com.example.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import java.util.Objects;

@SpringBootApplication
@RestController
public class ApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }

    @Bean
    public KeyResolver userKeyResolver() {
        return exchange -> Mono.just(
            Objects.requireNonNull(exchange.getRequest().getRemoteAddress())
            .getAddress().getHostAddress()
        );
    }

    @GetMapping("/fallback/users")
    public Mono<String> fallbackUsers() {
        return Mono.just("El servicio de usuarios no está disponible temporalmente.");
    }

    @GetMapping("/fallback/projects")
    public Mono<String> fallbackProjects() {
        return Mono.just("El servicio de proyectos no está disponible temporalmente.");
    }
    
    @GetMapping("/fallback/tasks")
    public Mono<String> fallbackTasks() {
        return Mono.just("El servicio de tareas no está disponible temporalmente.");
    }
}