// Write a program to check whether a number is positive, negative, or zero. 
// Hint =>  
// a. Get integer input from the user and store it in the number variable. 
// b. If the number is positive, print positive. 
// c. If the number is negative, print negative. 
// d. If the number is zero, print zero.  
import java.util.Scanner;
public class Posnegzero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        if (number > 0) {
            System.out.println("The number is positive.");
        } else if (number < 0) {
            System.out.println("The number is negative.");
        } else {
            System.out.println("The number is zero.");
        }

        sc.close();
    }
    
}
