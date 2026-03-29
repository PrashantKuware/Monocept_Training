package com.collectionAssigment.CollegeStudentPerformanceTracker.test;

import java.util.*;

import com.collectionAssigment.CollegeStudentPerformanceTracker.model.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Set<Student> students = new HashSet<>();
       

        while (true) {

            System.out.println("1 Add Student");
            System.out.println("2 Add Marks");
            System.out.println("3 Display Sorted (Ranking)");
            System.out.println("4 Sort by Name");
            System.out.println("5 Group by Department");
            System.out.println("6 Remove Low Performers");
            System.out.println("7 Display All");
            System.out.println("8 Exit");

            
            int choice = scanner.nextInt();
            
            switch (choice) {

                case 1:
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Department: ");
                    String dept = scanner.nextLine();

                    System.out.println("1 UG  2 PG");
                    int type = scanner.nextInt();

                    Student s;

                    if (type == 1)
                        s = new UnderGraduateStudent(id, name, dept);
                    else
                        s = new PostGraduateStudent(id, name, dept);

                    if (!students.add(s))
                        System.out.println("Duplicate student not allowed!");

                    break;

                case 2:
                    System.out.print("Enter Student ID: ");
                    int sid = scanner.nextInt();
                    scanner.nextLine();

                    for (Student st : students) {
                        if (st.getId() == sid) {

                            System.out.print("Enter Subject: ");
                            String sub = scanner.nextLine();

                            System.out.print("Enter Marks: ");
                            int marks = scanner.nextInt();

                            st.addMarks(sub, marks);
                        }
                    }
                    break;
                    
                 // ranking
                    
                case 3:
                    List<Student> list = new ArrayList<>(students);
                    Collections.sort(list); 

                    for (Student st : list)
                        System.out.println(st);
                    break;

                case 4:
                    List<Student> list2 = new ArrayList<>(students);
                    Collections.sort(list2, new sortByName());

                    for (Student st : list2)
                        System.out.println(st);
                    break;

                case 5:
                    Map<String, List<Student>> deptMap = new HashMap<>();

                    for (Student st : students) {
                        deptMap.putIfAbsent(st.getDept(), new ArrayList<>());
                        deptMap.get(st.getDept()).add(st);
                    }

                    for (String d : deptMap.keySet()) {
                        System.out.println("\nDepartment: " + d);
                        for (Student st : deptMap.get(d))
                            System.out.println(st);
                    }
                    break;

                case 6:
                    Iterator<Student> it = students.iterator();

                    while (it.hasNext()) {
                        Student st = it.next();
                        if (st.getAverage() < 40) {
                            it.remove(); 
                        }
                    }
                    System.out.println("Removed low performers");
                    break;

                case 7:
                    for (Student st : students)
                        System.out.println(st);
                    break;

                case 8:
                    return;
            }
        }
    }
}