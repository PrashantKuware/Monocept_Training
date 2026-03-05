package com.arrayofObject.second.model;

class Intern extends Employee {

    private double stipend;

    public Intern(int id, String name, double stipend) {
        super(id, name);
        this.stipend = stipend;
    }

    @Override
    public double calculateSalaryFinal() {
        return calculateSalary(stipend);
    }
}