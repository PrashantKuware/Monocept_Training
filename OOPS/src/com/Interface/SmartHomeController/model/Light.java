package com.Interface.SmartHomeController.model;

public class Light implements Controllable {

    private boolean isOn = false;
    private final String[] modes = {"On", "Dim", "Off"};

    @Override
    public void turnOn() {
        isOn = true;
        System.out.println("Light turned ON");
    }

    @Override
    public void turnOff() {
        isOn = false;
        System.out.println("Light turned OFF");
    }

    @Override
    public void showModes() {
        System.out.println("Select Light Mode:");
        for (int i = 0; i < modes.length; i++) {
            System.out.println((i + 1) + ". " + modes[i]);
        }
    }

    @Override
    public void setMode(int choice) {
        if (!isOn) {
            System.out.println("Please turn ON the Light first.");
            return;
        }

        if (choice >= 1 && choice <= modes.length) {
            System.out.println("Light mode set to: " + modes[choice - 1]);
        } else {
            System.out.println("Invalid mode selection for Light!");
        }
    }
}