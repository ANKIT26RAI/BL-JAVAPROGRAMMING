//Exceptions are runtime errors.
//Type of Errors;
//1.Syntax Errors.
//2.Logical Errors.
//3.Runtime Errors.

//Top two errors are faced by programmers.and can be removed by help of compiler.
//Logical Error Program not giving expected result.Tracing/Debugger to remove these errors.
//Runtime errors are faced by user.
//Reasons:
//Invalid Input.
//Missing of Resources.
//Program will stop/crash.
//We cannot do anything but guide the user by programmer so user get the proper message.
//This is done by Exception Handling.
// public class Exceptions {
//     public static void main(String[] args) {
//         int a,b,c;
//         a=5;
//         b=0;
//         c=a/b;
//         System.out.println(c); //this will Arithmetic erroe.
//     }
// }

//try-catch construct.

// public class Exceptions {

//     public static void main(String[] args) {
//         int a,b,c;
//         try{
//             a=10;
//             b=0;
//             c=a/b;
//             System.out.println("Result is "+c);
//         }catch(ArithmeticException e){
//             System.out.println("Division by zero "+ e);
//         }
//     }
// }


//try -multiple catch blocks - finally.
// try{
//     ----
//     ----
//     ----
// }catch(...){
//     ----
//     ----
// }catch(...){
//     ----
//     ----
// }finally{
//     ----
//     ----
//     ----
// }


// public class Exceptions {

//     public static void main(String[] args) {
//         try {
//             int a[]={10,2,8,3,5};
//             int r=a[0]/a[1];
//             System.out.println(r);
//             System.out.println(a[10]);
            
//         } catch (ArithmeticException e) {
//             System.out.println(e);
//         }catch(ArrayIndexOutOfBoundsException e){
//             System.out.println(e);
//         }
        
//     }
// }

//Nested - try-catch
// public class Exceptions { 
// public static void main(String[] args) {
// try{
//     int a[]={10,0,8,3,5};
    
//         try{
//             int r=a[0]/a[1];
//             System.out.println(r);
//         }catch(ArithmeticException e){
//             System.out.println(e);
//         }
//         System.out.println(a[10]);
//         }catch(ArrayIndexOutOfBoundsException e){
//             System.out.println(e);
//         }    
//     }
// }

//finally block : we can have finally block at the end of catch block or we can just have try-finally block.
//If there is an Exception catch blocks get executed if there is no exception catch block doesn't get executed.
//but finally block get executed in every case.
//mostly it is used for claean up process.

//Exception class.
//Buit in Exception classes.
//Heirarchy.
//Top Most class is  - Object  is mother class of all java classes.
//From top class a sub class is there i.e, Throwable.
//Throwable has two sub classes.
//Exception&Error.
//Exception has its own subclass.
//Error has its own subclass but it is all handled by JVM will handle itself.
//Exception classes.
//-ClassNotFoundException.
//-IOException.
//-InterruptedException
//-NumbersFormatException
//-RuntimeException.-----
//Run time Exception classes
//--ArithmeticException.
//--IndexOutOfBoundException.
//-NullPointerException.

//All Exceptions are classified into two:
//Checked Exceptions. means you must handle them using try and catch.
//Unchecked Exceptions.   means java will not force you to handle it.Mostly RuntimeException.

//if you multiple try catch block.
//try{
//   ----
//   ----
//}
//catch(----)
//{
//    ----
//    ----
//}
//catch(----)
//{
//
//}

//remeber the top catch block should be subclass and down catch block should be super class.

// try {
//     // risky code
// } catch (ArithmeticException e) {        // Subclass first ✅
//     System.out.println(e);
// } catch (Exception e) {                  // Superclass last ✅
//     System.out.println(e);
// }


//class Exception
//.String getMessage()-This message returns a string containing message about a exception. 
//try {
//     int result = 10 / 0;
// } catch (ArithmeticException e) {
//     System.out.println(e.getMessage()); 
//     // Output: / by zero
// }
//.String toString()-Returns a string containing the exception class name + message.
// try {
//     int[] arr = new int[5];
//     arr[10] = 1;
// } catch (ArrayIndexOutOfBoundsException e) {
//     System.out.println(e.toString()); 
//     // Output: java.lang.ArrayIndexOutOfBoundsException: Index 10 out of bounds for length 5
// }
//void printStackTrace()-Prints the full stack trace to the console — shows the chain of method calls that led to the exception. Returns nothing (void).
// try {
//     String s = null;
//     s.length(); // NullPointerException
// } catch (NullPointerException e) {
//     e.printStackTrace();
//     // Output:
//     // java.lang.NullPointerException: Cannot invoke "String.length()" because "s" is null
//     //     at Main.main(Main.java:4)
// }

