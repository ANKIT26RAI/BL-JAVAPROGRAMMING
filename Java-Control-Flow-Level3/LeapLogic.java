// Rewrite program 1 to determine Leap Year with single if condition using logical and && and 
// or || operator
import java.util.Scanner;   
public class LeapLogic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the year: ");
        int year = sc.nextInt();
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            System.out.println(year + " is a leap year.");
        } else {
            System.out.println(year + " is not a leap year.");
    }
    }
}
