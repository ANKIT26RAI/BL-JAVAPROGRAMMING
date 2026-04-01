//Printing
//1.System.out.println() - prints the text and moves to the next line
//2.System.out.print() - prints the text without moving to the next line
//3.System.out.printf() - prints formatted text     
//4.String.format() - returns a formatted string without printing it    

//Format Specifiers:
//%d - integer
//%f - floating-point number
//%s - string
//%c - character
//%n - new line
//Example:
//int age = 25;
//String name = "Alice";
//System.out.printf("Name: %s, Age: %d%n", name, age);

//  String:
// 1.String is a sequence of characters enclosed in double quotes.
// 2.Strings are immutable, meaning once created, they cannot be changed.
// 3.Strings can be concatenated using the + operator.
// 4.Strings can be compared using the equals() method for content comparison and == operator for reference comparison. 
//Example:
//  String str1 = "Hello";
//  String str2 = "World";
//  String str3 = str1 + " " + str2; // Concatenation
//  System.out.println(str3); // Output: Hello World

//Constructors for creating strings:
//1.String str = new String("Hello"); - creates a new string object with the value "Hello".
//2.String str = "Hello"; - creates a string literal, which may be interned by the Java compiler for memory efficiency. 
//Example:
//String str1 = new String("Hello");
//String str2 = "Hello";
//System.out.println(str1.equals(str2)); // Output: true (content comparison)

//Character Arrays:
//1.Characters can be stored in an array of type char[].    
//2.Characters in a char array can be accessed using their index, starting from 0.
//3.Char arrays can be converted to strings using the String constructor or the valueOf() method.
//Example:  
//char c[]={'H','e','l','l','o'};
//String str = new String(c); // Convert char array to string 

//new means creating a object in heap memory and returns the reference of that object.
//why do we need to create a new string object when we can use string literals?
//String literals are stored in a common pool and can be reused, which can save memory.
//However, using the new keyword allows you to create a new string object even if an identical string already exists in the pool, which can be useful in certain situations where you want to ensure that you have a distinct object reference.
//Example:
// String str1 = new String("Hello");
// String str2 = "Hello";
// System.out.println(str1 == str2); // Output: false (different references)
// System.out.println(str1.equals(str2)); // Output: true (content comparison) 



import java.util.Scanner;


// public class StringPrinting {
//     public static void main(String[] args) {
//         byte b[]={65,66,67,68,69};
//         String s=new String(b);
//         System.out.println(s); // Output: ABCDE
//     }
    
// }

// public class StringPrinting {
//     public static void main(String[] args) {
//         char c[]={'H','e','l','l','o'};
//         String s=new String(c);
//         System.out.println(s); // Output: Hello
//     }
    
// }
