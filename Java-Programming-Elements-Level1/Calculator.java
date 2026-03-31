// 11. Write a program to create a basic calculator that can perform addition, subtraction, 
// multiplication, and division. The program should ask for two numbers (floating point) and 
// perform all the operations 
// Hint =>  
// a. Create a variable number1 and number 2 and take user inputs. 
// b. Perform Arithmetic Operations of addition, subtraction, multiplication and division and 
// assign the result to a variable and finally print the result 
// I/P => number1, number2 
// O/P => The addition, subtraction, multiplication and division value of 2 numbers ___ and ___ 
// is ___, ____, ____, and ___
import java.util.Scanner;
public class Calculator {
    public static void main(String[] args) {
        double number1, number2;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        double num1 = sc.nextDouble();
        System.out.print("Enter the second number: ");
        double num2 = sc.nextDouble();
        double addition = num1 + num2;
        double subtraction = num1 - num2;
        double multiplication = num1 * num2;
        double division = num1 / num2;
        System.out.println("The addition, subtraction, multiplication and division value of 2 numbers " + num1 + " and " + num2 + " is " + addition + ", " + subtraction + ", " + multiplication + ", and " + division);
        sc.close();

    }
    
}
