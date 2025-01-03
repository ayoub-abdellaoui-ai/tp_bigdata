# Spring Boot CRUD Application with Cassandra

This is a simple Spring Boot application that performs CRUD (Create, Read, Update, Delete) operations for managing products stored in a Cassandra database.

---

## Table of Contents
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Setup and Installation](#setup-and-installation)
- [Endpoints](#endpoints)
- [Testing](#testing)
- [Future Enhancements](#future-enhancements)

---

## Features
- CRUD operations for product management.
- Integration with Cassandra as the database.
- RESTful API built with Spring Boot.

---

## Technologies Used
- **Spring Boot**: Framework for building the application.
- **Spring Data Cassandra**: For Cassandra database integration.
- **Cassandra**: Distributed NoSQL database.
- **Docker**: Used for running Cassandra in a containerized environment.
- **Postman**: API testing tool.

---

## Setup and Installation

### Prerequisites
- Java 17 or higher
- IntelliJ IDEA or another IDE
- Docker (for running Cassandra)

### Steps to Run the Application

1. **Clone the repository**:
   ```bash
   git clone <repository-url>
   cd <repository-folder>
   ```

2. **Set up Cassandra with Docker**:
   ```bash
   docker run --name cassandra -p 9042:9042 -d cassandra:latest
   ```
   - Use the following commands to create a keyspace:
     ```sql
     CREATE KEYSPACE produit_keyspace 
     WITH replication = {'class': 'SimpleStrategy', 'replication_factor': 1};
     USE produit_keyspace;
     ```

3. **Configure `application.properties`**:
   Update the file with your Cassandra connection details:
   ```properties
   spring.data.cassandra.contact-points=localhost
   spring.data.cassandra.port=9042
   spring.data.cassandra.keyspace-name=produit_keyspace
   spring.data.cassandra.local-datacenter=datacenter1
   ```

4. **Build and Run the application**:
   ```bash
   ./mvnw spring-boot:run
   ```

---

## Endpoints

### Base URL: `/products`

| HTTP Method | Endpoint        | Description                 | Request Body Example                     |
|-------------|-----------------|-----------------------------|------------------------------------------|
| POST        | `/products`     | Create a new product        | `{ "name": "Laptop", "price": 1200.0 }` |
| GET         | `/products`     | Get all products            | -                                        |
| GET         | `/products/{id}`| Get a product by ID         | -                                        |
| PUT         | `/products`     | Update a product            | `{ "id": "<UUID>", "name": "Updated Name", "price": 1300.0 }` |
| DELETE      | `/products/{id}`| Delete a product by ID      | -                                        |

---

## Testing
1. **Using Postman**:
   - Test each endpoint by sending appropriate HTTP requests.
   - For POST and PUT requests, send JSON in the request body.

2. **Using IntelliJ**:
   - Run the application and monitor logs for database interactions.

---

## Future Enhancements
- Add authentication and authorization using Spring Security.
- Implement pagination and sorting for the `GET /products` endpoint.
- Dockerize the entire application for easier deployment.
- Add Swagger for API documentation.

---

## License
This project is licensed under the MIT License. See the `LICENSE` file for details.
