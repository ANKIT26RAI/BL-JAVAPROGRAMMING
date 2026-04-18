//What is need of Inner class in Java?
//To reduce code complexity and increase readability, we can use inner classes in Java. Inner classes are defined within another class and can access the members of the outer class. They are useful for logically grouping classes that are only used in one place, which increases encapsulation and helps to keep the code organized.
//Types of Inner classes in Java:   
//1. Non-static Inner Class (also known as Inner Class)
//2. Static Inner Class (also known as Static Nested Class)
//3. Local Inner Class  
//4. Anonymous Inner Class
//Nested Inner class.
// class OuterClass {
//     int outerField = 10;

//     class InnerClass {
//         int innerField = 20;
//         void display() {
//             System.out.println("Outer field: " + outerField);
//             System.out.println("Inner field: " + innerField);
//         }
//     }
//     void outerDisplay() {
//         InnerClass inner = new InnerClass();
//         inner.display();
//         System.out.println("Accessing inner field from outer class: " + inner.innerField);  
//     }
// }
// public class InnerClass {
// public static void main(String[] args) {
//     OuterClass outer = new OuterClass();
//     outer.outerDisplay();   
//     OuterClass.InnerClass inner = outer.new InnerClass(); // Creating an instance of the inner class
//     inner.display(); // Calling the display method of the inner class   
// }
    
// }

//Local Inner class
// class OuterClass {
//     void outerMethod() {
//         class LocalInnerClass {
//             void display() {
//                 System.out.println("This is a local inner class.");
//             }
//         }
//         LocalInnerClass localInner = new LocalInnerClass();
//         localInner.display();
//     }
// }

//Anonymous Inner class
// interface Greeting {
//     void sayHello();
// }
// public class InnerClass {
//     public static void main(String[] args) {
//         Greeting greeting = new Greeting() {
//             @Override
//             public void sayHello() {
//                 System.out.println("Hello, this is an anonymous inner class!");
//             }
//         };
//         greeting.sayHello();
//     }
// }

//Static Inner class   
// class OuterClass {
//     static int outerStaticField = 30;

//     static class StaticInnerClass {
//         void display() {
//             System.out.println("Outer static field: " + outerStaticField);
//         }
//     }
// }