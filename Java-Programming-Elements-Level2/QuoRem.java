// Write a program to take 2 numbers and print their quotient and reminder
// Hint => Use division operator (/) for quotient and moduli operator (%) for reminder
// I/P => number1, number2
// O/P => The Quotient is ___ and Reminder is ___ of two number ___ and ___
import java.util.Scanner;
public class QuoRem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        double number1 = scanner.nextDouble();
        System.out.print("Enter the second number: ");
        double number2 = scanner.nextDouble();
        double quotient = number1 / number2;
        double remainder = number1 % number2;
        System.out.println("The Quotient is " + quotient + " and Reminder is " + remainder + " of two numbers " + number1 + " and " + number2);
        scanner.close();
    }
    
}
