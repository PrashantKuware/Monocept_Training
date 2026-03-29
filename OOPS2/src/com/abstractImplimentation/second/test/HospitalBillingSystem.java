package com.abstractImplimentation.second.test;

import java.util.Scanner;

import com.abstractImplimentation.second.model.*;

public class HospitalBillingSystem {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numberOfPatients;
        String input;

        // Validate number of patients
        while (true) {
            System.out.print("Enter number of patients: ");
            input = scanner.nextLine().trim();

            if (input.matches("[1-9]\\d*")) {
                numberOfPatients = Integer.parseInt(input);
                break;
            }
            System.out.println("Invalid input. Enter number greater than 0.");
        }

        Patient[] patients = new Patient[numberOfPatients];

        for (int i = 0; i < numberOfPatients; i++) {

            System.out.println("\nEnter details for Patient " + (i + 1));

            // Patient ID
            int id;
            while (true) 
            {
                System.out.print("Enter Patient ID: ");
                input = scanner.nextLine().trim();

                if (input.matches("[1-9]\\d*")) {
                    id = Integer.parseInt(input);
                    break;
                }
                System.out.println("Invalid ID. Enter positive number.");
            }

            // Patient Name
            System.out.print("Enter Patient Name: ");
            String name = scanner.nextLine().trim();

            // Choose Patient Type
            int choice;
            while (true) {
                System.out.println("\nSelect Patient Type:");
                System.out.println("1. InPatient");
                System.out.println("2. OutPatient");
                System.out.println("3. EmergencyPatient");

                input = scanner.nextLine().trim();

                if (input.matches("[123]")) {
                    choice = Integer.parseInt(input);
                    break;
                }
                System.out.println("Invalid choice. Enter 1, 2 or 3.");
            }

            // Charge input
            double charge;
            while (true) 
            {
                System.out.print("Enter charge amount: ");
                input = scanner.nextLine().trim();

                if (input.matches("\\d+(\\.\\d+)?") &&
                        Double.parseDouble(input) > 0) 
                {
                    charge = Double.parseDouble(input);
                    break;
                }
                System.out.println("Invalid amount. Enter value greater than 0.");
            }

            switch (choice) {

                case 1:
                    patients[i] = new InPatient(id, name, charge);
                    break;

                case 2:
                    patients[i] = new OutPatient(id, name, charge);
                    break;

                case 3:
                    patients[i] = new EmergencyPatient(id, name, charge);
                    break;

                default:
                    patients[i] = new OutPatient(id, name, charge);
            }
        }

        System.out.println("\n======= Generating Bills =======");

        for (Patient patient : patients) {
            patient.generateBill();   
        }

        scanner.close();
    }
}