package com.Interface.SmartHomeController.model;

public class Speaker implements Controllable {

    private boolean isOn = false;
    private final String[] modes = {"Rock", "Bass", "Auto", "Jazz"};

    @Override
    public void turnOn() {
        isOn = true;
        System.out.println("Speaker turned ON");
    }

    @Override
    public void turnOff() {
        isOn = false;
        System.out.println("Speaker turned OFF");
    }

    @Override
    public void showModes() {
        System.out.println("Select Speaker Mode:");
        for (int i = 0; i < modes.length; i++) {
            System.out.println((i + 1) + ". " + modes[i]);
        }
    }

    @Override
    public void setMode(int choice) {
        if (!isOn) {
            System.out.println("Please turn ON the Speaker first.");
            return;
        }

        if (choice >= 1 && choice <= modes.length) {
            System.out.println("Speaker mode set to: " + modes[choice - 1]);
        } else {
            System.out.println("Invalid mode selection for Speaker!");
        }
    }
}