package assignment1.StudentCourseEnrollment;

import java.util.Scanner;

public class StudentSystem {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Student[] students = new Student[5];
        int count = 0;

        while (count < students.length) {

            int id;
            String name;
            String surname;
            String father;

            while (true) {

                System.out.print("Enter Student ID (3-6 digits): ");
                String input = scanner.nextLine();

                if (input.matches("\\d{3,6}")) {
                    id = Integer.parseInt(input);
                    break;
                } else {
                    System.out.println("Invalid ID.");
                }
            }

            while (true) {

                System.out.print("Enter Name: ");
                name = scanner.nextLine();

                if (name.matches("[a-zA-Z]{2,20}")) {
                    break;
                } else {
                    System.out.println("Invalid name.");
                }
            }

            while (true) {

                System.out.print("Enter Surname: ");
                surname = scanner.nextLine();

                if (surname.matches("[a-zA-Z]{2,20}")) {
                    break;
                } else {
                    System.out.println("Invalid surname.");
                }
            }

            while (true) {

                System.out.print("Enter Father Name: ");
                father = scanner.nextLine();

                if (father.matches("[a-zA-Z]{2,20}")) {
                    break;
                } else {
                    System.out.println("Invalid father name.");
                }
            }

            boolean duplicate = false;

            for (int i = 0; i < count; i++) {

                if (students[i].getStudentId() == id &&
                        students[i].getName().equalsIgnoreCase(name) &&
                        students[i].getSurname().equalsIgnoreCase(surname) &&
                        students[i].getFatherName().equalsIgnoreCase(father)) {

                    duplicate = true;
                    break;
                }
            }

            if (duplicate) {
                System.out.println("Student already exists.\n");
                continue;
            }

            int type;

            while (true) {

                System.out.println("Select Student Type");
                System.out.println("1 Regular");
                System.out.println("2 Scholarship");

                String input = scanner.nextLine();

                if (input.matches("[12]")) {
                    type = Integer.parseInt(input);
                    break;
                } else {
                    System.out.println("Invalid choice.");
                }
            }

            Student s;

            if (type == 1) {

                s = new RegularStudent(id, name, surname, father);

            } else {

                double scholarship;

                while (true) {

                    System.out.print("Enter Scholarship Amount: ");
                    String input = scanner.nextLine();

                    if (input.matches("\\d+(\\.\\d+)?")) {
                        scholarship = Double.parseDouble(input);
                        break;
                    } else {
                        System.out.println("Invalid amount.");
                    }
                }

                s = new ScholarshipStudent(id, name, surname, father, scholarship);
            }

            while (true) {

                System.out.print("Enter Course Name: ");
                String course = scanner.nextLine();

                if (!course.matches("[a-zA-Z ]{3,30}")) {
                    System.out.println("Invalid course name.");
                    continue;
                }

                s.addCourse(course);

                System.out.print("Add another course? (yes/no): ");
                String option = scanner.nextLine();

                if (!option.equalsIgnoreCase("yes")) {
                    break;
                }
            }

            students[count] = s;
            count++;

            System.out.println("Student added successfully.\n");

            System.out.print("Add another student? (yes/no): ");
            String option = scanner.nextLine();

            if (!option.equalsIgnoreCase("yes")) {
                break;
            }
        }

        System.out.println("\nSTUDENT RECORDS\n");

        for (int i = 0; i < count; i++) {
            students[i].displayDetails();
        }

        scanner.close();
    }
}