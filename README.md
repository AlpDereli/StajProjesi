# Project README

## Overview
This Spring Boot project consists of two main services: the **Management Service** and the **Question Service**. These services are designed to handle various administrative and question-related operations.

### Management Service
The Management Service is responsible for all management-related tasks, including:

- **Adding Organizations**: Admin users can add new organizations to the system.
- **Updating Admin Credentials**: Admin users can update their own username and password.
- **Updating Organization Information**: Organizations can update their own details.
- **Sending Invitation Emails**: Organizations can send mock invitation emails to candidates. This is a simulated service, where emails are logged instead of being sent.

### Question Service
The Question Service manages all operations related to questions and options. The following functionalities are provided:

- **Adding Questions**: Both Admin and Organization users can add new questions to the question pool.
- **Updating Questions**: 
  - Admin users can update any question in the system.
  - Organization users can only update their own questions.
- **Deleting Questions**:
  - Admin users can delete any question in the system.
  - Organization users can only delete their own questions.
- **Question Constraints**:
  - Questions that have been used in an active or completed test are locked from editing.
  - A question can be used in multiple tests, but the same question can only appear once in each test.
  - Each question must have between 2 and 5 options.
  - Question text has a maximum length of 2000 characters.
  - Option text has a maximum length of 500 characters.

## Project Structure
The project is divided into the following main packages:

- `com.example.management`: Contains the code related to the Management Service.
- `com.example.question`: Contains the code related to the Question Service.
- `com.example.security`: Contains security configurations, JWT utilities, and filters.

### Entity Classes
- **Admin**: Represents the admin users who have full control over the system.
- **Organization**: Represents organizations that can manage their own questions and tests.
- **Question**: Represents questions in the question pool.
- **Option**: Represents possible options for each question.

### Security
JWT-based authentication is used to secure the application. Custom claims like `organizationId` are added to the JWT to manage access control. The SecurityConfig class configures the security settings, including roles and permissions for different endpoints. (Security not finished)


