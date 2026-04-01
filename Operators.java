/* Java Operators */
/* 
 * Java provides various operators for performing different operations on variables and values.
 * Operators are symbols that perform specific operations on one or more operands.
 */
/* Types of Java Operators:
1. Arithmetic Operators: +, -, *, /, %  .
2. Relational Operators: ==, !=, >, <, >=, <= .
3. Logical Operators: &&, ||, ! .   
4. Bitwise Operators: &, |, ^, ~, <<, >>, >>> .
5. Assignment Operators: =, +=, -=, *=, /=, %= .    
6. Unary Operators: +, -, ++, --, ! .
7. Ternary Operator: ? : .
*/

//1. Arithmetic Operators: These operators are used to perform basic mathematical operations such as addition, subtraction, multiplication, division, and modulus. For example, the + operator is used for addition, while the - operator is used for subtraction. The * operator is used for multiplication, and the / operator is used for division. The % operator is used to find the remainder of a division operation.
/*public class Operators {
    public static void main(String[] args) {
        int a = 10;
        int b = 5;
        System.out.println("a + b = " + (a + b)); // Addition  // Results in 15
        System.out.println("a - b = " + (a - b)); // Subtraction // Results in 5
        System.out.println("a * b = " + (a * b)); // Multiplication // Results in 50
        System.out.println("a / b = " + (a / b)); // Division // Results in 2
        System.out.println("a % b = " + (a % b)); // Modulus  // Results in 0
    }
    
}
//Precedence of operators in Java:
//1. Parentheses () 
//2. Unary operators: +, -, ++, --, ! 
//3. Multiplicative operators: *, /, %
//4. Additive operators: +, -
//5. Relational operators: >, <, >=, <=
//6. Equality operators: ==, !=
//7. Logical AND operator: &&
//8. Logical OR operator: ||
//9. Assignment operators: =, +=, -=, *=, /=, %=
*/

//Area of a circle using operators in Java.
// public class Operators{
//     public static void main(String[] args){
//         double radius=5.0;
//         double area=Math.PI*radius*radius; // Area = πr^2
//         System.out.println("The area of the circle with radius: " + radius + " is: " + area);

//     }
// }

//Area of Triangle using operators in Java. Input base and height from user.
// import java.util.Scanner;
// public class Operators{
//     public static void main(String[] args) {
//         Scanner sc= new Scanner(System.in);
//         System.out.println("Enter the base of the triangle:");
//         double base= sc.nextDouble();
//         System.out.println("Enter the height of the triangle:");
//         double height= sc.nextDouble();
//         double area= 0.5 * base * height; // Area = 1/2 * base * height
//         System.out.println("The area of the triangle with base: " + base + " and height: " + height + " is: " + area);  
//     }
// }

//Solve Quadratic Equation using operators in Java. Input a, b, c from user.
// import java.util.Scanner;
// public class Operators {
//     public static void main(String[] args) {
//         Scanner sc= new Scanner(System.in);
//         System.out.println("Enter the coefficients a, b, and c for the quadratic equation ax^2 + bx + c = 0:");
//         double a= sc.nextDouble();
//         double b= sc.nextDouble();
//         double c= sc.nextDouble();
        
//         double discriminant = b * b - 4 * a * c; // Calculate the discriminant
        
//         if (discriminant > 0) {
//             // Two real and distinct roots
//             double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
//             double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
//             System.out.println("The roots are real and distinct: " + root1 + " and " + root2);
//         } else if (discriminant == 0) {
//             // One real root (double root)
//             double root = -b / (2 * a);
//             System.out.println("The root is real and repeated: " + root);
//         } else {
//             // Complex roots
//             double realPart = -b / (2 * a);
//             double imaginaryPart = Math.sqrt(-discriminant) / (2 * a);
//             System.out.println("The roots are complex: " + realPart + " + " + imaginaryPart + "i and " + realPart + " - " + imaginaryPart + "i");
//         }
//     }
// }

//Find the volume of a cuboid using operators in Java. Input length, width, and height from user.
// import java.util.Scanner;
// public class Operators{
//     public static void main(String[] args){
//         Scanner sc=new Scanner(System.in);
//         System.out.println("Enter the length of the cuboid:");  
//         double Length=sc.nextDouble();
//         System.out.println("Enter the width of the cuboid:");
//         double Width=sc.nextDouble();
//         System.out.println("Enter the height of the cuboid:");
//         double Height=sc.nextDouble();
//         double Volume= Length*Width*Height; // Volume = length * width * height
//         System.out.println("The volume of the cuboid with length: " + Length + ", width: " + Width + ", and height: " + Height + " is: " + Volume);
//     }
// }

//Increment and Decrement Operators in Java. Input a number from user and perform increment and decrement operations on it.
// import java.util.Scanner;
// public class Operators{
//     public static void main(String[] args){
//         Scanner sc=new Scanner(System.in);
//         System.out.println("Enter a number:");
//         int number=sc.nextInt();
        
