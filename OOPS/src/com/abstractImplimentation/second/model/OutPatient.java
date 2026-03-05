package com.abstractImplimentation.second.model;

public class OutPatient extends Patient {

    private double consultationFee;

    public OutPatient(int patientId, String name, double consultationFee) {
        super(patientId, name);
        this.consultationFee = consultationFee;
    }

    @Override
    protected void calculateCharges() {
        baseAmount = consultationFee;
    }
}