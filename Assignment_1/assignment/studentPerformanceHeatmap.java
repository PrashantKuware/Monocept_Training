
public class studentPerformanceHeatmap {

	public static void main(String[] args) {

        int[][] marks = {
            {90, 85, 88, 92, 80},
            {70, 75, 65, 60, 72},
            {40, 55, 58, 52, 50},
            {30, 80, 75, 85, 90},
            {95, 92, 89, 94, 96}
        };

        int n = marks.length;
        int distinctionCount = 0;
        int[] subjectSum = new int[5];

        for (int i = 0; i < n; i++) {

            boolean isFail = false;
            int total = 0;

            for (int j = 0; j < 5; j++) {

                if (marks[i][j] < 35) {
                    isFail = true;
                }

                total += marks[i][j];
                subjectSum[j] += marks[i][j];
            }

            double average = total / 5.0;

            System.out.print("Student " + i + ": ");

            if (isFail) {
                System.out.println("Fail");
            } else if (average >= 85) {
                System.out.println("Distinction");
                distinctionCount++;
            } else if (average >= 60) {
                System.out.println("First Class");
            } else if (average >= 50) {
                System.out.println("Second Class");
            } else {
                System.out.println("Pass");
            }
        }

        System.out.println("\nTotal Distinctions: " + distinctionCount);

        double highestAverage = 0;
        int highestSubjectIndex = 0;

        for (int j = 0; j < 5; j++) {
            double subjectAverage = subjectSum[j] / (double) n;

            if (subjectAverage > highestAverage) {
                highestAverage = subjectAverage;
                highestSubjectIndex = j;
            }
        }

        System.out.println("Subject with Highest Overall Average: Subject "
                + highestSubjectIndex + " (Average = " + highestAverage + ")");
    }
}
