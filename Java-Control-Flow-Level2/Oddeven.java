// Create a program to print odd and even numbers between 1 to the number entered by the 
// user. 
// Hint =>  
// a. Get an integer input from the user, assign to a variable number and check for Natural 
// Number 
// b. Using a for loop, iterate from 1 to the number 
// c. In each iteration of the loop, print the number is odd or even number 
import java.util.Scanner;
public class Oddeven {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int number = sc.nextInt();

        if (number < 1) {
            System.out.println("Please enter a natural number (greater than 0).");
            return;
        }

        System.out.println("Odd and Even numbers between 1 and " + number + ":");
        for (int i = 1; i <= number; i++) {
            if (i % 2 == 0) {
                System.out.println(i + " is an even number.");
            } else {
                System.out.println(i + " is an odd number.");
            }
        }
    }

    
}
