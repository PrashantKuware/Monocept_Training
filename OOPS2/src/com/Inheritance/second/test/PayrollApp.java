package com.Inheritance.second.test;
import com.Inheritance.second.model.*;

public class PayrollApp {

    public static void main(String[] args) {

        Employee e1 = new FullTimeEmployee(101, "Rahul",
                30000, 5000, 2000);

        Employee e2 = new PartTimeEmployee(102, "Amit",
                80, 500);

        Employee e3 = new ContractEmployee(103, "Sneha",
                40000, 5000);

        e1.displayEmployee();
        e2.displayEmployee();
        e3.displayEmployee();
    }
}
