// Rewrite the program 10 to find the sum until the user enters 0 or a negative number using 
// while loop and break statement 
// Hint =>  
// a. Use infinite while loop as in while (true) 
// b. Take the user entry and check if the user entered 0 or a negative number to break the 
// loop using break; 

import java.util.Scanner;
public class SumWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double total = 0.0;
        double value;

        while (true) {
            System.out.print("Enter a number (enter 0 or negative to stop): ");
            value = sc.nextDouble();

            if (value <= 0) {
                break;
            }

            total += value;
        }

        System.out.println("The sum of the numbers is: " + total);
        sc.close();
    }
}