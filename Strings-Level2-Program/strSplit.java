import java.util.Scanner;

public class strSplit {

    // Method to find length of String without using length()
    public static int findLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (IndexOutOfBoundsException e) {
            // End of string reached
        }
        return count;
    }

    // Method to split text into words manually
    public static String[] customSplit(String text) {
        int len = findLength(text);

        // Step 1: Count words
        int wordCount = 1; // at least one word
        for (int i = 0; i < len; i++) {
            if (text.charAt(i) == ' ') {
                wordCount++;
            }
        }

        // Step 2: Store indexes of spaces
        int[] spaceIndexes = new int[wordCount - 1];
        int idx = 0;
        for (int i = 0; i < len; i++) {
            if (text.charAt(i) == ' ') {
                spaceIndexes[idx++] = i;
            }
        }

        // Step 3: Extract words
        String[] words = new String[wordCount];
        int start = 0;
        for (int i = 0; i < wordCount - 1; i++) {
            int end = spaceIndexes[i];
            words[i] = text.substring(start, end);
            start = end + 1;
        }
        // Last word
        words[wordCount - 1] = text.substring(start, len);

        return words;
    }

    // Method to compare two string arrays
    public static boolean compareArrays(String[] arr1, String[] arr2) {
        if (arr1.length != arr2.length) return false;
        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // a. Take user input
        System.out.println("Enter a line of text:");
        String input = sc.nextLine();

        // b & c. Custom split
        String[] customWords = customSplit(input);

        // Built-in split
        String[] builtInWords = input.split(" ");

        // d. Compare arrays
        boolean isSame = compareArrays(customWords, builtInWords);

        // e. Display results
        System.out.println("\nCustom Split Result:");
        for (String word : customWords) {
            System.out.println(word);
        }

        System.out.println("\nBuilt-in Split Result:");
        for (String word : builtInWords) {
            System.out.println(word);
        }

        System.out.println("\nComparison Result: " + (isSame ? "Arrays are identical" : "Arrays differ"));
    }
}
