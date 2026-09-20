# Student Task Manager

A Java-based task management application for students.

## Features

- Add tasks
- View tasks
- Edit tasks
- Complete tasks
- Delete tasks
- Search tasks
- Store tasks in MySQL database

## Technologies Used

- Java
- Core Java & OOP
- JDBC
- MySQL
- Git & GitHub

## Concepts Used

- Encapsulation
- Inheritance
- Abstraction
- Interfaces
- ArrayList
- Exception Handling
- File Handling
- JDBC
- DAO Pattern
- SQL CRUD Operations

## Project Structure

- `Main.java` – User interaction and menu
- `Task.java` – Abstract base class
- `StudyTask.java` – Study task implementation
- `TaskOperations.java` – Task operation interface
- `TaskManager.java` – Task management logic
- `TaskDAO.java` – Database operations
- `DBConnection.java` – MySQL connection

## Database

MySQL is used to permanently store task information.

The database contains:

- Task ID
- Title
- Description
- Completion Status

## How to Run

1. Install Java JDK.
2. Install MySQL.
3. Create the `student_task_manager` database.
4. Create the `tasks` table.
5. Configure the `DB_PASSWORD` environment variable.
6. Add MySQL Connector/J to the classpath.
7. Compile the Java files.
8. Run `Main.java`.

## Author

B Nikitha Mahalaxmi