//         // Incrementing the number
//         number++; // This is equivalent to number = number + 1;
//         System.out.println("After incrementing, the number is: " + number);
        
//         // Decrementing the number
//         number--; // This is equivalent to number = number - 1;
//         System.out.println("After decrementing, the number is: " + number);
//     }
// }

// import java.util.Scanner;
// public class Operators{
//     public static void main(String[] args){
//         Scanner sc=new Scanner(System.in);
//         int x=5;
//         int y=x++;
//         System.out.println("Value of x: " + x); // Output: 6
//         System.out.println("Value of y: " + y); // Output: 5
//     }
// }

// import java.util.Scanner;
// public class Operators{
//     public static void main(String[] args){
//         Scanner sc=new Scanner(System.in);
//         int x=5;
//         int y=++x;
//         System.out.println("Value of x: " + x); // Output: 6
//         System.out.println("Value of y: " + y); // Output: 6
//     }
// }

// import java.util.Scanner;
// public class Operators{
//     public static void main(String[] args) {
//         float a=10.5f;
//         float b=a++;
//         System.out.println("Value of b: " + b); // Output: 10.5
//         System.out.println("Value of a: " + a); // Output: 11.5
//     }
// }


// import java.util.Scanner;
// public class Operators{
//     public static void main(String[] args) {
//        byte x=4;
//         byte y=(byte)(x++); // Post-increment: y gets the value of x before incrementing
//         System.out.println("Value of y: " + y); // Output: 4
//         System.out.println("Value of x: " + x); // Output: 5
//     }
// }

// import java.util.Scanner;
// public class Operators{
//     public static void main(String[] args) {
//         char ch='A';
//         char nextchar=ch++; // Post-increment: nextchar gets the value of ch before incrementing
//         System.out.println("Value of nextchar: " + nextchar); // Output: A
//         System.out.println("Value of ch: " + ch); // Output: B
//     }
// }

//Bitwise Operators in Java.
//Bitwise operations are performed on individual bits of integer data types (byte, short, int, long). They allow you to manipulate the bits of a number directly. Here are some common bitwise operators in Java:
//AND operator (&) in Java: The & operator performs a bitwise AND operation on two integers. It compares each bit of the first operand with the corresponding bit of the second operand and returns a new integer where each bit is set to 1 only if both corresponding bits of the operands are 1; otherwise, it is set to 0.
//OR operator (|) in Java: The | operator performs a bitwise OR operation on two integers. It compares each bit of the first operand with the corresponding bit of the second operand and returns a new integer where each bit is set to 1 if at least one of the corresponding bits of the operands is 1; otherwise, it is set to 0.
//XOR operator (^) in Java: The ^ operator performs a bitwise exclusive OR (XOR) operation on two integers. It compares each bit of the first operand with the corresponding bit of the second operand and returns a new integer where each bit is set to 1 only if the corresponding bits of the operands are different (i.e., one is 1 and the other is 0); otherwise, it is set to 0.
//NOT operator (~) in Java: The ~ operator performs a bitwise NOT operation on a single integer. It inverts each bit of the operand, changing 1s to 0s and 0s to 1s. For example, if the operand is 5 (which is 0000 0101 in binary), applying the ~ operator would yield -6 (which is 1111 1010 in binary).
//Left Shift operator (<<) in Java: The << operator shifts the bits of the first operand to the left by the number of positions specified by the second operand. For example, if you have an integer x with a value of 5 (which is 0000 0101 in binary) and you apply x << 2, the result will be 20 (which is 0001 0100 in binary), as the bits are shifted two positions to the left.
//Right Shift operator (>>) in Java: The >> operator shifts the bits of the first operand to the right by the number of positions specified by the second operand. For example, if you have an integer x with a value of 20 (which is 0001 0100 in binary) and you apply x >> 2, the result will be 5 (which is 0000 0101 in binary), as the bits are shifted two positions to the right.
//Unsigned Right Shift operator (>>>) in Java: The >>> operator shifts the bits of the first operand to the right by the number of positions specified bythe second operand, fillingthe leftmost bits with zeros regardless ofthe sign ofthe original number. For example, if you have an integer x with a value of -1 (which is 1111 1111 in binary) and you apply x >>> 1, the result will be 2147483647 (which is 0111 1111 1111 1１１１１１１１１１１１１１１１１１１１１１１１１１１２４７４８３６４７ (which is

// import java.util.Scanner;
// public class Operators {
// public static void main(String[] args) {
//     int x=10,y=6,z;
//     z=x&y;
//     System.out.println("Bitwise AND of x and y: " + z); // Output: 2 (0000 0010 in binary)
//     z=x|y;
//     System.out.println("Bitwise OR of x and y: " + z); // Output : 14 (0000 1110 in binary)
//     z=x^y;
//     System.out.println("Bitwise XOR of x and y: " + z); // Output : 12 (0000 1100 in binary)
// }
// }

