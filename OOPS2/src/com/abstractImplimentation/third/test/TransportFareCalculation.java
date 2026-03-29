package com.abstractImplimentation.third.test;
import com.abstractImplimentation.third.model.*;
import java.util.Scanner;

public class TransportFareCalculation {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Transport[] transports = new Transport[5];
        int count = 0;

        while (count < transports.length) {

            String routeId;
            double baseFare;

            while (true) {

                System.out.print("Enter Route ID (R101 format): ");
                routeId = sc.nextLine().trim();

                if (routeId.matches("[Rr]\\d{3}")) {
                    break;
                } else {
                    System.out.println("Invalid Route ID.");
                }
            }

            while (true) {

                System.out.print("Enter Base Fare: ");
                String input = sc.nextLine();

                if (input.matches("\\d+(\\.\\d+)?")) {
                    baseFare = Double.parseDouble(input);
                    break;
                } else {
                    System.out.println("Invalid Fare.");
                }
            }

            int choice;

            while (true) {

                System.out.println("\nSelect Transport Type");
                System.out.println("1 Bus");
                System.out.println("2 Metro");
                System.out.println("3 Taxi");

                String input = sc.nextLine();

                if (input.matches("[123]")) {
                    choice = Integer.parseInt(input);
                    break;
                } else {
                    System.out.println("Invalid choice.");
                }
            }

            if (choice == 1) {

                double distance;

                while (true) {

                    System.out.print("Enter Distance (km): ");
                    String input = sc.nextLine();

                    if (input.matches("\\d+(\\.\\d+)?")) {
                        distance = Double.parseDouble(input);
                        break;
                    } else {
                        System.out.println("Invalid distance.");
                    }
                }

                transports[count] = new Bus(routeId, baseFare, distance);
            }

            else if (choice == 2) {

                int stations;

                while (true) {

                    System.out.print("Enter Number of Stations: ");
                    String input = sc.nextLine();

                    if (input.matches("\\d+")) {
                        stations = Integer.parseInt(input);
                        break;
                    } else {
                        System.out.println("Invalid stations.");
                    }
                }

                transports[count] = new Metro(routeId, baseFare, stations);
            }

            else {

                double distance;
                int time;

                while (true) {

                    System.out.print("Enter Distance (km): ");
                    String input = sc.nextLine();

                    if (input.matches("\\d+(\\.\\d+)?")) {
                        distance = Double.parseDouble(input);
                        break;
                    } else {
                        System.out.println("Invalid distance.");
                    }
                }

                while (true) {

                    System.out.print("Enter Time (minutes): ");
                    String input = sc.nextLine();

                    if (input.matches("\\d+")) {
                        time = Integer.parseInt(input);
                        break;
                    } else {
                        System.out.println("Invalid time.");
                    }
                }

                transports[count] = new Taxi(routeId, baseFare, distance, time);
            }

            count++;

            System.out.print("Add another transport? (yes/no): ");
            String option = sc.nextLine();

            if (!option.equalsIgnoreCase("yes")) {
                break;
            }
        }

        System.out.println("\n----- Fare Calculation -----");

        for (int i = 0; i < count; i++) {

            double fare = transports[i].calculateFare();
            transports[i].printTicket(fare);
        }

        sc.close();
    }
}