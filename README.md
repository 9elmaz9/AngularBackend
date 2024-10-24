# Angular Backend Application

This project is an Angular-based backend application that provides a user management API. It allows you to create, read, and manage user data stored in a MySQL database. The application is built using Spring Boot, Hibernate, and JPA.

**Note:** This project is still in progress. The backend functionality is fully implemented, but the front-end is currently under development.

## Table of Contents
1. [Technologies Used](#technologies-used)
2. [Features](#features)
3. [Learning Opportunities](#learning-opportunities)
4. [Setup Instructions](#setup-instructions)
5. [API Endpoints](#api-endpoints)
6. [Usage Example](#usage-example)
7. [Maven Configuration](#maven-configuration)
<!--8. [Contributing](#contributing)
9. [License](#license)-->

## Technologies Used

- **Java 11**
- **Spring Boot 2.7.11**
- **Hibernate JPA**
- **MySQL**
- **H2 Database (for testing)**
- **Lombok**
- **Maven**

## Features

- User registration with validation (username and password requirements).
- User authentication and retrieval.
- CRUD operations for user management.
- Pagination support for retrieving users.
- Uses H2 database for runtime testing.

## Learning Opportunities

Working with this project will give you hands-on experience with:

1. **Spring Boot**: Learn how to build a RESTful API with Spring Boot and configure it to use JPA for database interaction.
2. **Hibernate JPA**: Understand how to map Java objects to database tables and manage database operations.
3. **MySQL**: Get comfortable configuring and interacting with MySQL databases in a Spring Boot project.
4. **API Design**: Explore how to design and implement user management APIs with pagination and validation.
5. **Maven**: Learn how to manage dependencies, build, and run your project with Maven.
6. **Lombok**: Simplify Java code using Lombok annotations for getter, setter, and constructor generation.
7. **Pagination**: Discover how to implement pagination in REST APIs to handle large datasets.
8. **Front-End Integration** (Coming Soon): In the next phase, the front-end of this application will be built using Angular. You’ll learn how to integrate the backend with Angular and create a full-stack application.

## Setup Instructions

### Prerequisites

Make sure you have the following installed:

- Java 11
- Maven
- MySQL
- Git

### Installation

1. Clone the repository:
    ```bash
    git clone https://github.com/yourusername/AngularBackend.git
    ```
2. Navigate to the project directory:
    ```bash
    cd AngularBackend
    ```
3. Configure the MySQL database. Create a database called `userdb` and adjust the credentials in `DatabaseConfig` if necessary:
    ```sql
    CREATE DATABASE userdb;
    ```

4. Install dependencies and build the project using Maven:
    ```bash
    mvn clean install
    ```

5. Run the application:
    ```bash
    mvn spring-boot:run
    ```

6. The application will be available at `http://localhost:8080`.

## API Endpoints

### Get All Users
- **Endpoint:** `GET /api/v1/users/`
- **Description:** Returns a list of all users.
- **Params:**
    - `page` (default: 1) - Page number for pagination.
    - `size` (default: 50) - Number of users per page.
  
### Create a New User
- **Endpoint:** `POST /api/v1/users`
- **Description:** Registers a new user with the provided username and password.
- **Body:**
    ```json
    {
      "username": "newuser",
      "password": "Password123@"
    }
    ```

### Get a User by ID
- **Endpoint:** `GET /api/v1/users/{id}`
- **Description:** Returns details of a user by their unique ID.

## Usage Example

Here's an example of how to create a new user using `curl`:

```bash
curl -X POST http://localhost:8080/api/v1/users \
  -H "Content-Type: application/json" \
  -d '{"username": "newuser", "password": "Password123@"}'

<!-- Contributing
If you'd like to contribute to this project, please fork the repository and submit a pull request. All contributions are welcome!

License
This project is licensed under the MIT License. See the LICENSE file for more details. -->
