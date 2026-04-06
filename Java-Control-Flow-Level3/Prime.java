// Write a Program to check if the given number is a prime number or not 
// Hint =>  
// a. A number that can be divided exactly only by itself and 1 are Prime Numbers, 
// b. Prime Numbers checks are done for numbers greater than 1 
// c. Loop through all the numbers from 2 to the user input number and check if the reminder 
// is zero. If the reminder is zero break out from the loop as the number is divisible by some 
// other number and is not a prime number.  
// d. Use the isPrime boolean variable to store the result
import java.util.Scanner;   
public class Prime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num = sc.nextInt();
        boolean isPrime = true;

        if (num <= 1) {
            isPrime = false; // Numbers less than or equal to 1 are not prime
        } else {
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    isPrime = false; // Found a divisor, not a prime number
                    break;
                }
            }
        }

        if (isPrime) {
            System.out.println(num + " is a prime number.");
        } else {
            System.out.println(num + " is not a prime number.");
        }

        sc.close();
    }
    
}
