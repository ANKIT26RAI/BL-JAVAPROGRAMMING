import java.util.Scanner;

public class ArrayDemo {

    public static void handleException(String[] arr) {
        try {
            System.out.println(arr[arr.length]); // invalid index
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Handled ArrayIndexOutOfBoundsException");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }

        handleException(arr);
    }
}
