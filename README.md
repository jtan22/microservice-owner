# Microservice Owner

This is a demo project for Spring Boot, implementing a microservice for managing owners.

## Technologies Used

- Java 17
- Spring Boot 3.2.3
- Maven
- MySQL
- Lombok

## Getting Started

### Prerequisites

- Java 17
- Maven
- MySQL

### Installation

1. Clone the repository:
    ```sh
    git clone https://github.com/jtan22/microservice-owner.git
    cd microservice-owner
    ```

2. Configure the database:
    - Create a MySQL database named `owner_db`.
    - Update the database configuration in `src/main/resources/application.properties`.

3. Build the project:
    ```sh
    mvn clean install
    ```

4. Run the application:
    ```sh
    mvn spring-boot:run
    ```

## Running Tests

To run the unit and integration tests, use the following command:
```sh
mvn test
```

## API Endpoints

### Get All Owners
- URL: /owners
- Method: GET
- Response:
    ```json
    {
        "content": [],
        "totalElements": 10,
        "number": 0,
        "size": 5
    }
    ```
### Get Owners by Last Name
- URL: /owners?lastName=Davis
- Method: GET
- Response:
    ```json
    {
        "content": [],
        "totalElements": 2,
        "number": 0,
        "size": 5
    }
    ```
### Get Owner by ID
- URL: /owners/{id}
- Method: GET
- Response:
    ```json
    {
        "id": 1,
        "firstName": "John",
        "lastName": "Doe",
        "address": "123 Main St",
        "city": "Anytown",
        "telephone": "1234567890"
    }
    ```
### Create a New Owner
- URL: /owners
- Method: POST
- Request Body:
    ```json
    {
        "firstName": "John",
        "lastName": "Doe",
        "address": "123 Main St",
        "city": "Anytown",
        "telephone": "1234567890"
    }
    ```
- Response:
    ```json
    {
        "id": 1,
        "firstName": "John",
        "lastName": "Doe",
        "address": "123 Main St",
        "city": "Anytown",
        "telephone": "1234567890"
    }
    ```
### Update an Existing Owner
- URL: /owners/{id}
- Method: PUT
- Request Body:
    ```json
    {
        "firstName": "John",
        "lastName": "Doe",
        "address": "123 Main St",
        "city": "Anytown",
        "telephone": "1234567890"
    }
    ```
- Response:
    ```json
    {
        "id": 1,
        "firstName": "John",
        "lastName": "Doe",
        "address": "123 Main St",
        "city": "Anytown",
        "telephone": "1234567890"
    }
    ```
### Delete an Owner
- URL: /owners/{id}
- Method: DELETE
- Response:
    ```json
    {
        "message": "Owner deleted successfully"
    }
    ```

## License
This project is licensed under the MIT License - see the LICENSE file for details.
