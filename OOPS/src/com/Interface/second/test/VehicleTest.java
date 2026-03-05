package com.Interface.second.test;
import java.util.Scanner;
import com.Interface.second.model.*;

public class VehicleTest {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int count;
        String input;

        // Validate number of vehicles
        while (true) {
            System.out.print("Enter number of vehicles: ");
            input = scanner.nextLine().trim();

            if (input.matches("[1-9]\\d*")) {
                count = Integer.parseInt(input);
                break;
            }
            System.out.println("Invalid input! Enter positive number.");
        }

        Vehicle[] vehicles = new Vehicle[count];

        for (int i = 0; i < count; i++) {

            System.out.println("\nSelect Vehicle Type:");
            System.out.println("1. Car");
            System.out.println("2. Bike");

            int choice;

            while (true) {
                input = scanner.nextLine().trim();

                if (input.matches("[12]")) {
                    choice = Integer.parseInt(input);
                    break;
                }
                System.out.println("Invalid choice! Enter 1 or 2.");
            }

            if (choice == 1) {

                String fuel;

                while (true) {
                    System.out.println("Select Fuel Type:");
                    System.out.println("1. Diesel");
                    System.out.println("2. Petrol");

                    input = scanner.nextLine().trim();

                    if (input.equals("1")) {
                        fuel = "Diesel";
                        break;
                    } else if (input.equals("2")) {
                        fuel = "Petrol";
                        break;
                    } else {
                        System.out.println("Invalid fuel choice!");
                    }
                }

                vehicles[i] = new Car(fuel);

            } else {
                vehicles[i] = new Bike();
            }
        }

        System.out.println("\n=== Vehicle Details ===");

        for (Vehicle v : vehicles) {

            v.start();   
            System.out.println("Fuel Type: " + v.fuelType());
            v.stop();

            System.out.println("---------------------");
        }

        scanner.close();
    }
}