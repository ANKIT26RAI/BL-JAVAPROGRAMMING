import java.util.Scanner;
public class vowelConst2D{
    static String checkCharType(char c){
        if(c>='A'&&c<='Z'){
            c = (char)(c+32);
        }
    if(c>='a'&&c<='z'){
        if(c=='a'||c=='e'||c=='o'||c=='i'||c=='u'){
            return "Vowel";

        }else{
            return "Consonant";
        }
    }else{
        return "Not A letter";
    }
    }

    static String[][] analyzeString(String text){
        String[][] result = new String[text.length()][2];
        for(int i=0;i<text.length();i++){
            char c =text.charAt(i);
            result[i][0]= String.valueOf(c);
            result[i][1]=checkCharType(c);
        }
        return result; 
    }
public static void displayTable(String[][] arr) {
    System.out.println("Character\tType");
    System.out.println("-------------------------");
    for (int i = 0; i < arr.length; i++) {
        System.out.println(arr[i][0] + "\t\t" + arr[i][1]);
    }
}
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string:");
        String input = sc.nextLine();

        String[][] result = analyzeString(input);

        displayTable(result);
    }
}