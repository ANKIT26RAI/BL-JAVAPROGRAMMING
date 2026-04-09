import java.util.Scanner;
public class vowelConst{
static String checkCharType(char c){
    if(c>='A'&&c<='Z'){
        c = (char)(c+32);
    }
    if(c>='a'&&c<='z'){
        if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'){
            return "Vowel";
        }else{
            return "Consonant";
        }
    }else{
        return "Not a Letter";
    }
}
static int[] countVowelConsonant(String text){
    int vowels=0;
    int consonant =0;
    for(int i=0;i<text.length();i++){
        char c = text.charAt(i);
        String type = checkCharType(c);
        if(type.equals("Vowel")){
            vowels++;
        }else if(type.equals("Consonant")){
            consonant++;
        }
    }
    return new int[]{vowels,consonant};
}
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String input = sc.nextLine();
    int[] result = countVowelConsonant(input);
    System.out.println("Vowels Count : "+ result[0]);
    System.out.println("Consonant Count :"+ result[1]);
    sc.close();

}
}
