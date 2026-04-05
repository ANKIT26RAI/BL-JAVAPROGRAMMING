//  Rewrite the program number 12 with the for loop instead of a while loop to find the sum of n 
// Natural Numbers.  
// Hint =>  
// a. Take the user input number and check whether it's a Natural number 
// b. If it's a natural number Compute using formulae as well as compute using for loop 
// c. Compare the two results and print the result 
import java.util.Scanner;
public class NaturalFor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        double sumFor = 0.0;
        double sumFormula;

        System.out.print("Enter a natural number: ");
        n = sc.nextInt();

        if (n < 1) {
            System.out.println("Please enter a natural number (greater than 0).");
            sc.close();
            return;
        }

        // Compute using for loop
        for (int i = 1; i <= n; i++) {
            sumFor += i;
        }

        // Compute using formula
        sumFormula = n * (n + 1) / 2.0;

        // Compare results
        System.out.println("Sum using for loop: " + sumFor);
        System.out.println("Sum using formula: " + sumFormula);

        if (sumFor == sumFormula) {
            System.out.println("Both computations are correct.");
        } else {
            System.out.println("There is a discrepancy in the computations.");
        }

        sc.close();
    }
    
}
