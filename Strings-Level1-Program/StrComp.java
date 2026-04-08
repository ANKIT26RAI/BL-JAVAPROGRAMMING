import java.util.Scanner;
public class StrComp {
    static boolean StrCompare(String s1, String s2){
        if(s1.length()!=s1.length()) return false;
        
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i)){
            return false;
        }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String 1 :");
        String s1= sc.nextLine();
        System.out.println("Enter the string 2 :");
        String s2 = sc.nextLine();

        System.out.println("On Comparing Two String we got result : "+ StrCompare(s1, s2));
        sc.close();
    
    }
    
}
