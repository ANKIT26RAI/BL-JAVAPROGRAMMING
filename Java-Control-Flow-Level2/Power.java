// . Create a program to find the power of a number. 
// Hint =>  
// a. Get integer input for two variables - number and power and check for positive integer 
// b. Create a result variable with an initial value of 1. 
// c. Run a for loop from i = 1 to i <= power. In each iteration of the loop, multiply the result by 
// the number and assign the value to the result. Finally, print the result
import java.util.Scanner;
public class Power {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a positive integer for the base number: ");
        int number = sc.nextInt();
        System.out.print("Enter a positive integer for the power: ");
        int power = sc.nextInt();

        if (number <= 0 || power < 0) {
            System.out.println("Please enter positive integers for both number and power.");
            return;
        }

        int result = 1;
        for (int i = 1; i <= power; i++) {
            result *= number;
        }

        System.out.println(number + " raised to the power of " + power + " is: " + result);
    }
    
}
