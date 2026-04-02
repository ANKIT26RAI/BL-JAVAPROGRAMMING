//Conditional statements are used to perform different actions based on different conditions. In Java, we have several types of conditional statements, including if, if-else, else-if, and switch statements.
//Relational Operators: These operators are used to compare two values. They include 
// == (equal to), 
// != (not equal to),
// > (greater than), 
// < (less than),
// >= (greater than or equal to), and 
// <= (less than or equal to).  

//Logical Operators: These operators are used to combine multiple conditions. They include
// && (logical AND),
// || (logical OR), and
// ! (logical NOT).

//Conditional statements allow you to control the flow of your program based on certain conditions. For example, you can use an if statement to execute a block of code only if a specific condition is true. An if-else statement allows you to execute one block of code if a condition is true and another block of code if the condition is false. An else-if statement allows you to check multiple conditions in sequence. A switch statement allows you to execute different blocks of code based on the value of a variable.    
//Here is an example of how to use conditional statements in Java:  
// Example of if statement
/*
int number = 10;
if (number > 5) {
    System.out.println("The number is greater than 5.");
}
*/
// Example of if-else statement
/*
int number = 10;    
if (number > 5) {
    System.out.println("The number is greater than 5.");
} else {
    System.out.println("The number is not greater than 5.");
}
*/  
// Example of else-if statement
/*  
int number = 10;
if (number > 10) {
    System.out.println("The number is greater than 10.");
} else if (number == 10) {
    System.out.println("The number is equal to 10.");
} else {
    System.out.println("The number is less than 10.");
}
*/

// Code to find greater between three numbers using if-else statements
// import java.util.Scanner;
// public class ConditionalStatements {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int a,b,c;
//         System.out.print("Enter the first number : ");
//         a = sc.nextInt();
//         System.out.print("Enter the Second number : ");
//         b = sc.nextInt();
//         System.out.print("Enter the third number : ");
//         c = sc.nextInt();

//         if(a>b && a>c){
//             System.out.print("The greatest among all three is : " + a);
//         }else if(b > c){
//             System.out.print("The greatest among all three is : " + b);

//         }else{
//             System.out.print("The greatest among all three is : " + c);

//         }
//         sc.close();

//     }
// }

//Find the number is even or odd using if-else statements
// import java.util.Scanner;
// public class ConditionalStatements {
// public static void main(String[] args) {
//     Scanner sc = new Scanner(System.in);
//     int n;
//     System.out.print("Enter the number : ");
//     n= sc.nextInt();
//     if(n%2==0){
//         System.out.print("The number is even.");
//     }else{
//     System.out.print("The number is odd.");
//     }
//      sc.close();
//    }
// }

//Find the radix of given number in the form of string.
// import java.util.Scanner;
// public class ConditionalStatements {
//     public static void main(String[] args){
//         Scanner sc = new Scanner(System.in);
//         String number;
//         System.out.print("Enter the number : ");
//         number = sc.nextLine();
//         if(number.startsWith("0x")||number.startsWith("0X")){
//             System.out.print("The radix of the given number is : 16");
//         }else if(number.startsWith("0b")||number.startsWith("0B")){
//             System.out.print("The radix of the given number is : 2");   
//         }else if(number.startsWith("0")){
//             System.out.print("The radix of the given number is : 8");
//         }else{
//             System.out.print("The radix of the given number is : 10");
    
//         }
//         sc.close();
//     }
// }

// import java.util.Scanner;
// public class ConditionalStatements {
//     public static void main(String[] args) {
//         try(Scanner sc = new Scanner(System.in)){
//             String number;
//             System.out.print("Enter the number : ");
//             number = sc.nextLine().toUpperCase().trim();
//             if(number.matches("[01]+")){
//                 System.out.print("The radix of the given number is : 2");
//             }else if(number.matches("[0-7]+")){
//                 System.out.print("The radix of the given number is : 8");   
//             }else if(number.matches("[0-9]+")){
//                 System.out.print("The radix of the given number is : 10");
//             }else if(number.matches("[0-9A-F]+")){
//                 System.out.print("The radix of the given number is : 16");
//             }else{
//                 System.out.print("Invalid number format.");
//             }
//         }
//     }
// }


//Code to find the leap year using if-else statements
// import java.util.Scanner;
// public class ConditionalStatements {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int year;
//         System.out.print("Enter the year : ");  
//         year = sc.nextInt();
//         if((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)){
//             System.out.print(year + " is a leap year.");
//         } else {
//             System.out.print(year + " is not a leap year.");
//         }
//         sc.close();

//     }
// }

//Display the day based on anumber.
// import java.util.Scanner;
// public class ConditionalStatements {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int day;
//         System.out.print("Enter the day number (1-7) : ");
//         day = sc.nextInt();
//         if(day == 1){
//             System.out.print("The day is : Sunday");
//         }else if(day == 2){
//             System.out.print("The day is : Monday");
//         }else if(day == 3){
//             System.out.print("The day is : Tuesday");
//         }else if(day == 4){
//             System.out.print("The day is : Wednesday");
//         }else if(day == 5){
//             System.out.print("The day is : Thursday");
//         }else if(day == 6){
//             System.out.print("The day is : Friday");
//         }else if(day == 7){
//             System.out.print("The day is : Saturday");
//         }else{
//             System.out.print("Invalid day number.");
//         }
//         sc.close();
//     }
// }

