import java.util.Scanner;
public class YoungTall {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] age= new int[3];
        int[] height = new int[3];
        System.out.println("Enter the heigth and Age of Amar,Akbar and Anthony :");
        for(int i=0;i<3;i++){
            System.out.println("The age and height of friend" +(i+1)+" : is ");
            age[i]=sc.nextInt();
            height[i]=sc.nextInt();
        }
        int tallest = 0;
        int Young = 0;
        for(int i=0;i<2;i++){
           if(age[i]>age[i+1]){
            Young = age[i+1];
           }else{
             Young= age[i]; 
           }

          if( height[i]>height[i+1]){
            tallest = height[i];
          }else{
            tallest= height[i+1];
          }
        }

        System.out.println("The Tallest among all 3 is : "+ tallest );
        System.out.println("The Youngest among all 3 is : "+ Young);
        sc.close();

    

    }
    
}
