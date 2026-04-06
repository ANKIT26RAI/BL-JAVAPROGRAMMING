//What are Methods in Java?
//Methods are blocks of code that perform a specific task and can be called upon to execute when needed. They help in breaking down complex problems into smaller, manageable pieces, promote code reusability, and improve readability. Methods can take parameters, return values, and can be overloaded to provide different implementations based on the number or type of parameters.
//How to write a method in Java?
//To write a method in Java, you need to follow the syntax:
//accessModifier returnType methodName(parameter list) { //Signature of the method
//    // method body
//}
// Methods for finding maximum of two numbers.
// public class Methods{
// static int max(int x,int y){
//     if(x>y){
//         return x;
//     }
//     else{
//         return y;
//     }
//     }
// public static void main(String[] args) {
//     int a= 10;
//     int b= 20;
//     int result = max(a,b);
//     System.out.println("The maximum of "+a+" and "+b+" is: "+result);
// }
// }
//Parameter Passing in Java Methods
//The parameter passing in Java methods can be done in two ways: pass by value and pass by reference. In Java, all primitive data types (such as int, float, etc.) are passed by value, meaning that a copy of the variable is passed to the method. On the other hand, objects (such as arrays, classes, etc.) are passed by reference, meaning that a reference to the object is passed to the method. This allows changes made to the object within the method to affect the original object outside the method.
//How objects are passed to methods in Java?
// public class Methods {
//  static void Update(int[] arr){
// for(int i=0;i<arr.length;i++){
// arr[i]+=1;
// }
// }
// public static void main(String[] args){
// int[] arr = {1,2,3,4,5};
// Update(arr);
// System.out.println("Elements after Updating in Methods are :");
// for(int i=0;i<arr.length;i++){
// System.out.print(arr[i]+" ");
// }
// }
// }
//Methods Return Types in Java
//In Java, methods can return a value of a specific type. The return type is specified in the method signature and can be any valid data type, including primitive types (such as int, float, etc.) and reference types (such as classes, arrays, etc.). If a method does not return any value, it can be declared with the return type void. When a method is called, it executes its body and returns the specified value to the caller.
// public class Methods {
//     static int sum(int a, int b) {
//         return a + b;
//     }

//     public static void main(String[] args) {
//         int num1 = 5;
//         int num2 = 10;
//         int result = sum(num1, num2);
//         System.out.println("The sum of " + num1 + " and " + num2 + " is: " + result);
//     }
// }

// public class Methods {
//     static void printMessage(String message) {
//         System.out.println(message);
//     }

//     public static void main(String[] args) {
//         printMessage("Hello, World!");
//     }
// }
//Method Overloading in Java
//Method Overloading writing more than one method with same name.
//Either the datatype of the parameters should be different.
//Or the no.of parameters should be different.
// public class Methods{
//     static int max(int x, int y){
//         return x>y?x:y;
//     }
//     static float max(float x , float y){
//         return x>y?x:y;
//     }
//     static int max(int x, int y, int z){
//         return x>y&&x>z?x:(y>z?y:x);
//     }
//     public static void main(String[] args) {
//         System.out.println("The max of two number : "+ max(5,10));
//         System.out.println("The max of two  float number : "+ max(5f,10f));
//         System.out.println("The max of three number : "+ max(50,10,14));

//     }
// }

//1. Overloaded Method to Calculate Area
// import java.util.Scanner;
// public class Methods {

//      static double area(double radius){
//      return Math.PI*radius*radius;
//     }
//      static double area(double length,double breadth){
//         return length*breadth;
//     }
//      static double area(double base,double height,String shape){
//         return 0.5*base*height;
//     }
//     public static void main(String[] args) {
//         System.out.println("Area of Circle : " + area(7.0));
//         System.out.println("Area of Rectangle : " + area(14.0,17.0));
//         System.out.println("Area of Triangle : " + area(56,14, "triangle"));


//     }

// }

//Overloaded Method to Reverse an arr or an int.
// import java.util.Scanner;
// public class Methods {

//     static int reverse(int n){
//         int reverse = 0;
//         while(n>0){
//             int digit=n%10;
//             reverse=digit+10*reverse;
//             n=n/10;
//         }
//        return reverse;
//     }

//     static int[] reverse(int[] arr){
//         int left = 0;
//         int right=arr.length-1;
//         while(left<=right){
//             int temp=arr[left];
//             arr[left]=arr[right];
//             arr[right]=temp;
//             left++;
//             right--;

