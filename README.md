# Employee Management System — Backend

## Overview

The Employee Management System is a Spring Boot–based backend application that provides secure and efficient management of employee data. It implements role-based authentication and authorization to control access to system features and ensures that only authorized users can perform specific operations.

The system supports core employee management functionalities such as registration, login, OTP-based email verification, OTP resend functionality, and CRUD operations on employee records.

---

## Notes

- Just added the Response Entity that is proper HTTP responses to the client side.
- Added the OTP service via emails.
- Added the verification of OTP classes with logics.
- Added the CRUD operations on the employees after creating the Employee entity class at the EmployeeRepository.
- Added the Response Entity only as a test, can find it on responseEntity/feature-test-4 git branch.
- Added the exception handler for each method separately.
- Added checked or custom exceptions such as UserNotFoundException, InvalidOtpException, OtpExpiredException etc.
- Added validation for the employee fields and made sure multiple validation error messages work using the FieldError class.
- Added the resend OTP functionality through the `/api/users/resend-otp` endpoint.
- Added logic to generate and send a new OTP to the user's registered email when the user requests an OTP again.

---

## Features

- Role-Based Authentication & Authorization
- Employee Registration and Login
- OTP Verification via Email
- Resend OTP functionality
- Secure Access Control
- CRUD Operations for Employee Management
  - Create Employee
  - Retrieve Employee Details
  - Update Employee Information
  - Delete Employee Records
- Input Validation and Exception Handling
- Yet to add some validations and some clear things.
- Wanna add some tests and exception handlers.

---

## Tech Stack

- Java 17
- Spring Boot
  - Spring Web
  - Spring Security
  - Spring Data JPA
  - Spring Validation
- MySQL (or any relational database)
- Maven
- Java Mail Sender (SMTP)

---

## Roles

### Admin

- Full access to employee management
- Can create, update, delete, and view all employee records

### Employee

- Limited access
- Can view and update their own details

---

## Authentication Flow

1. User registers with email and basic details.
2. System sends an OTP to the registered email.
3. User verifies OTP to activate the account.
4. If required, the user can request a new OTP.
5. System generates and sends a new OTP to the registered email.
6. User logs in with credentials.
7. System validates the role and grants access accordingly.

---

## Architecture

<img width="5300" height="6037" alt="diagram" src="https://github.com/user-attachments/assets/f58cad4f-c4df-4d66-b14a-b47346b53af8" />

---

## API Endpoints

### Authentication

- `POST /auth/register`

  Register a new user.

- `POST /auth/verify-otp`

  Verify the user's email using OTP.

- `POST /auth/login`

  Authenticate the user and return access token/session.

### User Management

- `POST /api/users/resend-otp`

  Generate and send a new OTP to the user's registered email.

### Employee Management

- `GET /employees`

  Get all employee details. Admin only.

- `GET /employees/{id}`

  Get employee details by ID.

- `POST /employees`

  Create a new employee. Admin only.

- `PUT /employees/{id}`

  Update employee details.

- `DELETE /employees/{id}`

  Delete an employee. Admin only.

---

## Project Structure

```text
employee-management/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/emsminiproject/Employee/management/system/
│   │   │       │
│   │   │       ├── EmployeeManagementSystemApplication.java
│   │   │       │
│   │   │       ├── configuration/
│   │   │       │   └── Myconfig.java
│   │   │       │
│   │   │       ├── controller/
│   │   │       │   ├── AuthController.java
│   │   │       │   ├── EmployeeController.java
│   │   │       │   └── UserController.java
│   │   │       │
│   │   │       ├── dto/
│   │   │       │   ├── AuthRequest.java
│   │   │       │   ├── AuthResponse.java
│   │   │       │   ├── RegisterRequestDTO.java
│   │   │       │   └── VerifyOtpRequest.java
│   │   │       │
│   │   │       ├── entity/
│   │   │       │   ├── Employee.java
│   │   │       │   └── User.java
│   │   │       │
│   │   │       ├── exception/
│   │   │       │   ├── EmailIdNotFoundException.java
│   │   │       │   ├── GlobalException.java
│   │   │       │   ├── InvalidOtpException.java
│   │   │       │   ├── OtpAlreadyVerifiedException.java
│   │   │       │   ├── OtpExpiredException.java
│   │   │       │   └── UserNotFoundException.java
│   │   │       │
│   │   │       ├── repository/
│   │   │       │   ├── EmployeeRepository.java
│   │   │       │   └── UserRepository.java
│   │   │       │
│   │   │       ├── security/
│   │   │       │   ├── SecurityConfig.java
│   │   │       │   └── JwtFilter.java
│   │   │       │
│   │   │       ├── service/
│   │   │       │   ├── EmailService.java
│   │   │       │   ├── EmployeeService.java
│   │   │       │   ├── OtpService.java
│   │   │       │   └── UserService.java
│   │   │       │
│   │   │       └── util/
│   │   │           └── OtpGenerator.java
│   │   │
│   │   └── resources/
│   │       ├── static/
│   │       ├── templates/
│   │       └── application.properties
│   │
│   └── test/
│
├── .gitignore
├── pom.xml
└── README.md


```

## Email OTP Configuration

- Uses SMTP such as Gmail.
- Sends a time-based OTP to the user's email.
- OTP expires after a defined duration.
- OTP verification is required for account activation.
- Supports requesting a new OTP through the resend OTP endpoint.
- A new OTP is generated and sent to the user's registered email when resend is requested.

---

## Error Handling

- Centralized exception handling using `@ControllerAdvice`.
- Validation using `@Valid`.
- Proper HTTP status codes for all responses.
- Custom exceptions for different failure scenarios:
  - `UserNotFoundException`
  - `InvalidOtpException`
  - `OtpExpiredException`
  - `OtpAlreadyVerifiedException`
  - `EmailIdNotFoundException`

---

## Future Enhancements

- JWT-based authentication
- Password encryption using BCrypt
- Refresh tokens
- Audit logging
- Pagination and filtering
- Deployment using Docker

---

## Getting Started

### Prerequisites

- Java 17+
- Maven
- MySQL or preferred relational database

### Run the Application

```bash
mvn spring-bootrun

```