//User Defined Exception.


// class MinBalanceException extends Exception
// {
//     public String toString(){
//         return "Minimum balance should be 5000 try again with bigger amount";
//     }
// }

//Code for Checked and Unchecked Exceptions.
// public class Exceptions {

//     static void fun1()
//     {
//        System.out.println(10/0);
//     }
//     static void fun2()
//     {
//         fun1();
//     }
//     static void fun3()
//     {
//         fun2();
//     }
//     public static void main(String[] args) {
//         fun3();
//     }
// }

// public class Exceptions {

//     static void fun1()
//     {
//         try{
//        System.out.println(10/0);
//         }
//         catch(Exception e)
//         {
//          System.out.println(e.getMessage());
//         }
//     }
//     static void fun2()
//     {
//         fun1();
//     }
//     static void fun3()
//     {
//         fun2();
//     }
//     public static void main(String[] args) {
//         fun3();
//     }
// }

//Checked Exception:

// class LowBalanceException extends Exception
// {
//     public String toString()
//     {
//         return "Balance should not be less than 5000";
//     }
// }
// public class Exceptions {

//     static void fun1()
//     {
//         try{
//        throw new LowBalanceException();
//         }
//         catch(LowBalanceException e)
//         {
//             System.out.println(e);
//         }
//     }
//     static void fun2()
//     {
//         fun1();
//     }
//     static void fun3(){
//         fun2();
//     }
// public static void main(String[] args) {
//     fun3();
// }
// }

//-------------------Throw vs Throws-------------------
// public class Exceptions {
// static int meth2(int a,int b){
//     int c;
//     c=a/b;
//     return c;
// }
// static void meth1()
// {
//     int r = meth2(10, 0);
//     System.out.println(r);
// }
// public static void main(String[] args) {
//     meth1();
// }
// }

// public class Exceptions {

//     static int area(int l, int b) throws Exception {
//         if (l < 0 || b < 0) {
//             throw new Exception("Length and breadth must be non-negative!"); // ✅ semicolon added
//         }
//         int a = l * b;
//         return a;
//     }

//     static void meth1() {
//         try {                                    // ✅ checked exception handled
//             int a = area(-10, 5);
//             System.out.println("Area: " + a);
//         } catch (Exception e) {
//             System.out.println("Exception: " + e.getMessage());
//         }
//     }

//     public static void main(String[] args) {
//         meth1();
//     }
// }

//User defined Exception Class
// class NegativeDimensionException extends Exception
// {
//     public void String toString(){
//         return "Dimensins cannot be negative!";
//     }
// }
// int area(int l,int b) throws NegativeDimensionException
// {
//     if(l<0||b<0){
//         throw new NegativeDimensionException();
//     }
//     int a = l*b;
//     return a;
// }

//Demo Throw and Throws 
// public class Exceptions {

//     static int meth1(){
//         return 10/0;
//     }
//     static void meth2()
//     {
//         meth1();
//     }
//     static void meth3(){
//         meth2();
//     }
//     public static void main(String[] args) {
//         try
//         {
//         meth3();
//         }
//         catch(Exception e){
//             System.out.println(e);
//         }
//     }
// }

//Demo of Throw and Throws:
// class NegativeDimensionsException extends Exception
// {
//     public String toString()
//     {
//         return "Dimensions of a Rectangle cannot be negative";
//     }
// }
// public class Exceptions {

//     static int area(int l,int b) throws NegativeDimensionsException
//     {
//         if(l<0||b<0){
//             throw new NegativeDimensionsException();
//         }
//      return l*b;
//     }
//     static void meth1() throws NegativeDimensionsException
//     {
//         System.out.println(area(-10, 2));
//     }
//     public static void main(String[] args)
//      {
//         try{
//         meth1();
//         }
//         catch(Exception e){
//             System.out.println(e);
//         }
//     }
//}

//Demo finally
// public class Exceptions {

