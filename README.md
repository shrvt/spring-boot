# Spring-Boot Microservices Application

This is a small application comprised of multiple microservices developed for learning purposes. Each microservice serves a specific function in the system architecture.

## Microservices

1. **company-service**: Responsible for managing company details.
2. **config-service**: Manages global project configuration.
3. **discovery-service**: Utilizes Eureka client as a service registry.
4. **gateway-service**: Acts as a gateway for accessing services and handles load balancing among microservices.
5. **student-service**: Manages student details.

## Integration and Connection

The application is integrated with the following components:

- **Zipkin**: Used for distributed tracing.
- **Redis**: Utilized for distributed caching.
- **Swagger**: Provides API documentation.
- **Rest Client**: Facilitates communication with other services.
- **Eureka**: Utilized for service discovery and registration.

Feel free to explore each microservice and its functionalities further!

## Setup Instructions

To run the application locally, follow these steps:

1. Clone the repository.
2. Navigate to each microservice directory.
3. Build each microservice using Maven.
4. Ensure all required dependencies are installed and configured.
5. Start each microservice using Spring Boot.
6. Access the gateway service to interact with the application.

Enjoy exploring and learning with this Spring Boot microservices application!