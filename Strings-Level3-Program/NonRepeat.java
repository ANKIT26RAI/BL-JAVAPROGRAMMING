import java.util.Scanner;

public class NonRepeat {

    // Method to find first non-repeating character
    static char firstNonRepeatingChar(String str) {
        int[] freq = new int[256]; // ASCII size

        // Step 1: Count frequency
        for (int i = 0; i < str.length(); i++) {
            freq[str.charAt(i)]++;
        }

        // Step 2: Find first non-repeating character
        for (int i = 0; i < str.length(); i++) {
            if (freq[str.charAt(i)] == 1) {
                return str.charAt(i);
            }
        }

        // If no non-repeating character
        return '\0';
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a string:");
        String str = sc.nextLine();

        char result = firstNonRepeatingChar(str);

        if (result != '\0') {
            System.out.println("First non-repeating character: " + result);
        } else {
            System.out.println("No non-repeating character found.");
        }

        sc.close();
    }
}