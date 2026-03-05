package com.abstractImplimentation.second.model;

public class EmergencyPatient extends Patient {

    private double emergencyCharge;

    public EmergencyPatient(int patientId, String name, double emergencyCharge) {
        super(patientId, name);
        this.emergencyCharge = emergencyCharge;
    }

    @Override
    protected void calculateCharges() {
        baseAmount = emergencyCharge + 2000; // emergency surcharge
    }
}