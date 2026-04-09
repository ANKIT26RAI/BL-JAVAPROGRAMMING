import java.util.Scanner;
  public class Trim {
     static int[] trimSpaces(String text){
        int start=0;
        int end = text.length()-1;
        while(start<text.length()&&text.charAt(start)==' '){
            start++;
        }
        while(end>=0&&text.charAt(end)==' '){
            end--;
        }
        return new int[]{start,end};
    }
     static String customSubString(String text,int start,int end){
        StringBuilder sb = new StringBuilder();
        for(int i=start;i<=end;i++){
            sb.append(text.charAt(i));
        }
        return sb.toString();
    }
     static boolean compareStrings(String s1, String s2) {
    if (s1.length() != s2.length()) {
        return false;
    }
    for (int i = 0; i < s1.length(); i++) {
        if (s1.charAt(i) != s2.charAt(i)) {
            return false;
        }
    }
    return true;
}

  
        public static void main(String[] args) {
            
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string with spaces:");
        String input = sc.nextLine();

        // Step a: Trim using charAt
        int[] indices = trimSpaces(input);
        String manualTrim = customSubString(input, indices[0], indices[1]);

        // Step d: Compare with built-in trim()
        String builtInTrim = input.trim();
        boolean isSame = compareStrings(manualTrim, builtInTrim);
        System.out.println("Original String: [" + input + "]");
        System.out.println("Manually Trimmed String: [" + manualTrim + "]");
        System.out.println("Built-in Trim String: [" + builtInTrim + "]");
        System.out.println("Are both results same? " + isSame);
}}
