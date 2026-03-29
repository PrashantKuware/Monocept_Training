package com.arrayofObject.third.model;

public class Motorcycle extends Vehicle {

    public Motorcycle(String vehicleNumber) 
    {
        super(vehicleNumber);
    }

    @Override
    public double calculateFinalToll() {
        return calculateToll(50);
    }
}