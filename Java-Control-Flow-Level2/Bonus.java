// Create a program to find the bonuses of employees based on their years of service. 
// Hint =>  
// a. Zara decided to give a bonus of 5% to employees whose year of service is more than 5 
// years. 
// b. Take salary and year of service in the year as input. 
// c. Print the bonus amount.
import java.util.Scanner;
public class Bonus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the employee's salary: ");
        double salary = sc.nextDouble();

        System.out.print("Enter the employee's years of service: ");
        int yearsOfService = sc.nextInt();

        if (yearsOfService > 5) {
            double bonus = salary * 0.05;
            System.out.println("The bonus amount is: " + bonus);
        } else {
            System.out.println("No bonus for employees with 5 or fewer years of service.");
        }
    }
}