//     public static void main(String[] args) {
//         try
//         {
//         System.out.println(10/0);
//         }
//         catch(ArithmeticException e)
//         {
//             System.out.println(e);
//         }
//         finally {
//         System.out.println("Final Message");
//         }
//     }
// }

// public class Exceptions{
//     static void meth1() throws Exception
//     {
//         try
//         {
//             throw new Exception();
//         }
//         finally 
//         {
//           System.out.println("fINAL Message");
//         }
//     }
//     public static void main(String[] args) throws Exception
//      {
//         meth1();
//     }
    
//}

//Try with Resources - is new feature in Java.
//Major issues in programming is when resource is not in use close it or majorly release it.
//In java has builtin garbage collector to clear the resource of heap.

// import java.io.FileReader;

// int method() throws Exception
// {
//     FileReader f;
//     f= new FileReader("my.txt");
//     //use file
//     f.close();
    
// }

//how to always close the resource.

// import java.io.FileReader;

// int meth1() throws Exception
//  {
//     FileReader f;
//     try
//     {
//         f= new FileReader("my.txt");
//         //use file.
//     }
//     finally
//     {
//         f.close();
//     }
//  }


//In this code try is handling the closing part. 
// int meth1() throw Exception
// {
//     try(FileReader f = new FileReader("my.txt"))
//  {
//     //use file
//     return result;
//  }
// }


// import java.util.*;


// import java.io.*;
// public class Exceptions {

//    static FileInputStream fi;
//    static Scanner sc;
//     static void Divide() throws Exception
//     {
//         fi=new FileInputStream("C:/Users/anky2/Test.txt");
//         try {
//         sc = new Scanner(fi);
//         int a = sc.nextInt();
//         int b= sc.nextInt();
//         int c = sc.nextInt();
//         System.out.println(a/c);
//         }
//         finally 
//         {
//         fi.close();
//         sc.close();
//     }
// }
//     public static void main(String[] args) throws Exception
//     {
//         try{
//         Divide();
//         }
//         catch(Exception e)
//         {
//             System.out.println(e); 
//         }
//         int x= sc.nextInt();
//         System.out.println(x);
//     }
// }


//Now Let's try with resources.

// import java.io.FileInputStream;
// import java.net.Socket;
// import java.nio.channels.Pipe.SourceChannel;
// import java.util.Scanner;

// public class Exceptions {

//     static void Divide() throws Exception
//     {
//         try(FileInputStream fi= new FileInputStream("C:/Users/anky26/Test.txt");Scanner sc = new Scanner(fi));
//     {
//         int a = sc.nextInt();
//         int b = sc.nextInt();
//         int c = sc.nextInt();
//         System.out.println(a/c);
//     }
// }
// public static void main(String[] args) {
//     try
//     {
//         Divide();
//     }
//     catch(Exception e)

//     {
//         System.out.println(e);
//     }
// }

// }

//User defined Exception 
//we will develop a class stackunderflow and stackoverflow 
//define two classes and also override tostring method.and push and pop method.
class StackOverFlowException extends Exception{
    @Override
    public String toString(){
        return "StackOverFlowException: Stack is full! Cannot push more elements.";
    }
}
class StackUnderFlowException extends Exception{
    @Override
    public String toString(){
        return "StackUnderFlowException: Stack is empty! Cannot pop elements.";
    }
}
class Stack {
    int[] data;
    int top;
    int capacity;
    Stack(int capacity){
        this.capacity=capacity;
        data= new int[capacity];
        top=-1; //-1 means stack is empty.
    }


void push(int value) throws StackOverFlowException{
    if(top==capacity-1){
        throw new StackOverFlowException();
    }
    data[++top]=value;
    System.out.println(value + "pushed successfully.");
}
int pop() throws StackUnderFlowException{
    if(top == -1){
        throw new StackUnderFlowException();
    }
    int val = data[top--];
    System.out.println(val + " popped successfully.");
    return val;
}
}
public class Exceptions {
public static void main(String[] args) {
    Stack s = new Stack(3);
    try{
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);
    }catch(StackOverFlowException e){
        System.out.println(e);
    }
    System.out.println("------------");
    try {
        s.pop();
        s.pop();
        s.pop();
        s.pop();
    } catch (StackUnderFlowException e) {
        // TODO: handle exception
        System.out.println(e);
    }
}
     
}