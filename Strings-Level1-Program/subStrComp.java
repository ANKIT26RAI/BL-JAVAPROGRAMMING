import java.util.Scanner;
public class subStrComp {
 static String customSubStr(String s,int start, int end){
    String result ="";
    for(int i=start;i<end;i++){
        result+=s.charAt(i);
    }
    return result;

}
static boolean StrComp(String s1,String s2){
    return s1.equals(s2);
}

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1=sc.next();
        int start= sc.nextInt();
        int end = sc.nextInt();
        String s1 = customSubStr(str1, start, end);
        String s2 = str1.substring(start,end);
        System.out.println("Custom : "+ s1);
        System.out.println("Inbuit : "+ s2);
        System.out.println("Compare : "+StrComp(s1, s2));
        sc.close();
    }
}
