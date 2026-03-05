package com.Interface.SmartHomeController.test;
import com.Interface.SmartHomeController.model.*;

import java.util.Scanner;
import java.util.InputMismatchException;

public class SmartHome {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Controllable device = null;

        while (true) {

            try {
                System.out.println("\n==== SMART HOME MENU ====");
                System.out.println("1. Light");
                System.out.println("2. TV");
                System.out.println("3. Fan");
                System.out.println("4. Speaker");
                System.out.println("5. Exit");
                System.out.print("Choose device: ");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        device = new Light();
                        break;
                    case 2:
                        device = new TV();
                        break;
                    case 3:
                        device = new Fan();
                        break;
                    case 4:
                        device = new Speaker();
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice!");
                        continue;
                }

                device.turnOn();
                device.showModes();

                System.out.print("Select mode number: ");
                int modeChoice = scanner.nextInt();

                device.setMode(modeChoice);
                device.turnOff();

            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Enter numbers only.");
                scanner.nextLine();
            }
        }
    }
}