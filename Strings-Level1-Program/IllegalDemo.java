import java.util.Scanner;

public class IllegalDemo {

    public static void handleException(String str) {
        try {
            System.out.println(str.substring(5, 2));
        } catch (IllegalArgumentException e) {
            System.out.println("Handled IllegalArgumentException");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        handleException(str);
    }
}