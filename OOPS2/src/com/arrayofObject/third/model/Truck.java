package com.arrayofObject.third.model;

public class Truck extends Vehicle {

    private int axles;

    public Truck(String vehicleNumber, int axles) {
        super(vehicleNumber);
        this.axles = axles;
    }

    @Override
    public double calculateFinalToll() {
        return calculateToll(200 + (axles * 50));
    }
}