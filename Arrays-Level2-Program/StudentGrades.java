import java.util.Scanner;

public class StudentGrades {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        double[][] marks = new double[n][3]; // [i][0]=Physics, [i][1]=Chemistry, [i][2]=Maths
        double[] percentage = new double[n];
        char[] grade = new char[n];

        // Input marks with validation
        for (int i = 0; i < n; i++) {
            System.out.println("\nStudent " + (i + 1));

            for (int j = 0; j < 3; j++) {
                String subject = (j == 0) ? "Physics" : (j == 1) ? "Chemistry" : "Maths";

                do {
                    System.out.print("Enter marks for " + subject + ": ");
                    marks[i][j] = sc.nextDouble();

                    if (marks[i][j] < 0) {
                        System.out.println("Marks cannot be negative. Enter again.");
                    }
                } while (marks[i][j] < 0);
            }
        }

        // Calculate percentage and grade
        for (int i = 0; i < n; i++) {
            double total = marks[i][0] + marks[i][1] + marks[i][2];
            percentage[i] = total / 3.0;

            if (percentage[i] >= 80)
                grade[i] = 'A';
            else if (percentage[i] >= 70)
                grade[i] = 'B';
            else if (percentage[i] >= 60)
                grade[i] = 'C';
            else if (percentage[i] >= 50)
                grade[i] = 'D';
            else if (percentage[i] >= 40)
                grade[i] = 'E';
            else
                grade[i] = 'R';
        }

        // Display results
        System.out.println("\n--- Student Report ---");
        for (int i = 0; i < n; i++) {
            System.out.println("\nStudent " + (i + 1));
            System.out.printf("Physics: %.2f\n", marks[i][0]);
            System.out.printf("Chemistry: %.2f\n", marks[i][1]);
            System.out.printf("Maths: %.2f\n", marks[i][2]);
            System.out.printf("Percentage: %.2f%%\n", percentage[i]);
            System.out.println("Grade: " + grade[i]);
        }

        sc.close();
    }
}