Employee Management System — Backend

Overview

The Employee Management System is a Spring Boot–based backend application that provides secure and efficient management of employee data. It implements role-based authentication and authorization to control access to system features and ensures that only authorized users can perform specific operations.

The system supports core employee management functionalities such as registration, login, OTP-based email verification, and CRUD operations on employee records.

---

Notes

- Just added the Response Entity that is proper HTTP responses to the client side.
- Added the otp service via emails.
- Added the Verfication of otp classes with logics
- Added the crud operations on the employees after creating the Employee entity class. At the EmployeeRepository
- Added the Response Entity only a test, can find it on responseEntity/feature-test-4 git branch
- Added the Excpetion handler for each methods separately.
- Added the checked or custom exception such as UserNotFoundException, InvalidOtpException, OtpExpiredException etc.
Features

- Role-Based Authentication & Authorization
- Employee Registration and Login
- OTP Verification via Email
- Secure Access Control
- CRUD Operations for Employee Management
  - Create Employee
  - Retrieve Employee Details
  - Update Employee Information
  - Delete Employee Records
- Input Validation and Exception Handling
- yet to add some validations and some clear things.
- wanna add some tests and exception handlers.

---

Tech Stack

- Java 17
- Spring Boot
  - Spring Web
  - Spring Security
  - Spring Data JPA
  - Spring Validation
- MySQL (or any relational database)
- Maven
- Java Mail Sender (SMTP) for OTP

---

Roles

- Admin
  
  - Full access to employee management
  - Can create, update, delete, and view all employee records

- Employee
  
  - Limited access
  - Can view and update their own details

---

Authentication Flow

1. User registers with email and basic details
2. System sends an OTP to the registered email
3. User verifies OTP to activate the account
4. User logs in with credentials
5. System validates role and grants access accordingly

---

API Endpoints

Authentication

- POST "/auth/register"
  Register a new user

- POST "/auth/verify-otp"
  Verify email using OTP

- POST "/auth/login"
  Authenticate user and return access token/session

---

Employee Management

- GET "/employees"
  Get all employee details (Admin only)

- GET "/employees/{id}"
  Get employee details by ID

- POST "/employees"
  Create new employee (Admin only)

- PUT "/employees/{id}"
  Update employee details

- DELETE "/employees/{id}"
  Delete employee (Admin only)

---

Project Structure (Suggested)

employee-management/
│── controller/
│   ├── AuthController.java
│   ├── EmployeeController.java
│
│── service/
│   ├── AuthService.java
│   ├── EmployeeService.java
│   ├── OTPService.java
│
│── repository/
│   ├── UserRepository.java
│   ├── EmployeeRepository.java
│
│── model/
│   ├── User.java
│   ├── Employee.java
│   ├── Role.java
│
│── security/
│   ├── SecurityConfig.java
│   ├── JwtFilter.java (optional)
│
│── dto/
│   ├── AuthRequest.java
│   ├── AuthResponse.java
│
│── exception/
│   ├── GlobalExceptionHandler.java
│
│── EmployeeManagementApplication.java

---

Email OTP Configuration

- Uses SMTP (e.g., Gmail)
- Sends a time-based OTP to user email
- OTP expires after a defined duration
- Required for account activation

---

Error Handling

- Centralized exception handling using "@ControllerAdvice"
- Validation using "@Valid"
- Proper HTTP status codes for all responses

---

Future Enhancements

- JWT-based authentication
- Password encryption (BCrypt)
- Refresh tokens
- Audit logging
- Pagination and filtering
- Deployment using Docker

---

Getting Started

Prerequisites

- Java 17+
- Maven
- MySQL (or preferred database)

Run the Application

mvn spring-boot:run

Application will start at:

http://localhost:8080

---

Notes

- Designed as a mini project to demonstrate backend development skills
- Focuses on security, clean architecture, and RESTful API design
- Suitable for academic projects and resume showcasing

---

License

This project is for educational purposes.
