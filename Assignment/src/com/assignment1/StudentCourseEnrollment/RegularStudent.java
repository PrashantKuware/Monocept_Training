package assignment1.StudentCourseEnrollment;

class RegularStudent extends Student {

    public RegularStudent(int id, String name, String surname, String fatherName) {

        super(id, name, surname, fatherName);
    }

    @Override
    public void displayDetails() {

        super.displayDetails();
        System.out.println("Student Type : Regular");
        System.out.println("---------------------------");
    }
}