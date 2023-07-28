# Task:
Create REST API (JSON HTTP API)

# What is used in the work:
1. Development tools: Java 8
2. Framework: Spring Boot 1.3.0 (or higher)
3. Data Base: MySQL
4. Protocol: HTTP, port 80

# Functionality (Requests):
## 1. Adding a new user
* We transfer the user's personal data to the server (URI image, username, email, etc.)
* Storing information in a database
* Server response - unique ID of the new user

## 2. Getting user information
* Passing a unique user ID to the server
* Reading information from the database
* Server response - user's personal data (see above)

## 3. Change user status (Online, Offline)
* Passing a unique user ID to the server
* Change user status
* Server response - unique user ID, new and previous status
