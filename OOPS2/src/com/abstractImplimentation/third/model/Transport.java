package com.abstractImplimentation.third.model;

public abstract class Transport {

    protected String routeId;
    protected double baseFare;

    public Transport(String routeId, double baseFare) {
        this.routeId = routeId;
        this.baseFare = baseFare;

        System.out.println("Transport constructor executed");
    }

    public void printTicket(double fare) {

        System.out.println("----- Ticket -----");
        System.out.println("Route ID: " + routeId);
        System.out.println("Base Fare: " + baseFare);
        System.out.println("Total Fare: " + fare);
        System.out.println("------------------");
    }

    public abstract double calculateFare();
}