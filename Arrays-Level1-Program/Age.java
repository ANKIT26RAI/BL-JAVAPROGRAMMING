import java.util.Scanner;
public class Age{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        for(int i=0;i<10;i++){
            System.out.print("Enter the Age of Student :"+(i+1)+" :" );
            arr[i]=sc.nextInt();
        }
        for(int i=0;i<arr.length;i++){

            if(arr[i]<=0){
                System.out.println("Invalid Age." + arr[i]);
            }else if(arr[i]>=18){
                System.out.println("The student with the age "+ arr[i]+" can vote. ");
            }else{
                System.out.println("The student with the age "+arr[i]+" can't vote ");
            }
        }
        sc.close();
    }
}