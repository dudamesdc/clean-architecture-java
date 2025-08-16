# clean-architecture-java – A Java Blog Application

CleanBlog is a small **Java blog application** that follows the **Clean Architecture** principles.  
It provides essential blogging features such as user authentication, post management, and an admin dashboard.  
The application uses **PostgreSQL** as the database and can be run easily with **Docker**.

---

## Features

-  **User Authentication**  
  - Registration and login  
  - Role-based access (Admin / Regular User)  

-  **Blog Management**  
  - Create, edit, and delete posts (Admin only)  
  - List posts for all users  
  - View single post details  

-  **Admin Dashboard**  
  - Manage users and posts  
  - Moderate content  

-  **Database**  
  - PostgreSQL as the primary database  

-  **Dockerized**  
  - Run the app and database easily using Docker  

---

## Tech Stack

- **Java 17+**  
- **Maven** (build and dependency management)  
- **Spring Boot** (or your Java web framework)  
- **PostgreSQL** (database)  
- **Docker & Docker Compose** (containerized environment)  

---

##  Installation & Setup

### 1. Clone the repository
```bash
git clone https://github.com/dudamesdc/clean-architecture-java.git
cd clean-architecture-java
