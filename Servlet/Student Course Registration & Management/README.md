
# Student Course Registration System

A full-stack Student Course Registration System developed using Java, JSP, Servlets, JDBC, MySQL, HTML, CSS, and Apache Tomcat.

This project allows the admin to manage students, courses, and course registrations through a web-based dashboard.


## Features

- Admin Login Authentication
- Dashboard with Statistics
- Add Student
- View Students
- Update Student
- Delete Student
- Add Course
- View Courses
- Update Course
- Delete Course
- Register Student in Course
- View Registrations
- Update Registration Status
- Delete Registration
- Duplicate Registration Validation
- Session Management
- Responsive UI Design

## Technologies Used

### Frontend
- HTML5
- CSS3
- JSP

### Backend
- Java
- Servlets
- JDBC

### Database
- MySQL

### Server
- Apache Tomcat 11

### IDE
- Eclipse IDE




## Project Structure

```text
StudentCourseRegistrationSystem
│
├── src/main/java
│   └── com.studentcourse
│       │
│       ├── controller
│       │   │
│       │   ├── course
│       │   │   ├── AddCourseServlet.java
│       │   │   ├── CoursesChoice.java
│       │   │   ├── DeleteCourseServlet.java
│       │   │   ├── GetAllcourse.java
│       │   │   └── UpdateCourseServlet.java
│       │   │
│       │   ├── registration
│       │   │   ├── AddRegistrationServlet.java
│       │   │   ├── DeleteRegistrationServlet.java
│       │   │   ├── GetAllRegistration.java
│       │   │   ├── RegistrationChoice.java
│       │   │   └── UpdateRegistrationServlet.java
│       │   │
│       │   ├── student
│       │   │   ├── AddStudentServlet.java
│       │   │   ├── DeleteStudentServlet.java
│       │   │   ├── GetAllStudent.java
│       │   │   ├── StudentChoice.java
│       │   │   └── UpdateStudentServlet.java
│       │   │
│       │   ├── AuthFilter.java
│       │   ├── Dashboardchoice.java
│       │   ├── DashboardServlet.java
│       │   ├── LoginPageServlet.java
│       │   └── LogoutServlet.java
│       │
│       ├── dao
│       │   ├── AdminDAO.java
│       │   ├── CourseDAO.java
│       │   ├── RegistrationDAO.java
│       │   └── StudentDAO.java
│       │
│       ├── model
│       │   ├── Admin.java
│       │   ├── Course.java
│       │   ├── Registration.java
│       │   └── Student.java
│       │
│       └── util
│           └── DBConnection.java
│
├── src/main/webapp
│   │
│   ├── css
│   │   ├── dashboard.css
│   │   ├── registration.css
│   │   ├── registrationDelete.css
│   │   ├── registrationEdit.css
│   │   ├── studentDelete.css
│   │   ├── studentEdit.css
│   │   ├── studentForm.css
│   │   ├── studentList.css
│   │   └── studentRegister.css
│   │
│   ├── META-INF
│   │
│   ├── WEB-INF
│   │   │
│   │   ├── lib
│   │   │
│   │   ├── views
│   │   │   │
│   │   │   ├── course
│   │   │   │   ├── course-delete.jsp
│   │   │   │   ├── course-edit.jsp
│   │   │   │   ├── courseForm.jsp
│   │   │   │   ├── course-list.jsp
│   │   │   │   └── New-course-enter.jsp
│   │   │   │
│   │   │   ├── registration
│   │   │   │   ├── New-registration-enter.jsp
│   │   │   │   ├── registration-delete.jsp
│   │   │   │   ├── registration-edit.jsp
│   │   │   │   ├── registrationForm.jsp
│   │   │   │   └── registration-list.jsp
│   │   │   │
│   │   │   ├── student
│   │   │   │   ├── New-student-enter.jsp
│   │   │   │   ├── student-delete.jsp
│   │   │   │   ├── student-edit.jsp
│   │   │   │   ├── studentForm.jsp
│   │   │   │   └── student-list.jsp
│   │   │   │
│   │   │   ├── dashboard.jsp
│   │   │   └── error.jsp
│   │   │
│   │   └── web.xml
│   │
│   ├── index.css
│   └── login.jsp
│
└── README.md
```


