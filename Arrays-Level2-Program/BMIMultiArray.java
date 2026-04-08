import java.util.Scanner;

public class BMIMultiArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of persons: ");
        int number = sc.nextInt();

        double[][] personData = new double[number][3];
        String[] weightStatus = new String[number];

        for (int i = 0; i < number; i++) {
            System.out.println("\nPerson " + (i + 1));

            // Height (in meters)
            do {
                System.out.print("Enter height (in meters): ");
                personData[i][0] = sc.nextDouble();
            } while (personData[i][0] <= 0);

            // Weight
            do {
                System.out.print("Enter weight (in kg): ");
                personData[i][1] = sc.nextDouble();
            } while (personData[i][1] <= 0);
        }

        // BMI calculation
        for (int i = 0; i < number; i++) {
            double h = personData[i][0];
            double w = personData[i][1];

            personData[i][2] = w / (h * h); // ✔ correct formula

            if (personData[i][2] <= 18.4)
                weightStatus[i] = "Underweight";
            else if (personData[i][2] <= 24.9)
                weightStatus[i] = "Normal";
            else if (personData[i][2] <= 39.9)
                weightStatus[i] = "Overweight";
            else
                weightStatus[i] = "Obese";
        }

        // Output
        System.out.println("\n--- BMI Report ---");
        for (int i = 0; i < number; i++) {
            System.out.printf("\nPerson %d\n", i + 1);
            System.out.printf("Height: %.2f m\n", personData[i][0]);
            System.out.printf("Weight: %.2f kg\n", personData[i][1]);
            System.out.printf("BMI: %.2f\n", personData[i][2]);
            System.out.println("Status: " + weightStatus[i]);
        }

        sc.close();
    }
}