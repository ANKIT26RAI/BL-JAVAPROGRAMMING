import java.util.Scanner;
public class PostiveEven {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr= new int[5];
        
        for(int i=0;i<arr.length;i++){
        System.out.println("Enter the num : ");
        arr[i]=sc.nextInt();
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0) System.out.println("The number is Zero");
            else if(arr[i]<0) System.out.println("The number is negative ");
            else 
                if(arr[i]%2==0)
                    System.out.println("The number is postive and Even");
                else
                    System.out.println("The number is positive and odd");

        }
        if(arr[0]==arr[arr.length-1]){
            System.out.print("The first and last element are equal");
        }else if(arr[0]>arr[arr.length-1]){
            System.out.print("The first element is greater");

        }else{
            System.out.print("The last element is greater");
        }
        sc.close();
    }
}