## Package Breakdown

| Package | Classes | Role |
|----------|----------|------|
| `controller` | `DashboardServlet`, `LoginServlet`, `LogoutServlet`, `AuthFilter` | Handles request processing, authentication, and navigation |
| `controller.student` | `AddStudentServlet`, `UpdateStudentServlet`, `DeleteStudentServlet`, `GetAllStudentsServlet` | Manages student-related operations |
| `controller.course` | `AddCourseServlet`, `UpdateCourseServlet`, `DeleteCourseServlet`, `GetAllCoursesServlet` | Manages course-related operations |
| `controller.registration` | `AddRegistrationServlet`, `UpdateRegistrationServlet`, `DeleteRegistrationServlet`, `GetAllRegistration` | Handles student-course registrations |
| `dao` | `StudentDAO`, `CourseDAO`, `RegistrationDAO`, `UserDAO` | Performs database CRUD operations |
| `model` | `Student`, `Course`, `Registration`, `User` | Represents application entities |
| `utility` | `DBConnection` | Provides database connectivity |
| `WEB-INF/views` | JSP Pages | UI pages for dashboard, forms, lists, and authentication |
| `css` | CSS Files | Styling for dashboard and forms |

---

## Design

| Pattern | Where Used | Description |
|----------|-------------|-------------|
| `MVC Architecture` | Entire Project | Separates Model, View, and Controller layers |
| `DAO Pattern` | `StudentDAO`, `CourseDAO`, `RegistrationDAO` | Encapsulates database access logic |
| `Servlet Controller Pattern` | All Servlets | Handles client requests and responses |
| `Session Management` | `LoginServlet`, `AuthFilter` | Maintains authenticated user sessions |
| `Separation of Concerns` | `controller`, `dao`, `model`, `views` | Keeps business logic organized |
| `Validation Logic` | Registration & Form Modules | Prevents invalid or duplicate data |
| `JSP View Rendering` | JSP Pages | Dynamically displays data from backend |
| `CRUD Operations` | Student, Course, Registration Modules | Implements Create, Read, Update, Delete functionality |

## Database Tables

### Students Table
- student_id
- student_name
- email
- phone
- age
- city

### Courses Table
- course_id
- course_name
- duration
- fees
- trainer_name

### Registrations Table
- registration_id
- student_id
- course_id
- registration_date
- status

<img width="910" height="775" alt="Screenshot 2026-05-17 111041" src="https://github.com/user-attachments/assets/6663f379-cb68-4a2e-b786-744e4ec88582" />
<img width="1694" height="909" alt="image" src="https://github.com/user-attachments/assets/9f100488-c5ef-443d-ab07-7e952919f74c" />
<img width="1893" height="973" alt="image" src="https://github.com/user-attachments/assets/8d34b218-aca3-4960-a308-1be7017eacf3" />
<img width="1892" height="977" alt="image" src="https://github.com/user-attachments/assets/4e4dbd8a-ea00-4d8d-880f-557bfadddba5" />
<img width="1883" height="922" alt="image" src="https://github.com/user-attachments/assets/a1ff783e-e941-4413-b7fe-37e7d536c5b8" />
<img width="1801" height="653" alt="image" src="https://github.com/user-attachments/assets/0e7c0475-ebbc-40df-8977-e6ac6e4ac1aa" />



## How to Run

1. Clone the repository
2. Import project into Eclipse
3. Configure Apache Tomcat Server
4. Create MySQL database
5. Execute SQL tables
6. Update database credentials
7. Run project on server

## Database Configuration

Update database credentials in:

DBConnection.java

```java
String url = "jdbc:mysql://localhost:3306/your_database";
String username = "root";
String password = "your_password";

## Learning Outcomes

- MVC Architecture
- JDBC CRUD Operations
- Session Management
- Form Validation
- JSP and Servlet Integration
- MySQL Database Design
- DAO Design Pattern



