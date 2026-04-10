package assigment1.sorted;
import java.util.*;

class Student 
{
    String name;
    int marks;

    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }
}


 class six {
    public static void main(String[] args) {
        List<Student> list = Arrays.asList(
            new Student("Karan", 50),
            new Student("Manish", 234),
            new Student("Ram", 65),
            new Student("Lala", 267),
            new Student("Ganesh", 98),
            new Student("Ramesh", 56)
        );

        list.stream()
            .sorted((p1, p2) -> p1.marks - p2.marks)
            .forEach(p -> System.out.println(p.name + " " + p.marks));
    }
}