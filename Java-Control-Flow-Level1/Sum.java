//  Write a program to find the sum of numbers until the user enters 0 
// Hint =>  
// a. Create a variable total of type double initialize to 0.0. Also, create a variable to store the 
// double value the user enters 
// b. Use the while loop to check if the user entered is 0 
// c. If the user entered value is not 0 then inside the while block add user entered value to 
// the total and ask the user to input again 
// d. The loop will continue till the user enters zero and outside the loop display the total value
import java.util.Scanner;
public class Sum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double total = 0.0;
        double value;

        System.out.print("Enter a number (enter 0 to stop): ");
        value = sc.nextDouble();

        while (value != 0) {
            total += value;
            System.out.print("Enter a number (enter 0 to stop): ");
            value = sc.nextDouble();
        }

        System.out.println("The sum of the numbers is: " + total);
        sc.close();
    }
}