//Shift Operators in Java.
//Shift operators are used to shift the bits of a number to the left or right. The left shift operator (<<) shifts the bits to the left, while the right shift operator (>>) shifts the bits to the right. The unsigned right shift operator (>>>) shifts the bits to the right and fills the leftmost bits with zeros regardless of the sign of the original number. Shift operators are commonly used for bit manipulation and can be useful in various applications such as graphics programming, encryption, and performance optimization.
//When you left shift a number by k places, it is equivalent to multiplying the number by 2^k. For example, if you have a number x and you apply x << 2, it is equivalent to x * 4 (since 2^2 = 4). Similarly, when you right shift a number by k places, it is equivalent to dividing the number by 2^k. For example, if you have a number x and you apply x >> 3, it is equivalent to x / 8 (since 2^3 = 8). The unsigned right shift operator (>>>) behaves similarly to the right shift operator (>>), but it fills the leftmost bits with zeros regardless of the sign of the original number.
//For example, if you have x=10 and perform left shift by 1 (x << 1), the result will be 20 (0000 1010 in binary). If you perform right shift by 1 (x >> 1), the result will be 5 (0000 0101 in binary). If you perform unsigned right shift by 1 (x >>> 1), the result will also be 5 (0000 0101 in binary) since x is a positive number. However, if x were a negative number, the unsigned right shift would yield a different result due to the filling of leftmost bits with zeros.
// import java.util.Scanner;
// public class Operators {
//     public static void main(String[] args) {
//         int x=5;
//         int leftShiftResult = x << 1; // Left shift by 1 position
//         System.out.println("Left Shift (x << 1): " + leftShiftResult); // Output: 10 (0000 1010 in binary)

//         int rightShiftResult = x >> 1; // Right shift by 1 position
//         System.out.println("Right Shift (x >> 1): " + rightShiftResult); // Output: 2 (0000 0010 in binary)

//         int unsignedRightShiftResult = x >>> 1; // Unsigned right shift by 1 position
//         System.out.println("Unsigned Right Shift (x >>> 1): " + unsignedRightShiftResult); // Output: 2 (0000 0010 in binary)
//     }
// }


//              Bit Masking and Merging in Java.
//Bit masking is a technique used to manipulate specific bits of a number while leaving the other bits unchanged. It involves using bitwise operators to create a mask that can be applied to a number to set, clear, or toggle specific bits. For example, if you want to set the 3rd bit of a number x, you can create a mask with the value 1 << 2 (which is 4 in decimal) and then use the bitwise OR operator (|) to set that bit: x = x | (1 << 2). This will set the 3rd bit of x to 1 while leaving the other bits unchanged.
//Merging two numbers using bitwise operators involves combining the bits of two numbers to create a new number. For example, if you have two numbers a and b, you can merge them using the bitwise OR operator (|) to create a new number that has all the bits set to 1 where either a or b has a bit set to 1: int merged = a | b. This will create a new number where each bit is set to 1 if either a or b has that bit set to 1, effectively merging the two numbers together. Bit masking and merging are commonly used in various applications such as setting permissions, encoding data, and optimizing performance in low-level programming. 
// import java.util.Scanner;
// public class Operators {    
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
        
//         System.out.print("Enter the first number (a): ");
//         int a = sc.nextInt();
        
//         System.out.print("Enter the second number (b): ");
//         int b = sc.nextInt();
        
//         // Bit Masking: Set the 3rd bit of a
//         int mask = 1 << 2; // This creates a mask with the 3rd bit set (0000 0100 in binary)
//         a = a | mask; // Set the 3rd bit of a
        
//         // Merging: Merge a and b using bitwise OR
//         int merged = a | b; // This will merge the bits of a and b
        
//         System.out.println("After setting the 3rd bit of a, a is: " + a);
//         System.out.println("Merged result of a and b is: " + merged);
        
//         sc.close();
//     }
// }

//Write a new program for swapping of two numbers using bitwise operators in Java. Input two numbers from user and swap them without using a temporary variable.
import java.util.Scanner;
public class Operators {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the first number (a): ");
        int a = sc.nextInt();
        
        System.out.print("Enter the second number (b): ");
        int b = sc.nextInt();
        
        // Swapping using bitwise XOR operator
        a = a ^ b; // Step 1: a now holds the result of a XOR b
        b = a ^ b; // Step 2: b now holds the original value of a
        a = a ^ b; // Step 3: a now holds the original value of b
        
        System.out.println("After swapping, first number (a) is: " + a);
        System.out.println("After swapping, second number (b) is: " + b);
        
        sc.close(); 
    }
}