package com.abstractImplimentation.second.model;

public abstract class Patient 
{

    private int patientId;
    private String name;
    protected double baseAmount;

    private static final double TAX_RATE = 0.10; // 10% tax

    public Patient(int patientId, String name) {
        this.patientId = patientId;
        this.name = name;
    }

    protected abstract void calculateCharges();

    public void generateBill() {

        calculateCharges();

        double tax = baseAmount * TAX_RATE;
        double finalAmount = baseAmount + tax;

        System.out.println("\n----- Hospital Bill -----");
        System.out.println("Patient ID: " + patientId);
        System.out.println("Patient Name: " + name);
        System.out.println("Base Amount: ₹" + baseAmount);
        System.out.println("Tax (10%): ₹" + tax);
        System.out.println("Final Amount: ₹" + finalAmount);
        System.out.println("--------------------------");
    }
}