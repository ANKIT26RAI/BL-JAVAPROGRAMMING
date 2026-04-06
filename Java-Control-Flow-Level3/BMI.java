import java.util.Scanner;

public class BMI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== BMI Calculator ===");
        System.out.print("Enter your weight (in kg) : ");
        double weight = sc.nextDouble();
        System.out.print("Enter your height (in cm) : ");
        double heightCm = sc.nextDouble();

        // Convert cm to meters
        double heightM = heightCm / 100;

        // BMI formula
        double bmi = weight / (heightM * heightM);

        // Determine status
        String status;
        if (bmi <= 18.4) {
            status = "Underweight";
        } else if (bmi <= 24.9) {
            status = "Normal";
        } else if (bmi <= 39.9) {
            status = "Overweight";
        } else {
            status = "Obese";
        }

        System.out.println("\n======== RESULT ========");
        System.out.printf("Weight      : %.2f kg%n", weight);
        System.out.printf("Height      : %.2f cm (%.2f m)%n", heightCm, heightM);
        System.out.printf("BMI         : %.2f kg/m²%n", bmi);
        System.out.println("Status      : " + status);
        System.out.println("========================");

        sc.close();
    }
}