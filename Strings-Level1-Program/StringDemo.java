import java.util.Scanner;

public class StringDemo {

    public static void handleException(String str) {
        try {
            System.out.println(str.charAt(str.length())); // invalid index
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Handled Exception");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        handleException(str);
    }
}