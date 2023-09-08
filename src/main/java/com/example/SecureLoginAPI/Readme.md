![Screenshot 2023-09-08 130416](https://github.com/viju-dev/Secure-Login-API/assets/71461702/3bb904f4-571a-4254-af19-2ef7750ddaff)
# Secure Login API

This project implements a backend REST API for user login and signup functionality with security features and JSON Web Tokens (JWT) for authentication. It is built using the Spring Boot framework and utilizes the H2 database for storing user account information.

## Features

- User signup: Allows users to create new accounts securely and stores their information in the H2 database.
- User login: Verifies user credentials and generates a web token (JWT) upon successful authentication.
- Token-based authentication: Uses JWT for user authentication and authorization.
- Secure data storage: Stores user details securely in the H2 database.
- Error handling: Implements error handling for various scenarios to provide meaningful error messages.
- Project setup and documentation: Includes clear instructions for installing, setting up, and deploying the project.

## Installation

1. Clone the repository: `git clone https://github.com/viju-dev/Secure-Login-API.git`
2. Navigate to the project directory: `cd SecureLoginAPI`
3. Build the project: `mvn clean install`
4. Run the application: `mvn spring-boot:run`
5. The application will be accessible at `http://localhost:8080`

## API Endpoints

### User Signup

- URL: `/auth/SignUp`
- Method: `POST`
- Description: Create a new user account.
- Request Body:
  ```json
  {
    "name": "John Doe",
    "email": "johndoe@example.com",
    "password": "password123",
    "userInfo": "Additional user information"
  }
  ```
- Response Body:
  ```json
  {
    "name": "John Doe",
    "email": "johndoe@example.com",
    "userInfo": "Additional user information"
  }
  ```

### User Login

- URL: `/auth/login`
- Method: `POST`
- Description: Authenticate user credentials and generate a web token.
- Request Body:
  ```json
  {
    "email": "johndoe@example.com",
    "password": "password123"
  }
  ```
- Response Body:
  ```json
  {
    "jwtToken": "token-value",
    "username": "johndoe@example.com"
  }
  ```
### Hello

- URL: `/home/hello`
- Method: `GET`
- Description: Get a greeting from Greenstitch.
- Response Body:
  ```json
  "Hello From Greenstitch"
  ```


### Get Users

- URL: `/home/getUsers`
- Method: `GET`
- Description: Get a list of all users.
- Response Body:
  ```json
  [
    "John Doe",
    "Iron Man",
    "Tom Cruise"
  ]
  ```

### Get Logged-in User

- URL: `/home/currentUser`
- Method: `GET`
- Description: Get the username of the currently logged-in user.
- Response Body:
  ```
  johndoe@example.com
  ```

## Technologies Used

- Java
- Spring Boot
- H2 Database
- JSON Web Tokens (JWT)

## Dependencies

- Spring Boot Starter Data JPA
- Spring Boot Starter Web
- H2 Database
- Lombok
- Spring Boot Starter Security
- jjwt-api
- jjwt-impl
- jjwt-jackson

## Testing
### Using Postman

1. Open Postman.
2. Create a new request.
3. Set the request type to According`.
4. Enter the URL of your endpoint (e.g., `http://localhost:8080/hello`).
5. Add the Authorization token in Request header `Authorization`:`token value`
6. Click the "Send" button.
7. You should receive a response with "Hello from GreenStitch."
8. Follow same method for other endpoints, `login` and `signup` endpoints don't require Auth token.
![Screenshot 2023-09-08 130416](https://github.com/viju-dev/Secure-Login-API/assets/71461702/8068abbe-1083-4236-8548-dbffe421bba7)


## Project Structure

The project follows a typical Spring Boot project structure, with separate packages for controllers, services, models, repositories, and security components.

- `com.example.SecureLoginAPI.Controllers`: Contains the REST API controllers.
- `com.example.SecureLoginAPI.Services`: Provides the business logic and services.
- `com.example.SecureLoginAPI.Models`: Defines the data models.
- `com.example.SecureLoginAPI.Repositories`: Handles data access and interacts with the H2 database.
- `com.example.SecureLoginAPI.Security`: Includes security-related components such as JWT helper, authentication filter, and entry point.
- `com.example.SecureLoginAPI.Validators`: Contains custom validators for input data validation.
- `com.example.SecureLoginAPI.Dtos`: Defines Data Transfer Objects (DTOs) for customizing API response data.
- `com.example.SecureLoginAPI.Convertors`: Provides converters for mapping between different data representations.
## Error Handling

Error handling has been implemented throughout the project to handle exceptions and provide appropriate error messages. Each layer (controllers, services, etc.) includes error handling to handle exceptions specific to that layer and return meaningful error responses.

