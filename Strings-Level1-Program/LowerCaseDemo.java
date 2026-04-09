import java.util.Scanner;

public class LowerCaseDemo {

    public static String toLowerCustom(String str) {
        String result = "";

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch >= 'A' && ch <= 'Z') {
                ch = (char)(ch + 32);
            }
            result += ch;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine();

        String s1 = toLowerCustom(text);
        String s2 = text.toLowerCase();

        System.out.println(s1.equals(s2));
    }
}