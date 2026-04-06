// Create a program to check if a number taken from the user is a Harshad Number. 
// Hint =>  
// a. A Harshad number is an integer which is divisible by the sum of its digits.  
// For example, 21 which is perfectly divided by 3 (sum of digits: 2 + 1). 
// b. Get an integer input for the number variable. 
// c. Create an integer variable sum with initial value 0. 
// d. Create a while loop to access each digit of the number. 
// e. Inside the loop, add each digit of the number to sum. 
// f. 
// Check if the number is perfectly divisible by the sum. 
// g. If the number is divisible by the sum, print Harshad Number. Otherwise, print Not a 
// Harshad Number. 
import java.util.Scanner;
public class Harshhad {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        int sum = 0;
        int temp = number;

        while (temp != 0) {
            sum += temp % 10; // Add the last digit to sum
            temp /= 10; // Remove the last digit
        }

        if (number % sum == 0) {
            System.out.println(number + " is a Harshad Number.");
        } else {
            System.out.println(number + " is not a Harshad Number.");
        }

        sc.close();
    }
    
}
