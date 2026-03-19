//package Day1;
//Skeleton Of Java Program.
// import java.util.Scanner;
// public class First163 {
//     public static void main(String[] args){
//         System.out.println("Hello world");
//     }
// }

//Reading data from class.
//Java provides a class called Scanner to read data from the user. It is present in the java.util package. To use it, we need to import it first. Then we can create an object of the Scanner class and use its methods to read different types of data.
//In util package, there are many classes that provide various functionalities. For example, the Scanner class is used for reading input from the user, while the ArrayList class is used for creating dynamic arrays. The java.util package also contains classes for working with dates and times, such as the Date and Calendar classes. Additionally, it includes classes for working with collections, such as the HashMap and HashSet classes. Overall, the java.util package is a fundamental part of the Java programming language and provides essential tools for developers to create robust and efficient applications.
// import java.util.Scanner;
// public class First163 {
//     public static void main(String[] args){
//         Scanner sc=new Scanner(System.in);
//         int a,b,c;
//         System.out.println("Enter two numbers");
//         a=sc.nextInt();
//         b=sc.nextInt();
//         c=a+b;
//         System.out.println("The sum of two numbers is "+c);
//     }
// }

//Take a name input from the user and print it.
// import java.util.Scanner;
// public class First163{
//     public static void main(String[] args){
//         Scanner sc=new Scanner(System.in);
//         String name;
//         System.out.println("Enter your name");
//         name=sc.nextLine();
//         System.out.print("Hello "+name);
//     }
// }

//Data types in Java.
//1. Primitive data types: These are the basic data types in Java and include int, byte, short, long, float, double, char, and boolean. They are called primitive because they are not objects and do not have any methods associated with them.
//Ranges and Size of primitive data types:
//1, byte: 8 bits, range from -128 to 127
//2, short: 16 bits, range from -32,768 to 32,767
//3, int: 32 bits, range from -2,147,483,648 to 2,147,483,647
//4, long: 64 bits, range from -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807
//5, float: 32 bits, range from 1.4E-45 to 3.4028235E38
//6, double: 64 bits, range from 4.9E-324 to 1.7976931348623157E308
//7, char: 16 bits, range from '\u0000' to '\uffff' (0 to 65,535)
//8, boolean: 1 bit, can only take the values true or false 
//2.Non-primitive data types: These are also known as reference data types and include classes, interfaces, arrays, and enums. They are called non-primitive because they are objects and have methods associated with them. Non-primitive data types can be used to create complex data structures and can store multiple values. For example, a String is a non-primitive data type that can store a sequence of characters, while an ArrayList is a non-primitive data type that can store a dynamic list of objects.


//Variables in Java.
//A variable is a container that holds a value. In Java, we need to declare a variable before we can use it. The syntax for declaring a variable is as follows:
//dataType variableName;
//For example, to declare an integer variable named "age", we can write:
//int age;
//We can also initialize a variable at the time of declaration by assigning it a value. For example:
//int age = 25;
//In Java, there are different types of variables based on their scope and lifetime. The three main types of variables are:
//1. Local variables: These are variables that are declared inside a method and can only be accessed within that method. They are created when the method is called and destroyed when the method finishes executing.
//2. Instance variables: These are variables that are declared inside a class but outside of any method. They are also known as member variables and can be accessed by all methods in the class. Each instance of the class has its own copy of the instance variables.
//3. Static variables: These are variables that are declared with the static keyword and belong to the class rather than any instance of the class. They can be accessed without creating an instance of the class and are shared among all instances of the class. Static variables are also known as class variables.

//Intialize a variable and print it.
// import java.util.Scanner;
// public class First163 {
//     public static void main(String[] args){
//     byte b=127;
//     int i=1000;
//     float f=3.14f;
//     double d=3.141592653589793;
//     char c='A';
//     boolean bool=true;
//     System.out.println("Byte value: "+b);
//     System.out.println("Integer value: "+i);        
//     System.out.println("Float value: "+f);
//     System.out.println("Double value: "+d);
//     System.out.println("Character value: "+c);
//     System.out.println("Boolean value: "+bool);

//     }
// }

//Rules for naming variables in Java.
//1. Variable names must begin with a letter (a-z or A-Z), a dollar sign ($), or an underscore (_). They cannot begin with a digit.
//2. Variable names can only contain letters, digits, dollar signs, and underscores. They cannot contain spaces or special characters.
//3. Variable names are case-sensitive, which means that "myVariable" and "myvariable" are considered different variables.
//4. Variable names cannot be the same as Java reserved keywords, such as "int", "class", "if", etc.
//5. Variable names should be meaningful and descriptive, so that it is easier to understand the purpose of the variable. For example, instead of naming a variable "x", it is better to name it "age" if it is meant to store a person's age.

//Write a program to swap two numbers without using a third variable.
// import java.util.Scanner;
// public class First163 {
//     public static void main(String[] args){
//         Scanner sc=new Scanner(System.in);
//         int a,b;
//         System.out.println("Enter two numbers");
//         a=sc.nextInt();
//         b=sc.nextInt();
//         System.out.println("Before swapping: a = "+a+" and b = "+b);
//         a=a+b; // a now holds the sum of a and b
//         b=a-b; // b now holds the original value of a
//         a=a-b; // a now holds the original value of b
//         System.out.println("After swapping: a = "+a+" and b = "+b);
//     }
// }

//What are Literals.
//Literals are fixed values that are directly represented in the source code. They can be of various types, such as integer literals, floating-point literals, character literals, string literals, and boolean literals. For example, in the statement "int x = 10;", the value "10" is an integer literal. In the statement "String name = "John";", the value "John" is a string literal. Literals are used to assign values to variables or to represent constant values in expressions. They are an essential part of programming and help to make code more readable and maintainable.
//Write a program to demonstrate the use of literals in Java.
// import java.util.Scanner;
// public class First163 {
//     public static void main(String[] args){
//         int age = 25; // integer literal
//         double pi = 3.14159; // floating-point literal
//         char grade = 'A'; // character literal
//         String name = "John"; // string literal
//         boolean isStudent = true; // boolean literal

//         System.out.println("Name: " + name);
//         System.out.println("Age: " + age);
//         System.out.println("Pi: " + pi);
//         System.out.println("Grade: " + grade);
//         System.out.println("Is Student: " + isStudent);
//     }
// }

