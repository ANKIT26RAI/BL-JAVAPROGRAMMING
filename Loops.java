//Loops are used to repeat a block of code until a certain condition is met. There are three types of loops in Java: for loop, while loop, and do-while loop.

//while loop: The while loop is used to execute a block of code repeatedly as long as a specified condition is true. The syntax for a while loop is as follows:
/*
while (condition) {
    // code to be executed
}
*/
// do-while loop: The do-while loop is similar to the while loop, but it guarantees that the block of code will be executed at least once, even if the condition is false. The syntax for a do-while loop is as follows:
/* 
do {
    // code to be executed
} while (condition);
*/
// for loop: The for loop is used to execute a block of code a specific number of times. The syntax for a for loop is as follows:
/*  
for (initialization; condition; increment/decrement) {
    // code to be executed
}
*/
// In the for loop, the initialization is executed only once at the beginning of the loop, the condition is evaluated before each iteration, and the increment/decrement is executed after each iteration. The for loop is often used when the number of iterations is known beforehand.    
//while loop example:
//printing table of 5 using while loop
// public class Loops {
//     public static void main(String[] args){
//         int i=1;
//         while(i<=10){
//             System.out.println("5 x " + i + " = " + (5*i));
//             i++;
//         }
        
//     }  
// }

//using do-while loop to print table of 2
// public class Loops{
//     public static void main(String[] args){
//         int i=1;
//         do{
//             System.out.println("2 x " + i + " = " +(2*i));
//             i++;
//         }while(i<=10);
//     }
// }

//For loop example: printing table of any using for loop

// import java.util.Scanner;

// public class Loops{
//     public static void main(String[] args) {
//         Scanner sc= new Scanner(System.in);
//         int n;
//         System.out.print("Enter the number you need table for : ");
//         n = sc.nextInt();
//         for(int i=1;i<=10;i++){
//             System.out.println( n + " x " + i + " = " + n*i);
//         }
//         sc.close();
//     }
// }
 
//Factorial of a number using for loop
// import java.util.Scanner;
// public class Loops{
//     public static void main(String[] args){
//         Scanner sc= new Scanner(System.in);
//         int n;
//         System.out.print("Enter the number : ");
//         n = sc.nextInt();
//         int fact =1;
//         for(int i=1;i<=n;i++){
//             fact*=i;
//         }
//         System.out.print("Factorial of " + n + " is: " + fact);
//         sc.close();
//     }
// }

// import java.util.Scanner;
// public class Loops{
//     public static void main(String[] args) {
//         try(Scanner sc = new Scanner(System.in)){
//             System.out.print("Enter the number : ");
//             int n = sc.nextInt();
//             if(n<0){
//                 System.out.print("There is not defind factorial for negative numbers");
//             }else{
//                 long fact=1;
//                 for(int i=1;i<=n;i++){
//                     fact*=i;
//                 }
//                  System.out.print("The factorial of number is : " + fact);
//             }
//         }
//     }
// }

//Armstrong number is a number that is equal to the sum of its own digits each raised to the power of the number of digits. For example, 153 is an Armstrong number because 1^3 + 5^3 + 3^3 = 153. Here is a Java program to check if a number is an Armstrong number using a for loop:
// import java.util.Scanner;
// public class Loops {
//       public static void main(String[] args) {
//         try(Scanner sc = new Scanner(System.in)){
//             System.out.print("Enter the number ");
//             int n = sc.nextInt();
//             int original = n;
//             int armstrong =0;
//             while(n>0){
//                 int digit = n%10;
//                  n = n/10;
//                 armstrong = (digit*digit*digit )+ armstrong;
//             }

//             if(armstrong==original){
//                 System.out.print("The given number is Armstrong");
//             }else{
//                 System.out.print("Number is not Armstrong");
//             }
//         }
//       }
// }

//Palindrome number is a number that reads the same backward as forward. For example, 121 is a palindrome number because it reads the same backward and forward. Here is a Java program to check if a number is a palindrome number using a for loop:
// import java.util.Scanner;
// public class Loops {
//     public static void main(String[] args) {
//         try(Scanner sc = new Scanner(System.in)){
//             System.out.print("Enter the number : ");
//             int number = sc.nextInt();
//             int original = number;
//             int reverse =0;
//             while (number>0) {
                
//                 int digit = number%10;
//                 reverse = (reverse*10) + digit; 
//                 number = number/10;
//             }
//             if(original == reverse){
//                 System.out.print("The given number is a palindrome");
//             }else{
//                 System.out.print("The given number is not a palindrome");
//             }
//         }
//     }
// }

//fibonacci series is a series of numbers where each number is the sum of the two preceding ones, usually starting with 0 and 1. Here is a Java program to print the Fibonacci series up to a given number using a for loop:
// import java.util.Scanner;
// public class Loops {
//     public static void main(String[] args) {
//         try(Scanner sc = new Scanner(System.in)){
//             System.out.println("Enter the number : ");
//             int n= sc.nextInt();
//             int first =0;
//             int second =1;
//             for(int i=1;i<=n;i++){
//                 System.out.print(first + " ");
//                 int next = first +second;
//                 first = second;
//                 second = next;
//             }
//         }
//     }
// }



//   Nested loops are loops that are placed inside another loop. The inner loop is executed completely for each iteration of the outer loop. Here is a Java program to print a pattern of stars using nested loops:
// Question: Print the following pattern using nested loops:
/*
*
**  
***
****
*****
*/

// import java .util. Scanner;
// public class Loops{
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int n;
//         System.out.print("Enter the number ");
//         n = sc.nextInt();
//         for(int i=1;i<=n;i++){
//             for(int j = 1;j<=i;j++){
//                 System.out.print("*" + " ");
//             }
//             System.out.println();   
//         }
//         sc.close();
//     }
// }

// Question: Print the following pattern using nested loops:
/*
    *
   ***
  *****
 *******   
*********
*/
// import java.util.Scanner;
// public class Loops{
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int n;
//         System.out.print("Enter the number : ");
//         n = sc.nextInt();
//         for(int i=1;i<=n;i++){
//             for(int j=1;j<=n-i;j++){
//                 System.out.print(" ");
//             }
//             for(int k=1;k<=2*i-1;k++){
//                 System.out.print("*");
//             }
//             System.out.println();
//         }
//         sc.close();

//     }
// }

// Question: Print the following pattern using nested loops:
/*
    *
   * *
  * * *
 * * * *    
* * * * *
*/
// import java.util.Scanner;
// public class Loops{
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int n;
//         System.out.print("Enter the number : ");
//         n = sc.nextInt();
//         for(int i=1;i<=n;i++){
//             for(int j=1;j<=n-i;j++){
//                 System.out.print(" ");
//             }    
//             for(int k=1;k<=i;k++){
//                 System.out.print("*" + " ");
//             }
//             System.out.println();
//         }
//         sc.close();
//     }
// }


