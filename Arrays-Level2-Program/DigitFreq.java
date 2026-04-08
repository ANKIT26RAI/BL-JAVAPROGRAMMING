import java.util.Scanner;
public class DigitFreq{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        long number = sc.nextLong();
        number = Math.abs(number);
        int count =0;
        long temp=number;
        if(number == 0){
          count = 1;
        }else{
            while(temp!=0){
                count++;
                temp =temp/10;
            }
        }
        int[] arr = new int[count];
        int idx=arr.length-1;;
        if(number == 0){
            arr[idx]=0;
        }else{
            while(number !=0){
                int d = (int)(number%10);
                arr[idx--]=d;
                number = number/10;
            }
        }
    int[] freq = new int[10];
    for(int i=0;i<arr.length;i++){
        freq[arr[i]]++;
    }
    System.out.println("\nDigit Frequencies: ");
    for(int i=0;i<freq.length;i++){
        if(freq[i]>0){
        System.out.println("Digit "+ i +" appears "+freq[i]+" times");
        }
    }
    sc.close();
    }
}