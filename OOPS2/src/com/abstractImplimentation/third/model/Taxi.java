package com.abstractImplimentation.third.model;

public class Taxi extends Transport {

    private double distance;
    private int time;

    public Taxi(String routeId, double baseFare, double distance, int time) {
        super(routeId, baseFare);

        this.distance = distance;
        this.time = time;

        System.out.println("Taxi constructor executed");
    }

    public double calculateFare() {

        double fare = baseFare + (distance * 10) + (time * 2);
        return fare;
    }
}