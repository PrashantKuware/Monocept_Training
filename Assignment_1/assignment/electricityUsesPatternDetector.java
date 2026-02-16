
public class electricityUsesPatternDetector {

	public static void main(String[] args) {

        int[] usage = {
            450, 520, 610, 700, 300, 80, 90, 550, 560, 570,
            200, 150, 620, 630, 640, 100, 120, 510, 520, 530,
            480, 490, 95, 85, 600, 610, 620, 400, 410, 420
        };

        int highCount = 0;
        int sum = 0;
        int consecutiveHigh = 0;
        boolean overloadDetected = false;

        for (int i = 0; i < usage.length; i++) {

            sum += usage[i];

            System.out.print("Day " + (i + 1) + ": ");

            if (usage[i] > 500) {
                System.out.println("High Consumption");
                highCount++;
                consecutiveHigh++;

                if (consecutiveHigh >= 3) {
                    overloadDetected = true;
                }

            } else if (usage[i] < 100) {
                System.out.println("Low Usage Alert");
                consecutiveHigh = 0;

            } else {
                System.out.println("Normal Usage");
                consecutiveHigh = 0;
            }
        }

        double average = (double) sum / usage.length;

        System.out.println("\n--- Monthly Summary ---");
        System.out.println("Total High Consumption Days: " + highCount);
        System.out.println("Monthly Average Usage: " + average);

        if (overloadDetected) {
            System.out.println("Overload Warning Detected!");
        } else {
            System.out.println("No Overload Warning.");
        }

        if (average > 400) {
            System.out.println("Heavy Month");
        } else {
            System.out.println("Normal Month");
        }
    }

}
