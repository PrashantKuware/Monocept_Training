import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.arrayofObject.third.model.Car;
import com.arrayofObject.third.model.Motorcycle;
import com.arrayofObject.third.model.Truck;
import com.arrayofObject.third.model.Vehicle;

public class TollManagementSystem {

    public static void main(String[] args) 
    {

        Scanner scanner = new Scanner(System.in);
        List<Vehicle> vehicleList = new ArrayList<>();
        String choice;

        do {
            System.out.println("Select Vehicle Type:");
            System.out.println("1. Car");
            System.out.println("2. Truck");
            System.out.println("3. Motorcycle");

            int type = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            System.out.print("Enter Vehicle Number: ");
            String number = scanner.nextLine();  // no need of while loop

            Vehicle vehicle = null;

            switch (type) {

                case 1:
                    vehicle = new Car(number);
                    break;

                case 2:
                    System.out.print("Enter Number of Axles: ");
                    int axles = scanner.nextInt();
                    scanner.nextLine(); // clear buffer
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

            System.out.print("Add another vehicle? (yes/no): ");
            choice = scanner.nextLine();

        } while (choice.equalsIgnoreCase("yes"));

        // Convert List to Array
        Vehicle[] vehicles = vehicleList.toArray(new Vehicle[0]);

        System.out.println("---- Toll Details ----");

        for (Vehicle v : vehicles) {
            v.processVehicle();
        }

        Vehicle.displayTotals();

        scanner.close();
    }
}