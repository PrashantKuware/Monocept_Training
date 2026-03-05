package com.arrayofObject.third.model;

public abstract class Vehicle 
{

    protected String vehicleNumber;

    protected static int totalVehiclesProcessed = 0;
    protected static double totalTollCollected = 0;

    public Vehicle(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
        totalVehiclesProcessed++;
    }

    // Method overloading
    public double calculateToll() {
        return 0;
    }

    public double calculateToll(double amount) {
        return amount;
    }

    public abstract double calculateFinalToll();

    public void processVehicle() {
        double toll = calculateFinalToll();
        totalTollCollected += toll;

        System.out.println("Vehicle Number : " + vehicleNumber);
        System.out.println("Toll Amount    : " + toll);
        System.out.println("---------------------------");
    }

    public static void displayTotals() {
        System.out.println("Total Vehicles Processed: " + totalVehiclesProcessed);
        System.out.println("Total Toll Collected   : " + totalTollCollected);
    }
}