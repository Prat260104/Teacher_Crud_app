# Event Management System

## 🚀 How to Run the Project
Open your terminal in this folder and run:
```bash
mvn spring-boot:run
```
*(Make sure you have Java and Maven installed)*

---

## Project Structure Explained

```
EventManagement
├── pom.xml                     <-- Maven configuration (Depedencies like Spring Web, H2, JSP)
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.example.eventmanagement
│   │   │       ├── EventManagementApplication.java  <-- Main entry point (Starts the App)
│   │   │       ├── model
│   │   │       │   └── Event.java                   <-- Database Table Structure (Entity)
│   │   │       ├── repository
│   │   │       │   └── EventRepository.java         <-- Database Tools (Save, Delete, Find)
│   │   │       └── controller
│   │   │           └── EventController.java         <-- Traffic Cop (Handles URL requests)
│   │   ├── resources
│   │   │   └── application.properties               <-- Settings (Port, DB, JSP path)
│   │   └── webapp
│   │       └── WEB-INF
│   │           └── jsp
│   │               ├── events.jsp                   <-- Main Page (HTML + Logic)
│   │               ├── edit_event.jsp               <-- Edit Page
│   │               └── delete_confirm.jsp           <-- Delete Confirmation Page
```

## detailed Explanation

### 1. Backend (Java)
- **`model/Event.java`**: This is your "Data". It tells Spring Boot what an "Event" looks like (ID, Name, Date). It maps directly to a database table.
- **`repository/EventRepository.java`**: This is your "Database Manager". It automatically gives you methods like `.save()`, `.findAll()`, `.deleteById()` without writing SQL.
- **`controller/EventController.java`**: This is the "Brain".
    - When you go to `/events`, it asks the Repository for data and sends it to `events.jsp`.
    - When you submit a form, it receives the data and tells the Repository to save it.

### 2. Frontend (JSP)
- **`webapp/WEB-INF/jsp/`**: This is where your visual pages live.
- **`events.jsp`**: The main dashboard. It uses JSTL tags (like `<c:forEach>`) to loop through the data sent by the Controller.

### 3. Configuration
- **`pom.xml`**: Your project's "Shopping List". It tells Maven to download "Spring Boot", "H2 Database", etc.
- **`application.properties`**: Configuration file. We told it to look for JSPs in `/WEB-INF/jsp/` and use an in-memory H2 database.

## ⚠️ Important Note About Data Storage
Currently, the project uses an **H2 In-Memory Database**.
- **Where is data stored?**: Inside your computer's RAM (Temporary Memory).
- **What happens when I stop the app?**: All data (events) will be **DELETED**.
- **Why?**: This keeps the project simple so you don't have to install MySQL or PostgreSQL to run it.
- **For Teacher**: You can explain that "For simplicity, we are using H2 in-memory DB. In a real app, we would change `application.properties` to connect to MySQL for permanent storage."

## 🧠 Concepts & Why We Used Them (For Viva/Interview)

### 1. What is H2 Database?
- **What**: It is a super-lightweight database written in Java that runs inside your application's memory.
- **Why**: We used it because you don't need to install anything (like MySQL/Postgres). It just works when you click run. Great for testing and simple projects.

### 2. What is JPA Repository?
- **What**: `JpaRepository` is a magic interface from Spring Data.
- **Why**: Normally, to save data, you write SQL: `INSERT INTO events...`. With JPA Repository, you just write `eventRepository.save(event)`. It writes the SQL for you automatically.

### 3. What is Model / Entity?
- **What**: The `Event.java` class.
- **Why**: It maps your Java code to the Database table.
    - Class `Event` -> Table `EVENT`
    - Field `name` -> Column `NAME`
- **Annotations**: `@Entity` tells Hibernate "This class is a database table". `@Id` tells it "This is the Primary Key".

### 4. Where is the Service Layer?
- **What**: Usually, there is a layer between Controller and Repository called `Service` (e.g., `EventService`).
- **Why it's missing**: To keep this project **Simple and Small** for your explanation, we skipped it.
- **Role**: If we had it, the Controller would talk to the Service, and the Service would talk to the Repository. It's used for complex logic (e.g., "Send email after creating event"). Since we just do simple CRUD, we connected Controller directly to Repository.
