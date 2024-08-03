# **Social Network Backend**

Welcome to the backend code for my social network project! This project showcases my skills in Java, Spring Boot, and various modern development practices. Below, you'll find an overview of the key features and technologies used in this project.

## **Features**

<h2>CRUD Operations</h2>
Basic Create, Read, Update, and Delete operations for various entities in the social network.

<h2>Spring Security Integration</h2>
Secure authentication and authorization mechanisms.

<h2>User Roles</h2>
Create users with specific roles and restrict access to pages and requests based on these roles.

<h2>Data Encryption</h2>
Sensitive data such as passwords are securely encrypted.

<h2>Post Creation and Retrieval</h2>
Users can write posts and retrieve them via unique URLs.

<h2>Database</h2>
PostgreSQL is used as the primary database.

<h2>Caching</h2>
Redis is implemented for efficient caching.

<h2>Deployment</h2>
The entire application is containerized and deployed using Docker.

## **Technologies Used**

<h3>Java</h3>
Core programming language for the project.

<h3>Spring Boot</h3>
Framework for building the application.

<h3>Spring Security</h3>
For securing the application.

<h3>PostgreSQL</h3>
Database management system.

<h3>Redis</h3>
In-memory data structure store used for caching.

<h3>Docker</h3>
Containerization platform for deployment.


## **Getting Started**

### **Prerequisites**

- Java 11 or higher
- Docker
- Docker Compose
- Postman
  

### **Installation**

1. **Clone the repository**:
    ```sh
    git clone https://github.com/KotouraSan/Social-Network.git
    cd social-network
    ```

2. **Build and run with Docker Compose**:
    ```sh
    docker-compose up --build
    ```

### **Configuration**

The application configuration is managed via `application.properties` file. Ensure to set up your PostgreSQL and Redis configurations accordingly.

### **Usage**

After running the application, you can access the endpoints as defined in your Spring Boot application. Use a tool like Postman to interact with the API.

---

**Author**: [Firuziddin Najimov](https://github.com/KotouraSan)

For more details, check out the individual sections and documentation within the project.
