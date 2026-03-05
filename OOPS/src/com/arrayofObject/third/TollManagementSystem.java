package com.arrayofObject.third;
import com.arrayofObject.third.model.*;
import java.util.*;

public class TollManagementSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Vehicle> vehicleList = new ArrayList<>();
        String choice;

        do {
            System.out.println("\nSelect Vehicle Type:");
            System.out.println("1. Car");
            System.out.println("2. Truck");
            System.out.println("3. Motorcycle");

            int type = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Vehicle Number: ");
            String number = sc.nextLine();

            Vehicle vehicle = null;

            switch (type) {
                case 1:
                    vehicle = new Car(number);
                    break;

                case 2:
                    System.out.print("Enter Number of Axles: ");
                    int axles = sc.nextInt();
                    vehicle = new Truck(number, axles);
                    break;

                case 3:
                    vehicle = new Motorcycle(number);
                    break;

                default:
                    System.out.println("Invalid vehicle type!");
            }

            if (vehicle != null) {
                vehicleList.add(vehicle);
            }

            sc.nextLine();
            System.out.print("Add another vehicle? (yes/no): ");
            choice = sc.nextLine();

        } while (choice.equalsIgnoreCase("yes"));

        // Convert List to Array
        Vehicle[] vehicles = vehicleList.toArray(new Vehicle[0]);

        System.out.println("\n---- Toll Details ----");

        for (Vehicle v : vehicles) {
            v.processVehicle();   // Polymorphism
        }

        Vehicle.displayTotals();

        sc.close();
    }
}