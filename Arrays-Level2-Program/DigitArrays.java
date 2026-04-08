import java.util.Scanner;
public class DigitArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number : ");
        long number = sc.nextLong();
         
        int maxDigit = 10;
        int[] digit = new int[maxDigit];
        number= Math.abs(number);
        int idx=0;

        if(number ==0){
            digit[idx++]=0;
        }
        while(number!=0){
            if(idx== maxDigit){
            maxDigit+=10;
            
            int[] temp = new int[maxDigit];
            for(int i=0;i<idx;i++){
                temp[i]=digit[i];
            }
            digit=temp;
        }
        int d = (int)(number%10);
        digit[idx++]= d;
        number = number/10;

    }

    int largest = Integer.MIN_VALUE;
    int secondlargest = Integer.MIN_VALUE;
    for(int i=0;i<idx;i++){
        if(digit[i]>largest){
            secondlargest = largest;
            largest =digit[i];
        }else if(digit[i]>secondlargest&&digit[i]!=largest){
            secondlargest =digit[i];
        }
    }
    System.out.println("Largest digit : "+ largest);
    if(secondlargest == Integer.MIN_VALUE){
        System.out.println("Second Largest Element Not found! ");
    }else{
        System.out.println("Second Largest Digit : "+ secondlargest);
    }
    sc.close();
}
    
}