//         }
//         return arr;
//     }
//     public static void main(String[] args) {
//         Scanner  sc = new Scanner(System.in);
//         System.out.println("The reverse of number is "+ reverse(679));
//         System.out.print("Enter the length of arr :");
//        int n= sc.nextInt();
//        int[] array= new int[n];
//        for(int i=0;i<n;i++){
//         array[i]=sc.nextInt();

//        }
  
//        int result[] = reverse(array);
//        for(int x:result){
//         System.out.print(x+" ");
//        } 
//        sc.close();
//     }
// }

//Validate Name and Age .
// import java.util.Scanner;
// public class Methods {

//     static boolean validate(String name){
//         return name.matches("[a-zA-Z]*(\\s[a-zA-Z]+)*");
//     }
//     static boolean validate(int age){
//         return age>=1&&age<=150;
//     }
//     static boolean validate(String name,int age){
//         return validate(name)&&validate(age);
//     }

//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         System.out.println("Enter the name : ");
//         String name = sc.nextLine();
//          System.out.println("Enter the age : ");
//         int age = sc.nextInt();
//         System.out.println("Validate the name :" +validate(name));
//         System.out.println("Validate the age : "+validate(age));
//         System.out.println("Validate the both : "+validate(name,age));
//     }
// }
//variable arguments (varargs) in Java methods
//Allows a method to accept any number of arguments of the same type.
//void show(int...x){};
// public class Methods {
//     static int sum(int...numbers){
//         int sum=0; 
//         for(int x:numbers){
//             sum+=x;
//         }
//         return sum;
//     }
//     public static void main(String[] args) {
//         System.out.println(sum(1,2));
//         System.out.println(sum(3,4,5));
//         System.out.println(sum(6,7,8));
//         System.out.println(sum(9,10,11,12,13,15));
//         System.out.println(sum());
        
//     }
// }

//Find maximum using varargs
import java.util.Scanner;
public class Methods{
    static int max(int...num){
        if(num.length==0) return Integer.MIN_VALUE;
        int max = num[0];
        for(int i=1;i<num.length;i++){
            if(num[i]>max) max=num[i];
        }
        return max;
    }
    public static void main(String[] args) {
        System.out.println(max(1,2));
        System.out.println(max(1,2,3,4,5,6));
        System.out.println(max());

        
        
    }
}
//find a number is Prime or not using method

// import java.util.Scanner;
// public class Methods{
//     static void prime(int n){
//         boolean prime =  true;
//         for(int i=2;i<=Math.sqrt(n);i++){
//             if(n%i==0){
//                 prime = false;
//                 break;
//             }
//         }
//         if(!prime){
//             System.out.print("The number is not prime");
//         }else{
//             System.out.print("The number is Prime");
//         }
//     }
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         prime(n);
//         sc.close();
//     }
// }

//Find GCD of two numbers using method
// import java.util.Scanner;
// public class Methods{
//     static int gdc(int m, int n){
//         while(m!=n){
//             if(m>n) m=m-n;
//             else n= n-m;
//         } 
//         return m;
//     }
//         public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         int m = sc.nextInt();
//         System.out.print("The greatest common factor of two number is :"+gdc(m, n));
//         sc.close();
//     }
// }
//find max element in an array using method
// import java.util.Scanner;
// public class Methods {

//     static int maxElement(int[] arr){
//         int max = arr[0];
//         for(int i=1;i<arr.length;i++){
//             if(arr[i]>max) max= arr[i];
//         }
//         return max;
//     }
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         System.out.print("Enter the Length of arr :");
//         int n = sc.nextInt();
//         int[] array = new int[n];
//         for(int i=0;i<n;i++){
//             array[i]=sc.nextInt();
//         }


//         System.out.print("The max element in arr is : "+ maxElement(array));
//     }
// }
// //find min element in an array using method
// import java.util.Scanner;
// public class Methods {

//     static int minarr(int[] arr){
//         int min = arr[0];
//         for(int i=1;i<arr.length;i++){
//             if(min>arr[i]) min= arr[i];
//         }
//         return min;
//     }
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         System.out.print("Enter the length of arr : ");
//         int n = sc.nextInt();
//         int[] array=new int[n];
//         for(int i=0;i<n;i++){
//             array[i]=sc.nextInt();
//         }
//         System.out.print("The min element in arr :" + minarr(array));
//         sc.close();
//     }
// }