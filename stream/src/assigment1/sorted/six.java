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
//
//        list.stream()
//            .sorted((p1, p2) -> p1.marks - p2.marks)
//            .forEach(p -> System.out.println(p.name + " " + p.marks));
        
        // Best method
        
        list.stream().sorted(Comparator.comparing(s -> s.marks)).forEach(p -> System.out.println(p.name + " " + p.marks));
        
        //nested sorting
        
        list.stream()
	    .sorted(
	        Comparator.comparing((Student s) -> s.marks)
	                  .thenComparing(s -> s.name)
	    )
	    .forEach(n->System.out.println("Marks : "+n.marks+", Name : "+n.name));
        
        //reversed
        
        list.stream().sorted(Comparator.comparing((Student s) -> s.marks).reversed()).forEach(n->System.out.println("Age : "+n.marks+", Name : "+n.name));
    }
}