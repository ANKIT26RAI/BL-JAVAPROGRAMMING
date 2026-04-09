import java.util.Scanner;
public class UpperCase {

static String toUpperCase(String str){
    String result="";
    for(int i=0;i<str.length();i++){
        char ch = str.charAt(i);

        if(ch>='a'&&ch<='z'){
            ch = (char)(ch-32);
        }
        result+=ch;
    }
    return result;
}
static boolean Compare(String s1,String s2){
    return s1.equals(s2);
}
    public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     String text = sc.next();
     String str2= toUpperCase(text);
     System.out.println("UpperCase :"+ str2);
     System.out.println("Equals :"+ Compare(text, str2));
    }
    
}
