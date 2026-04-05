// Create a program to find the youngest friends among 3 Amar, Akbar, and Anthony based on 
// their ages and the tallest among the friends based on their heights 
// Hint =>  
// a. Take user input for the age and height of the 3 friends and store it in a variable 
// b. Find the smallest of the 3 ages to find the youngest friend and display it 
// c. Find the largest of the 3 heights to find the tallest friend and display it 
import java.util.Scanner;
public class YoungTall {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the age of Amar: ");
        int ageAmar = sc.nextInt();
        System.out.print("Enter the height of Amar (in cm): ");
        int heightAmar = sc.nextInt();

        System.out.print("Enter the age of Akbar: ");
        int ageAkbar = sc.nextInt();
        System.out.print("Enter the height of Akbar (in cm): ");
        int heightAkbar = sc.nextInt();

        System.out.print("Enter the age of Anthony: ");
        int ageAnthony = sc.nextInt();
        System.out.print("Enter the height of Anthony (in cm): ");
        int heightAnthony = sc.nextInt();

        // Find the youngest friend
        if (ageAmar < ageAkbar && ageAmar < ageAnthony) {
            System.out.println("The youngest friend is Amar.");
        } else if (ageAkbar < ageAmar && ageAkbar < ageAnthony) {
            System.out.println("The youngest friend is Akbar.");
        } else if (ageAnthony < ageAmar && ageAnthony < ageAkbar) {
            System.out.println("The youngest friend is Anthony.");
        } else {
            System.out.println("There is a tie for the youngest friend.");
        }

        // Find the tallest friend
        if (heightAmar > heightAkbar && heightAmar > heightAnthony) {
            System.out.println("The tallest friend is Amar.");
        } else if (heightAkbar > heightAmar && heightAkbar > heightAnthony) {
            System.out.println("The tallest friend is Akbar.");
        } else if (heightAnthony > heightAmar && heightAnthony > heightAkbar) {
            System.out.println("The tallest friend is Anthony.");
        } else {
            System.out.println("There is a tie for the tallest friend.");
        }
    }
}