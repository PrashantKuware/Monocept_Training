package assignment1.StudentCourseEnrollment;

import java.util.ArrayList;

class Student {

    private int studentId;
    private String name;
    private String surname;
    private String fatherName;
    private ArrayList<String> courses;

    public Student(int studentId, String name, String surname, String fatherName) {

        this.studentId = studentId;
        this.name = name;
        this.surname = surname;
        this.fatherName = fatherName;
        this.courses = new ArrayList<>();
    }

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void addCourse(String course) {

        if (courses.contains(course)) {
            System.out.println("Course already enrolled.");
        } else {
            courses.add(course);
            System.out.println("Course added successfully.");
        }
    }

    public void displayDetails() {

        System.out.println("Student ID : " + studentId);
        System.out.println("Name       : " + name + " " + surname);
        System.out.println("Father     : " + fatherName);

        System.out.println("Courses    :");

        if (courses.isEmpty()) {
            System.out.println("No courses enrolled");
        } else {
            for (String c : courses) {
                System.out.println("- " + c);
            }
        }
    }
}