package arrayOfObject;

public class arrayObjecttest {
	public static void main(String[] args) {

        Student[] students = new Student[3];

        students[0] = new Student("Rahul", 20);
        students[1] = new Student("Amit", 22);
        students[2] = new Student("Sneha", 21);

        for (int i = 0; i < students.length; i++) {
            students[i].display();
        }
    }
}
