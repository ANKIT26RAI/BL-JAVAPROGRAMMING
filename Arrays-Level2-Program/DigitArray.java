import java.util.Scanner;
public class DigitArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number : ");
        int number = sc.nextInt();
         number = Math.abs(number);
        int maxdigit=10;
        int[] digits=new int[maxdigit];
        int index =0;
        while (number!=0) {
           int digit =number%10;
           digits[index++]=digit;

           if(index == maxdigit){
            break;
           }
           number= number/10;
        }

        int largest =-1;
        int secondLargest = -1;
        for(int i=0;i<index;i++){
        if(digits[i]>largest){
            secondLargest = largest;
            largest=digits[i];
        }else if(digits[i]>secondLargest&&digits[i]!=largest){
            secondLargest = digits[i];
        }
        }

        System.out.println("Largest digit :" + largest);
        if(secondLargest==-1){
            System.out.println("Second Largest Not found.");
        }else{
            System.out.println("Second largest Digit  " + secondLargest);
        }
        sc.close();

    }
    
}
