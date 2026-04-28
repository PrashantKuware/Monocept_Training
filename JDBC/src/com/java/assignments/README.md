<<<<<<< HEAD

# Student Course Registration & Fee Management System

A console-based Student Course Registration & Fee Management System application implemented using Java + JDBC with clean architecture, modularity, and scalability in mind.

## Overview
- MainApp acts as the entry point (UI layer) and handles menu-driven interaction
- StudentService acts as the core orchestration layer (business logic)
- DAO layer abstracts all database operations using JDBC
- System supports:
     - Student management
     - Course registration\
     - Fee handling
     - Reports & analytics
- Course, Department, and Branch are fully dynamic (DB-driven)
- IInput handling and validation are decoupled for reuse and robustness
- Transactions ensure data consistency and atomicity

## Technology
- Java
- JDBC
- MySQL
## Operational Capabilities
1. Add Student
2. Register for Course
3. View All Students with Courses
4. Search Student by ID
5. Update Student
6.  Update Course Fee
7.  Cancel Registration
8.  Delete Student
9.  High Paying Students Report
10.  Course-wise Student Count
11.  Add new course
12.  Add new department
13.  Add new branch
14.  Show all courses
15.  Show all branches
16.  Exit

## Package Breakdown

| Package | Classes | Role |
|--------|--------|------|
| `model` | `Student`, `Registration`, `Course`, `Department`, `Branch` | Core domain entities |
| `dao` | `StudentDAO`, `RegistrationDAO`,  `CourseDAO`, `DepartmentDAO`, `BranchDAO` | Database interaction (JDBC) |
| `service` | `StudentService` | Business logic + transaction handling |
| `util` | `DBUtil` | Database connection management |
| `validation` | `InputValidator` | Input validation & sanitization |
| `app` | `MainApp` | Menu-driven UI |
| `test` | `GameStarter` | Application launcher |

## Database Design
### student
- id INT PRIMARY KEY
- name VARCHAR(50)
- age INT
- branch VARCHAR(50)
### registration
- reg_id INT PRIMARY KEY AUTO_INCREMENT
- student_id INT
- course_name VARCHAR(50)
- fees_paid DOUBLE
- FOREIGN KEY (student_id) REFERENCES student(id)
### Course
- course_id INT PRIMARY KEY AUTO_INCREMENT
- course_name VARCHAR(50)
### Department
- dept_id INT PRIMARY KEY
- dept_name VARCHAR(50)
### Branch
- branch_id INT PRIMARY KEY
- branch_name VARCHAR(50)
- dept_id INT
- FOREIGN KEY (dept_id) REFERENCES department(dept_id)

 ## ER - Diagram
<img width="537" height="457" alt="image" src="https://github.com/user-attachments/assets/94e41b52-4b3d-461b-84b1-c05d06fee033" />


## Program Flow
<img width="473" height="196" alt="image" src="https://github.com/user-attachments/assets/caa8ef14-fb47-485d-9bdc-2d13ce0ba49a" />



=======

>>>>>>> 57508902c8886935bf7e25fed386aaabf1cc55a1
