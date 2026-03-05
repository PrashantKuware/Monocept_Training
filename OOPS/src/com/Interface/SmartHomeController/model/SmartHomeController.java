package com.Interface.SmartHomeController.model;

public class SmartHomeController {

    private Controllable[] devices;

    // Constructor Injection (Loose Coupling)
    public SmartHomeController(Controllable[] devices) {
        this.devices = devices;
    }

    // Corrected Method
    public void controlDevices(String[] modes) {

        for (int i = 0; i < devices.length; i++) {

            devices[i].turnOn();
            devices[i].setMode(modes[i]);
            devices[i].turnOff();

            System.out.println();
        }
    }
}