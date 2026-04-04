//Rewrite program 8 to do the countdown using the for-loop
import java.util.Scanner;
public class CountFor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int counter = sc.nextInt();

        for (int i = counter; i >= 1; i--) {
            System.out.println(i);
        }

        sc.close();
    }
    
}
