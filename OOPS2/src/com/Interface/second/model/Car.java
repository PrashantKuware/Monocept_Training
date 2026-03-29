package com.Interface.second.model;

public class Car implements Vehicle {

    private String fuel;

    public Car(String fuel) {
        this.fuel = fuel;
    }

    @Override
    public void start() {
        System.out.println("Car is starting...");
    }

    @Override
    public void stop() {
        System.out.println("Car is stopping...");
    }

    @Override
    public String fuelType() {
        return fuel;
    }
}