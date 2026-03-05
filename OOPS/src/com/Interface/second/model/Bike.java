package com.Interface.second.model;

public class Bike implements Vehicle {

    @Override
    public void start() {
        System.out.println("Bike is starting...");
    }

    @Override
    public void stop() {
        System.out.println("Bike is stopping...");
    }

    @Override
    public String fuelType() {
        return "Petrol";
    }
}