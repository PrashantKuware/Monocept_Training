package com.abstractImplimentation.second.model;

public class InPatient extends Patient {

    private double roomCharges;

    public InPatient(int patientId, String name, double roomCharges) {
        super(patientId, name);
        this.roomCharges = roomCharges;
    }

    @Override
    protected void calculateCharges() {
        baseAmount = roomCharges;
    }
}