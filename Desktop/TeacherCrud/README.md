# Teacher Management System

## 🚀 How to Run the Project
Open your terminal in this folder and run:
```bash
mvn spring-boot:run
```
*(Make sure you have Java and Maven installed)*

---

## Project Structure Explained

```
TeacherManagement
├── pom.xml                     <-- Maven configuration (Dependencies like Spring Web, H2, JSP)
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.example.eventmanagement
│   │   │       ├── TeacherApplication.java          <-- Main entry point (Starts the App)
│   │   │       ├── model
│   │   │       │   └── Teacher.java                 <-- Database Table Structure (Entity)
│   │   │       ├── repository
│   │   │       │   └── TeacherRepository.java       <-- Database Tools (Save, Delete, Find)
│   │   │       └── controller
│   │   │           └── TeacherController.java       <-- Traffic Cop (Handles URL requests)
│   │   ├── resources
│   │   │   └── application.properties               <-- Settings (Port, DB, JSP path)
│   │   └── webapp
│   │       └── WEB-INF
│   │           └── jsp
│   │               ├── teachers.jsp                 <-- Main Page (List of Teachers)
│   │               ├── edit_teacher.jsp             <-- Edit Page
│   │               └── delete_confirm.jsp           <-- Delete Confirmation Page
```

## Detailed Explanation

### 1. Backend (Java)
- **`model/Teacher.java`**: This is your "Data". It represents a Teacher with an `ID`, `Name`, and `Subject`. It maps directly to a database table.
- **`repository/TeacherRepository.java`**: This is your "Database Manager". It automatically provides methods like `.save()`, `.findAll()`, `.deleteById()` to interact with the teacher data.
- **`controller/TeacherController.java`**: This is the "Brain".
    - **GET** `/teachers`: Shows the list of all teachers.
    - **POST** `/teachers`: Adds a new teacher to the database.
    - **GET** `/teachers/edit/{id}`: Shows the form to edit an existing teacher.
    - **GET** `/teachers/delete/{id}`: Shows the confirmation page to delete a teacher.

### 2. Frontend (JSP)
- **`webapp/WEB-INF/jsp/`**: Contains the visual pages.
- **`teachers.jsp`**: The dashboard showing the table of teachers and the "Add Teacher" form.
- **`edit_teacher.jsp`**: Form to edit teacher details (Name, Subject).
- **`delete_confirm.jsp`**: Asks for confirmation before deleting a teacher.

### 3. Configuration
- **`pom.xml`**: Defines dependencies (Spring Boot, H2, Jasper for JSP).
- **`application.properties`**: Configures the app to run on port 8080 or the default port, and use H2 in-memory database.

## ⚠️ Important Note About Data Storage
Currently, the project uses an **H2 In-Memory Database**.
- **Where is data stored?**: Inside your computer's RAM (Temporary Memory).
- **What happens when I stop the app?**: All teacher data will be **DELETED**.
- **Why?**: For simplicity and ease of setup without needing an external database installation like MySQL.

## 🧠 Concepts & Why We Used Them

### 1. What is H2 Database?
- **What**: It is a super-lightweight database written in Java that runs inside your application's memory.
- **Why**: We used it because you don't need to install anything. It just works when you click run. Great for testing and simple projects.

### 2. What is JPA Repository?
- **What**: `JpaRepository` is a magic interface from Spring Data.
- **Why**: Normally, to save data, you write SQL: `INSERT INTO teachers...`. With JPA Repository, you just write `teacherRepository.save(teacher)`. It writes the SQL for you automatically.

### 3. What is Model / Entity?
- **What**: The `Teacher.java` class.
- **Why**: It maps your Java code to the Database table.
    - Class `Teacher` -> Table `TEACHER`
    - Field `name` -> Column `NAME`
- **Annotations**: `@Entity` tells Hibernate "This class is a database table". `@Id` tells it "This is the Primary Key".

### 4. Controller
- **Role**: Handles incoming HTTP requests and decides what to do (e.g., fetch data, save data, show a page).
