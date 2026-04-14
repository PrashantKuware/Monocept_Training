package streamTest;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Student {
    int age;
    String name;

    Student(int age, String name) {
        this.age = age;
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
}

class MathUtil {
     int square(int x) {
        return x * x;
    }
}

public class test 
{

	public static void main(String[] args) throws FileNotFoundException
	{
		List<Student> list = Arrays.asList(
				new Student(32,"raj"),
				new Student(32,"aaj"),
				new Student(32,"shan"),
				new Student(34,"paran"),
				new Student(1,"miuse")
				
				);
		
//		list.stream().sorted(Comparator.comparing((Student s) -> s.age).reversed()).forEach(n->System.out.println("Age : "+n.age+", Name : "+n.name));
//		list.stream()
//	    .sorted(
//	        Comparator.comparing(Student::getAge)
//	                  .thenComparing(Student::getName)
//	    )
//	    .map(s -> "Age : " + s.getAge() + ", Name : " + s.getName())
//	    .forEach(System.out::println);
		
		list.stream().sorted(Comparator.comparing((Student s) -> s.age).thenComparing(s -> s.name)).forEach(n -> System.out.println("Name : "+n.name+", Age : "+ n.age));

		// *********************************************************************************************************
		
//		Stream.iterate(new int[] {0,1}, f -> new int[] {f[1], f[0]+f[1]}).limit(5).forEach(n -> System.out.println(n[0]));
//		Stream.iterate(10, n -> n>=0, n -> n-2).forEach(p -> System.out.println(p));
		
		// *****************************************************
		
		List<Integer> ele = Arrays.asList(2,3,4,5,6,7);
//		Stream.iterate(1, n -> n+1).limit(5).map(MathUtil::square).forEach(System.out::println);
//		Stream.iterate(1, n -> n+1).limit(5).map(x -> MathUtil.square(x)).forEach(System.out::println);
		MathUtil mu = new MathUtil();
		ele.stream().map( mu::square).forEach(System.out :: println);
		
		// *****************************************************
		
		List<String> string = Arrays.asList("shan", "pran","ravan");
//		string.stream().map(String::toUpperCase).forEach(System.out :: println);
		
		// *****************************************************
		
		PrintStream fileStream = new PrintStream("output.txt");

		BiConsumer<PrintStream, String> printer = PrintStream::println;

		printer.accept(System.out, "Console Output");
		printer.accept(fileStream, "File Output");
	}

}
