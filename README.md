# User Hotel Rating Microservice REST API

## Introduction

The User Hotel Rating Microservice is a RESTful API built using Spring Boot, Spring JPA, Spring Cloud, and Spring Security. The primary purpose of this microservice is to manage hotel ratings provided by users. It allows users to rate hotels, view hotel ratings, and retrieve hotel information. The application is designed to ensure proper authentication and authorization for different user roles.

## Technologies Used

- Spring Boot
- Spring JPA (Java Persistence API) with Oracle Database
- Spring Data MongoDB
- Spring Cloud
- Spring Security
- Oracle Database
- MongoDB
- Eureka Service Registry
- Zuul API Gateway
- Config Server

## Features

- User registration and authentication
- Role-based access control
- Hotel rating and review submission
- Retrieve hotel information
- Service discovery and registration using Eureka
- API routing and gateway using Zuul
- Centralized configuration management using Config Server

## Usage

1. Clone the repository:

git clone https://github.com/sKyi01/user-hotel-rating-microservices-springboot.git

## Navigate to the project directory:
cd user-hotel-rating-microservice

## Run the microservice:
./mvnw spring-boot:run
The microservice will be available at http://localhost:9876.

## API Documentation

## Authentication and Authorization
The microservice uses JWT (JSON Web Tokens) for authentication. To access protected resources, users need to obtain a valid JWT by authenticating with the appropriate credentials. The microservice includes the following user roles:

ROLE_USER: Standard user role.
ROLE_ADMIN: Administrative user role.

For detailed API endpoint access based on user roles, refer to the API documentation.

## Services
The project consists of the following services:

**UserService**: Responsible for user registration, authentication, and user-related operations.

**RatingService**: Handles hotel rating and review submission, as well as retrieving hotel ratings.

**HotelService**: Manages hotel information and related operations.

**ServiceRegistry**: Utilizes Eureka Service Registry for service discovery and registration.

**ApiGateway**: Uses Zuul API Gateway for routing and managing API requests.

**ConfigServer**: Provides centralized configuration management for microservices.


## License
This project is licensed under the MIT License.




