package com.arrayofObject.third.model;

public class Car extends Vehicle {

    public Car(String vehicleNumber) {
        super(vehicleNumber);
    }

    @Override
    public double calculateFinalToll() {
        return calculateToll(100);
    }
}