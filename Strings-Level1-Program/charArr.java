import java.util.Scanner;
public class charArr {
    static char[] customToCharArray(String str){
        char[] arr = new char[str.length()];
        for(int i=0;i<str.length();i++){
            arr[i]=str.charAt(i);
        }
        return arr;
    }
    static boolean compare(char[] a, char[] b){
        if(a.length!=b.length) return false;
        for(int i=0;i<a.length;i++){
            if(a[i]!=b[i]) return false;
        }

        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string :");
        String next = sc.next();
        char[] arr1 = customToCharArray(next);
        char[] arr2= next.toCharArray();

        System.out.println("Equals :" + compare(arr1, arr2));

    }
}
