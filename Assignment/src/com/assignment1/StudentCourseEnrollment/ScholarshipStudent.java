package assignment1.StudentCourseEnrollment;

class ScholarshipStudent extends Student {

    private double scholarshipAmount;

    public ScholarshipStudent(int id, String name, String surname, String fatherName, double scholarshipAmount) {

        super(id, name, surname, fatherName);
        this.scholarshipAmount = scholarshipAmount;
    }

    @Override
    public void displayDetails() {

        super.displayDetails();
        System.out.println("Student Type : Scholarship");
        System.out.println("Scholarship  : " + scholarshipAmount);
        System.out.println("---------------------------");
    }
}