//Find the type of the website and protocol used in the website using if-else statements
// import java.util.Scanner;
// public class ConditionalStatements{
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         String url;
//         System.out.print("Enter the url : ");
//         url = sc.nextLine().toLowerCase().trim();
//         if(url.startsWith("https:")){
//             System.out.print("The protocol used in the website is : HTTPS");
//         }else if(url.startsWith("http:")){
//             System.out.print("The protocol used in the website is : HTTP");
//         }else if(url.startsWith("ftp:")){
//             System.out.print("The protocol used in the website is : FTP");
//         }else if(url.startsWith("www.")){
//             System.out.print("The protocol used in the website is : HTTP");
//         }else{
//             System.out.print("Unknown protocol.");
//         }

//         if(url.endsWith(".com")){
//             System.out.print("\nThe type of the website is : Commercial");
//         }else if(url.endsWith(".org")){
//             System.out.print("\nThe type of the website is : Organization");
//         }else if(url.endsWith(".net")){
//             System.out.print("\nThe type of the website is : Network"); 
//         }else if(url.endsWith(".edu")){
//             System.out.print("\nThe type of the website is : Educational");
//         }else if(url.endsWith(".gov")){
//             System.out.print("\nThe type of the website is : Government");
//         }else{
//             System.out.print("\nUnknown website type.");
//         }
//         sc.close();   
//     }
// }

//Switch Case Statements: Switch statements are used to perform different actions based on different conditions. They are an alternative to if-else statements when you have multiple conditions to check. The switch statement evaluates an expression and executes the corresponding case block based on the value of the expression. Here is an example of how to use a switch statement in Java:
//format of switch case statement
/*
switch (expression) {
    case value1:
        // code to be executed if expression equals value1
        break;
    case value2:
        // code to be executed if expression equals value2
        break;
    // more cases...
    default:
        // code to be executed if expression doesn't match any case
}
*/
//Example of switch case statement
/*
int day = 3;
switch (day) {  
    case 1:
        System.out.println("The day is : Sunday");
        break;
    case 2:
        System.out.println("The day is : Monday");
        break;
    case 3:
        System.out.println("The day is : Tuesday");
        break;
    case 4:
        System.out.println("The day is : Wednesday");
        break;
    case 5:
        System.out.println("The day is : Thursday");
        break;
    case 6:
        System.out.println("The day is : Friday");
        break;
    case 7:
        System.out.println("The day is : Saturday");
        break;
    default:
        System.out.println("Invalid day number.");
}
*/

//Problems to practice switch case statements
//Find the day based on anumber using switch case statements
// import java.util.Scanner;
// public class ConditionalStatements {
//     public static void main(String[] args){
//         Scanner sc =new Scanner(System.in);
//         int day;
//         System.out.print("Enter the day number (1-7) : ");
//         day = sc.nextInt();
//         switch (day){
//             case 1 -> System.out.print("The day is : Sunday");
//             case 2 -> System.out.print("The day is : Monday");
//             case 3 -> System.out.print("The day is : Tuesday");
//             case 4 -> System.out.print("The day is : Wednesday");
//             case 5 -> System.out.print("The day is : Thursday");
//             case 6 -> System.out.print("The day is : Friday");
//             case 7 -> System.out.print("The day is : Saturday");
//             default -> System.out.print("Invalid day number.");

//         }    
//         sc.close();
//     }
// }

//Find the type of the website and protocol used in the website using switch case statements
// import java.util.Scanner;
// public class ConditionalStatements {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         String url;
//         System.out.print("Enter the url : ");
//         url = sc.nextLine().toLowerCase().trim();
//         switch (url) {
//             case String s when s.startsWith("https:") -> System.out.print("The protocol used in the website is : HTTPS");
//             case String s when s.startsWith("http:") -> System.out.print("The protocol used in the website is : HTTP");
//             case String s when s.startsWith("ftp:") -> System.out.print("The protocol used in the website is : FTP");
//             case String s when s.startsWith("www.") -> System.out.print("The protocol used in the website is : HTTP");
//             default -> System.out.print("Unknown protocol.");
//         }

//         switch (url) {
//             case String s when s.endsWith(".com") -> System.out.print("\nThe type of the website is : Commercial");
//             case String s when s.endsWith(".org") -> System.out.print("\nThe type of the website is : Organization");
//             case String s when s.endsWith(".net") -> System.out.print("\nThe type of the website is : Network");
//             case String s when s.endsWith(".edu") -> System.out.print("\nThe type of the website is : Educational");
//             case String s when s.endsWith(".gov") -> System.out.print("\nThe type of the website is : Government");
//             default -> System.out.print("\nUnknown website type.");
//         }
//         sc.close();
//     }
// }

//Menu driven program to perform basic arithmetic operations using switch case statements
// import java.util.Scanner;
// public class ConditionalStatements {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         System.out.println("Menu:");
//         System.out.println("1. Addition");
//         System.out.println("2. Subtraction");
//         System.out.println("3. Multiplication");
//         System.out.println("4. Division");
//         System.out.print("Enter your choice (1-4) : ");
//         int choice = sc.nextInt();
//         System.out.print("Enter the first number : ");
//         double num1 = sc.nextDouble();
//         System.out.print("Enter the second number : ");
//         double num2 = sc.nextDouble();
//         switch (choice) {
//             case 1 -> System.out.println("The result of addition is : " + (num1 + num2));
//             case 2 -> System.out.println("The result of subtraction is : " + (num1 - num2));
//             case 3 -> System.out.println("The result of multiplication is : " + (num1 * num2));
//             case 4 -> {
//                 if (num2 != 0) {
//                     System.out.println("The result of division is : " + (num1 / num2));
//                 } else {
//                     System.out.println("Error: Division by zero is not allowed.");
//                 }
//             }
//             default -> System.out.println("Invalid choice.");
//         }
//         sc.close();
//     }
// }