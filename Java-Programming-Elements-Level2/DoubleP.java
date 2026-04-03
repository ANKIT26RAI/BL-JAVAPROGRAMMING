// 8. Write an DoubleOperation program by taking a, b, and c as input values and print the
// following double operations a + b *c, a * b + c, c + a / b, and a % b + c. Please also
// understand the precedence of the operators.
// Hint =>
// a. Create variables a, b, and c of double data type.
// b. Take user input for a, b, and c.
// c. Compute 3 double operations and assign the result to a variable
// d. Finally, print the result and try to understand operator precedence.
// I/P => fee, discountPrecent
// O/P => The results of Double Operations are ___, ___, and ___
import java.util.Scanner;
public class DoubleP {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the value of a: ");
        double a = scanner.nextDouble();
        System.out.print("Enter the value of b: ");
        double b = scanner.nextDouble();
        System.out.print("Enter the value of c: ");
        double c = scanner.nextDouble();
        
        double result1 = a + b * c; // Multiplication has higher precedence than addition
        double result2 = a * b + c; // Multiplication has higher precedence than addition
        double result3 = c + a / b; // Division has higher precedence than addition
        double result4 = a % b + c; // Modulus has higher precedence than addition
        
        System.out.println("The results of Double Operations are " + result1 + ", " + result2 + ", " + result3 + ", and " + result4);
        
        scanner.close();
    }
    
}
