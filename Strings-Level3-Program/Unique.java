import java.util.Scanner;
public class Unique {
static int length(String str){
    int count =0;
    try {
        while (true) {
            str.charAt(count);
            count++;
            
        }
    } catch (Exception e) {
        // TODO: handle exception
    }
    return count;
}
 static String[] unique(String str){
    
    String[] Unique = new String[length(str)];
    int n= length(str);
    int index = 0;
        for(int i=0;i<n-1;i++){
        boolean isUnique=true;
        for(int j=i+1;j<n;j++){
            if(str.charAt(i)==str.charAt(j)){
                isUnique = false;
                break;
            }       
        }
        if(isUnique){
            Unique[index]=String.valueOf(str.charAt(i));
            index++;
        }
    }
    return Unique;
 }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string:");
        String str = sc.nextLine();
        String[] uniqueChars = unique(str);
        System.out.println("Unique characters in the string:"); 
        for (String ch : uniqueChars) {
            if (ch != null) {
                System.out.print(ch + " ");
            }
        }
         sc.close();
    }
}
