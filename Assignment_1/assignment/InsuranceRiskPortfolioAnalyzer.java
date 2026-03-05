
public class InsuranceRiskPortfolioAnalyzer {

	public static void main(String[] args) {

        int[] ages = {22, 35, 65, 19, 70};
        int[] riskScores = {75, 90, 60, 88, 95};

        int n = ages.length;

        int highRiskYouthCount = 0;
        int seniorRiskCount = 0;
        int veryHighRiskCount = 0;
        int normalRiskCount = 0;

        int sumRiskScore = 0;
        int maxRiskIndex = 0;

        for (int i = 0; i < n; i++) {

            sumRiskScore += riskScores[i];

            if (riskScores[i] > riskScores[maxRiskIndex]) {
                maxRiskIndex = i;
            }

            
            if (ages[i] < 25 && riskScores[i] > 70) {
                System.out.println("Customer " + i + ": High Risk Youth");
                highRiskYouthCount++;

            } else if (riskScores[i] >= 85) {
                System.out.println("Customer " + i + ": Very High Risk");
                veryHighRiskCount++;

            } else if (ages[i] >= 60) {
                System.out.println("Customer " + i + ": Senior Risk");
                seniorRiskCount++;

            } else {
                System.out.println("Customer " + i + ": Normal Risk");
                normalRiskCount++;
            }
        }

        double averageRisk = (double) sumRiskScore / n;

        System.out.println("\n--- Summary ---");
        System.out.println("High Risk Youth: " + highRiskYouthCount);
        System.out.println("Very High Risk: " + veryHighRiskCount);
        System.out.println("Senior Risk: " + seniorRiskCount);
        System.out.println("Normal Risk: " + normalRiskCount);

        System.out.println("Average Risk Score: " + averageRisk);
        System.out.println("Highest Risk Customer Index: " + maxRiskIndex);
    }

}
