import java.util.Scanner;
public class ShortLong {
    static String[] splitWords(String text){
        int count=0;
        for(int i=0;i<text.length();i++){
            if(text.charAt(i)==' '){
                count++;
            }
        }
        String[] words = new String[count+1];
        int index=0;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<text.length();i++){
            char c = text.charAt(i);
        if (c != ' ') {
            sb.append(c);
        } else {
            words[index++] = sb.toString();
            sb.setLength(0);
        }
    }
    words[index] = sb.toString(); // last word
    return words;
    }

public static int getLength(String str) {
    int length = 0;
    try {
        while (true) {
            str.charAt(length);
            length++;
        }
    } catch (IndexOutOfBoundsException e) {
        // End of string
    }
    return length;
}
public static String[][] wordLengthArray(String[] words) {
    String[][] result = new String[words.length][2];
    for (int i = 0; i < words.length; i++) {
        result[i][0] = words[i];
        result[i][1] = String.valueOf(getLength(words[i]));
    }
    return result;
}
public static int[] findShortestLongest(String[][] wordLengthArray) {
    int minLen = Integer.MAX_VALUE;
    int maxLen = Integer.MIN_VALUE;

    for (int i = 0; i < wordLengthArray.length; i++) {
        int len = Integer.parseInt(wordLengthArray[i][1]);
        if (len < minLen) minLen = len;
        if (len > maxLen) maxLen = len;
    }
    return new int[]{minLen, maxLen};
}


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         System.out.println("Enter a text:");
    String input = sc.nextLine();

    String[] words = splitWords(input);
    String[][] wordLengthArr = wordLengthArray(words);
    int[] result = findShortestLongest(wordLengthArr);

    System.out.println("Words and their lengths:");
    for (int i = 0; i < wordLengthArr.length; i++) {
        System.out.println(wordLengthArr[i][0] + " -> " + wordLengthArr[i][1]);
    }

    System.out.println("Shortest word length: " + result[0]);
    System.out.println("Longest word length: " + result[1]);
    }
}
