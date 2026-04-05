// . Rewrite the above program to find the power of a number using a while loop. 
// Hint =>  
// a. Get integer input for two variables named number and power. 
// b. Create a result variable with an initial value of 1. 
// d. Create a temp variable counter and initialize to zero. Use the while loop till _**counter 
// == power**_. 
// c. In each iteration of the loop, multiply the result by the number and assign the value to 
// the result. Also, increment the counter. 
// d. Finally, print the result
import java.util.Scanner;
public class PowerWhile {
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
        int counter = 0;

        while (counter < power) {
            result *= number;
            counter++;
        }

        System.out.println(number + " raised to the power of " + power + " is: " + result); 
    }

    
}
