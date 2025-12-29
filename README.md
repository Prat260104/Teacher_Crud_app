# Teacher Management System

## 🚀 How to Run the Project
Open your terminal in this folder and run:
```bash
mvn spring-boot:run
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

