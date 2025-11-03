# TFU UT4 - Mini Gestor de Proyectos con Patrones de Disponibilidad y Rendimiento

## Descripción
Demo de arquitectura distribuida: API REST para gestión de proyectos con tres servicios:
- **Users Service**
- **Projects Service**
- **Tasks Service**

## Patrones seleccionados
Estos son los patrones que se decidieron utilizar para aplicar a esta 
Disponibilidad:
Health Endpoint Monitoring
Circuit Breaker
Retry
Bulkhead
Rate Limiting

Rendimiento:
Cache-Aside
Queue-Based Load Leveling
Competing Consumers


Se utiliza **Spring Boot + Postgres**, desplegado con **Docker Compose**.

## Estructura del proyecto

- docker-compose.yaml
- users-service/
  - Dockerfile
  - Spring Boot

- projects-service/
  - Dockerfile 
  - Spring Boot

- tasks-service/ 
  - Dockerfile 
  - Spring Boot

## Levantar el proyecto


1. **Construir y levantar los servicios**

   docker-compose up --build


## Endpoints

- **Users Service**: `http://localhost:8081/users`
- **Projects Service**: `http://localhost:8082/projects`
- **Tasks Service**: `http://localhost:8083/tasks`

Cada servicio se conecta a su propia base de datos Postgres (contenedores independientes).
