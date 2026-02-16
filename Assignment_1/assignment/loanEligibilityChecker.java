
public class loanEligibilityChecker {

	public static void main(String[] args) {

        int[] creditScores = {750, 820, 580, 900, 610};
        int[] monthlyIncomes = {50000, 150000, 40000, 200000, 26000};
        int[] existingLoans = {1, 0, 2, 1, 3};

        int n = creditScores.length;

        int approvalCount = 0;
        int rejectionCount = 0;

        int bestApplicantIndex = -1;
        int highestCreditScore = 0;

        for (int i = 0; i < n; i++) {

            System.out.print("Applicant " + i + ": ");

            // Rejection Conditions
            if (creditScores[i] < 600 ||
                monthlyIncomes[i] < 25000 ||
                existingLoans[i] >= 3) {

                System.out.println("Rejected");
                rejectionCount++;

            } else {

                approvalCount++;

                // Instant Approval
                if (creditScores[i] >= 800 &&
                    monthlyIncomes[i] > 100000) {

                    System.out.println("Instant Approval");

                } else {
                    System.out.println("Standard Review");
                }

                // Track Best Applicant (highest credit score)
                if (creditScores[i] > highestCreditScore) {
                    highestCreditScore = creditScores[i];
                    bestApplicantIndex = i;
                }
            }
        }

        System.out.println("\n--- Summary ---");
        System.out.println("Total Approvals: " + approvalCount);
        System.out.println("Total Rejections: " + rejectionCount);

        if (bestApplicantIndex != -1) {
            System.out.println("Best Approval Profile Applicant Index: " + bestApplicantIndex);
        } else {
            System.out.println("No approved applicants.");
        }
    }

}
