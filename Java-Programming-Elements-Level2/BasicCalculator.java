// Write a program to create a basic calculator for addition, subtraction, multiplication, and
// division. The program should ask for two numbers (floating point) and perform all the
// operations
// Hint =>
// a. Create a variable number1 and number2 and take user inputs.
// b. Perform Arithmetic Operations of addition, subtraction, multiplication, and division assign
// the result to a variable, and finally print the result
// I/P => number1, number2
// O/P => The addition, subtraction, multiplication, and division value of 2 numbers ___ and
// ___ is ___, ____, ____, and ___

import java.util.Scanner;

public class BasicCalculator {
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    float number1, number2;
    System.out.println("Enter the first number:");
    number1 = sc.nextFloat();
    System.out.println("Enter the second number:");
    number2 = sc.nextFloat();
    float addition = number1 + number2;
    float subtraction = number1 - number2;
    float multiplication = number1 * number2;
    float division = number1 / number2;
    System.out.println("The addition, subtraction, multiplication, and division value of 2 numbers " + number1 + " and " + number2 + " is " + addition + ", " + subtraction + ", " + multiplication + ", and " + division);
    sc.close();

}    
}
