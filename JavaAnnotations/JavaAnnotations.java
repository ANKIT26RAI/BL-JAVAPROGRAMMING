/**@author Ankit Rai
 * @version 2.0
 * @since 2026
 **/

import java.util.List;

/**
 * 
 * @author AnkitRai
 */
// public class Book
// {
//     static int val =10;
//     public Book (String s){

//     }
//     public void issue(int roll) throws Exception{

//     }
//     public boolean available(String str){
//         return true;
//     }
//     public String getName(int id){
//         return ""; 
//     }
// }
// public class JavaAnnotations {
// public static void main(String[] args) {
    
// }    
// }


//JavaDoc Tags
//Class Tags

// @author – Specifies the author of the class
// @version – Indicates the version of the class
// @since – Specifies when the class was introduced
// @see – Adds a "See Also" reference link

//Method Tags

// @param – Describes a method parameter
// @return – Describes the return value of a method
// @throws – Documents an exception the method may throw
// @exception – Alias for @throws
// @deprecated – Marks the method as outdated/no longer recommended
// @code – Displays text in code font (used inline)

//Others

// @link – Creates an inline hyperlink to another class/method
// @value – Displays the value of a static field
// @serial – Used for documenting serializable fields



//Annotations are used for giving attributes or defining attributes for class ,inteface and methods.
//Annotations is used for metadata.

//Built-in Annotations given in java.
//1. Applied To Code.
//2. Applied to Other Annotations.


//1.Those Annotations which are applied on code:
//in-built Annotations:
//1.@Override.
//Tells the compiler that the method is overriding a parent class method.
//Gives a compile-time error if the method doesn't actually override anything.
//  class Parent {
//      public void display(){
//         System.out.println("Annotations");
//      };
// }
// class Child extends Parent{
//      @Override
//     public void display(){
//         System.out.println("Override Annotations");

//     }
// }
// public class JavaAnnotations {

//     public static void main(String[] args) {
//         Child c = new Child();
//         c.display();
//     }
// }
//2.@Deprecated.
// Marks a method/class as outdated / no longer recommended
// Compiler gives a warning when it's used

// class OldClass
// {
//     public void display()
//     {
//         System.out.println("Hello");
//     }
//     @Deprecated
//     public void show()
//     {
//         System.out.println("Hi");
//     }
// }
// public class JavaAnnotations {
// public static void main(String[] args) {
//      OldClass OC = new OldClass();
//      OC.show();
// }
    
// }

//3.@FunctionalInterface.

//4.@SuppressWarnings.
// class OldClass
// {
//     public void display()
//     {
//         System.out.println("Hello");
//     }
//     @Deprecated
//     public void show()
//     {
//         System.out.println("Hi");
//     }
// }
// public class JavaAnnotations {
//         @SuppressWarnings("deprecation")

// public static void main(String[] args) {
//      OldClass OC = new OldClass();
//      OC.show();
// }
// }

// class OldClass
// {
//     public void display()
//     {
//         System.out.println("Hello");
//     }
//     @Deprecated
//     public void show()
//     {
//         System.out.println("Hi");
//     }
// }
// public class JavaAnnotations {
//     static List l;
//     //@SuppressWarnings("deprecation")
//     @SuppressWarnings("unchecked")

// public static void main(String[] args) {
//     l.add(10);
//     //  OldClass OC = new OldClass();
//     //  OC.show();
// }
// }
//5.@SafeVarargs.
// Suppresses unchecked warnings related to varargs (variable arguments) with generics
// Applied on methods/constructors with final, static, or constructors

class My<T>
{
private void show(T...arg)
{
    @SafeVarargs
    for(T x:arg)
        System.out.println(x);
}
}
public class JavaAnnotations {
public static void main(String[] args) {
    
}
    
}