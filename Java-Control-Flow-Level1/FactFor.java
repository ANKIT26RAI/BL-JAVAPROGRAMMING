import java.util.Scanner;
public class FactFor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        long factorial = 1;

        System.out.print("Enter a positive integer: ");
        n = sc.nextInt();

        if (n < 0) {
            System.out.println("Factorial is not defined for negative numbers.");
            sc.close();
            return;
        }

        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }

        System.out.println("The factorial of " + n + " is: " + factorial);
        sc.close();
    }
    
}