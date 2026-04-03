// Write a program to find the side of the square whose parameter you read from the user
// Hint => Perimeter of the Square is 4 times the side
// I/P => perimeter
// O/P => The length of the side is ___ whose perimeter is ____

import java.util.Scanner;

public class PeriSqua {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter the perimeter of the square in cm: ");
    double perimeter = scanner.nextDouble();
    System.out.println("The length of the side is " + (perimeter / 4) + " cm whose perimeter is " + perimeter + " cm"); 
    scanner.close();
    }
}
