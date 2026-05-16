use student_management_system;

select * from student;
select * from registration;
select * from department;
select * from branch;
SELECT branch_id, distint(branch_name) FROM branch;

create table department
(
dept_id int primary key,
dept_name varchar(50)
);
insert into department values 
(1, 'Engineering'),
(2, 'Physics'),
(3, 'Chemistry'),
(4, 'Mathematics'),
(5, 'Geology'),
(6, 'Arts');

create table branch
(
branch_id int ,
branch_name varchar(50),
dept_id int,
FOREIGN KEY (dept_id) REFERENCES department(dept_id) 
);
ALTER TABLE branch ADD PRIMARY KEY (branch_id);
insert into branch values
(1, 'instrumentation',1),
(2, 'Electrical',1),
(3, 'Computer Science',1),
(4, 'Physics',2),
(5, 'Chemistry',3),
(6, 'Mathematics',4),
(7, 'Mathematics',4);

insert into branch values
(8, 'Electomegnetics',2),
(9, 'Optics',2),
(10, 'Organic chemistry',3),
(11, 'Biochemistry',3),
(12, 'Discrete Mathematics',4),
(13, 'Calculas',4),
(14, 'Mineralogy',5),
(15, 'Petrology',5),
(16, 'Visual Art',6),
(17, 'Performing Art',6);

CREATE TABLE course (
    course_id INT PRIMARY KEY AUTO_INCREMENT,
    course_name VARCHAR(50)
);
insert into course values
(1, 'B.Tech'),
(2, 'B.Sc'),
(3, 'B.A');