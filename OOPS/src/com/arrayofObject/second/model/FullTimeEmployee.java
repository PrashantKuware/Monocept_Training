package com.arrayofObject.second.model;

class FullTimeEmployee extends Employee {

    private double monthlySalary;
    private double bonus;

    public FullTimeEmployee(int id, String name,
                            double monthlySalary, double bonus) {
        super(id, name);  // constructor chaining
        this.monthlySalary = monthlySalary;
        this.bonus = bonus;
    }

    @Override
    public double calculateSalaryFinal() {
        return calculateSalary(monthlySalary + bonus);
    }
}