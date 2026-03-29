package com.Interface.SmartHomeController.model;

public class Fan implements Controllable {

    private boolean isOn = false;
    private final String[] modes = {"Slow", "Medium", "High"};

    @Override
    public void turnOn() {
        isOn = true;
        System.out.println("Fan turned ON");
    }

    @Override
    public void turnOff() {
        isOn = false;
        System.out.println("Fan turned OFF");
    }

    @Override
    public void showModes() {
        System.out.println("Select Fan Speed:");
        for (int i = 0; i < modes.length; i++) {
            System.out.println((i + 1) + ". " + modes[i]);
        }
    }

    @Override
    public void setMode(int choice) {
        if (!isOn) {
            System.out.println("Please turn ON the Fan first.");
            return;
        }

        if (choice >= 1 && choice <= modes.length) {
            System.out.println("Fan speed set to: " + modes[choice - 1]);
        } else {
            System.out.println("Invalid speed selection for Fan!");
        }
    }
}