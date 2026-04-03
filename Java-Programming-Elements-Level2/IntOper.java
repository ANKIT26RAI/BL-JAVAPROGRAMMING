// 7. Write an IntOperation program by taking a, b, and c as input values and print the
// following integer operations a + b *c, a * b + c, c + a / b, and a % b + c. Please also
// understand the precedence of the operators.
// Hint =>
// a. Create variables a, b, and c of int data type.
// b. Take user input for a, b, and c.
// c. Compute 3 integer operations and assign the result to a variable
// d. Finally, print the result and try to understand operator precedence.
// I/P => fee, discountPrecent
// O/P => The results of Int Operations are ___, ___, and ___

import java.util.Scanner;   
public class IntOper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the value of a: ");
        int a = scanner.nextInt();
        System.out.print("Enter the value of b: ");
        int b = scanner.nextInt();
        System.out.print("Enter the value of c: ");
        int c = scanner.nextInt();
        
        int result1 = a + b * c; // Multiplication has higher precedence than addition
        int result2 = a * b + c; // Multiplication has higher precedence than addition
        int result3 = c + a / b; // Division has higher precedence than addition
        int result4 = a % b + c; // Modulus has higher precedence than addition
        
        System.out.println("The results of Int Operations are " + result1 + ", " + result2 + ", " + result3 + ", and " + result4);
        
        scanner.close();
    }
    
}
