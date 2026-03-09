
import java.util.ArrayList;

public class fraudTransactionDetector {

	public static void main(String[] args) {

        double[] transactions = {
            30000, 52000, 60000, 45000,
            70000, 80000, 20000, 55000
        };

        double sum = 0;
        int consecutiveSuspicious = 0;
        boolean fraudDetected = false;

        ArrayList<Integer> suspiciousIndices = new ArrayList<>();

        for (int i = 0; i < transactions.length; i++) {

            sum += transactions[i];

            if (transactions[i] > 50000) {

                System.out.println("Transaction at index " + i + " is Suspicious");

                suspiciousIndices.add(i);
                consecutiveSuspicious++;

                if (consecutiveSuspicious >= 2) {
                    fraudDetected = true;
                }

            } else {
                consecutiveSuspicious = 0;
            }
        }

        double average = sum / transactions.length;

        System.out.println("\nSuspicious Transaction Indices: " + suspiciousIndices);
        System.out.println("Average Transaction Value: " + average);

        if (fraudDetected) {
            System.out.println("Potential Fraud Detected!");
        } else {
            System.out.println("No Fraud Pattern Found.");
        }

        if (average > 40000) {
            System.out.println("High Value Account");
        } else {
            System.out.println("Normal Account");
        }
    }

}
