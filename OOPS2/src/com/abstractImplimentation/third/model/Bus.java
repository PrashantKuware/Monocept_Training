package com.abstractImplimentation.third.model;

public class Bus extends Transport {

    private double distance;

    public Bus(String routeId, double baseFare, double distance) {
        super(routeId, baseFare);   // constructor chaining
        this.distance = distance;

        System.out.println("Bus constructor executed");
    }

    public double calculateFare() {

        double fare = baseFare + (distance * 2);
        return fare;
    }
}