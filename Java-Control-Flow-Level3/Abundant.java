// Create a program to check if a number is an Abundant Number. 
// Hint =>  
// a. An abundant number is an integer in which the sum of all the divisors of the number is 
// greater than the number itself. For example, 
// Divisor of 12: 1, 2, 3, 4, 6 
// Sum of divisor: 1 + 2 + 3 + 4 + 6 = 16 > 12 
// b. Get an integer input for the number variable. 
// c. Create an integer variable sum with initial value 0. 
// d. Run a for loop from i = 1 to i < number. 
// e. Inside the loop, check if number is divisible by i. 
// f. 
// If true, add i to sum. 
// g. Outside the loop Check if sum is greater than number. 
// h. If the sum is greater than the number, print Abundant Number. Otherwise, print Not an 
// Abundant Number.
import java.util.Scanner;
public class Abundant {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        int sum = 0;

        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                sum += i; // Add the divisor to the sum
            }
        }

        if (sum > number) {
            System.out.println(number + " is an Abundant Number.");
        } else {
            System.out.println(number + " is not an Abundant Number.");
        }

        sc.close();
    }
    
}
