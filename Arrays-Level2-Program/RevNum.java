import java.util.Scanner;
public class RevNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number : ");
        long number = sc.nextLong();

        number = Math.abs(number);
        int count =0;
        long temp =number;
        if(temp==0){
            count=1;
        }else {
            while(temp!=0){
            count++;
            temp =temp/10;
        }
    }
        int[] digits = new int[count];
        int idx=count;
        if(number ==0){
            digits[--idx]=0;
        }else{
            while (number!=0) {
                int d = (int)(number%10);
                digits[--idx]=d;
                number/=10;
                
            }
        }

    
    System.out.println("Reversed number : ");
    for(int i=count-1;i>=0;i--){
        System.out.print(digits[i]);
    }
    sc.close();
    }
    
}
