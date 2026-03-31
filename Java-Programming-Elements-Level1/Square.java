// Write a program to find the side of the square whose parameter you read from user  
// Hint => Perimeter of Square is 4 times side 
// I/P => perimeter 
// O/P => The length of the side is ___ whose perimeter is ____
import java.util.Scanner;
public class Square {
    public static void main(String[] args) {
        double perimeter;
        Scanner sc = new Scanner(System.in);
        System.out.print("The perimeter of Square is :");
        perimeter = sc.nextDouble();
        double length = perimeter/4;
        System.out.print("The length of the side is " + length + " whose perimeter is " + perimeter);
        sc.close(); 
    }
}
