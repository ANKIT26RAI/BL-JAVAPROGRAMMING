//  Write a program to find the sum of n natural numbers using while loop compare the result 
// with the formulae n*(n+1)/2 and show the result from both computations was correct.  
// Hint =>  
// a. Take the user input number and check whether it's a Natural number 
// b. If it's a natural number Compute using formulae as well as compute using while loop 
// c. Compare the two results and print the result 
import java.util.Scanner;
public class Sum2While {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        double sumWhile = 0.0;
        double sumFormula;

        System.out.print("Enter a natural number: ");
        n = sc.nextInt();

        if (n < 1) {
            System.out.println("Please enter a natural number (greater than 0).");
            sc.close();
            return;
        }

        // Compute using while loop
        int i = 1;
        while (i <= n) {
            sumWhile += i;
            i++;
        }

        // Compute using formula
        sumFormula = n * (n + 1) / 2.0;

        // Compare results
        System.out.println("Sum using while loop: " + sumWhile);
        System.out.println("Sum using formula: " + sumFormula);

        if (sumWhile == sumFormula) {
            System.out.println("Both computations are correct.");
        } else {
            System.out.println("There is a discrepancy in the computations.");
        }

        sc.close();
    }
    
}
