import java.util.Scanner;
public class strlen {
static int strLen(String str){
    int count =0;
    try{
        while(true){
            str.charAt(count);
            count++;
        }
}catch(Exception e){
}
return count; 
}
    public static void main(String[] args) {
     
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String str = sc.nextLine();
        System.out.println("Length of the string by custom: " + strLen(str));
        System.out.println("Length of the string by built-in: " + str.length()  );
    }
}
