import java.util.Scanner;
//What is Abstract class in Java?
//There are two types of classes in Java: Concrete class and Abstract class. A concrete class is a regular class that can be instantiated, while an abstract class is a class that cannot be instantiated and is meant to be subclassed. An abstract class can contain abstract methods (methods without a body) that must be implemented by any concrete subclass. Abstract classes are used to provide a common base for related classes and to define a common interface for those classes.
//You can not create object of an abstract class.
//Abstract Method.A method is not having body is called abstract method. It is declared using the abstract keyword and does not have a body. Abstract methods must be implemented by any concrete subclass of the abstract class. For example:
//Abstract class is a class that is declared with the abstract keyword. It can have abstract methods (methods without a body) and concrete methods (methods with a body). An abstract class cannot be instantiated, meaning you cannot create an object of an abstract class. Instead, you must create a subclass that extends the abstract class and provides implementations for the abstract methods. Abstract classes are used to provide a common base for related classes and to define a common interface for those classes. 
//if an class is inherited from an abstract class then it must implement all the abstract methods of the abstract class otherwise it will also be declared as abstract class.

// abstract class Super{
//      public Super(){
//         System.out.println("Super class constructor");  
//     }
//     public void display(){
//         System.out.println("Super class method");
//     }
//     abstract public void method();
// }
// class Sub extends Super{
//     public Sub(){
//         System.out.println("Sub class constructor");
//     }
//     public void method(){
//         System.out.println("Sub class method");
//     }
// }
// public class Abstract {

//     public static void main(String[] args) {
//         //Super s = new Super(); // This will give an error because we cannot create an object of an abstract class
//        Super s = new Sub(); // This is allowed because we are creating an object of a concrete subclass of the abstract class
//        s.display(); // This will call the display method of the Super class
//        s.method(); // This will call the method of the Sub class because it is overridden in the Sub class    

//     }
// }

//Why we need Abstract class in Java?
//Real life example of Abstract class in Java?
//Abstract classes are useful in Java for several reasons:
// abstract class Hospital {
//     abstract void doctor();
//     abstract void nurse();
//     abstract void patient();
//     abstract void ambulance();
//     abstract void operation();
//     abstract void pharmacy();
//     abstract void medicine();
// }
// class MyHospital extends Hospital{
//     void doctor(){
//         System.out.println("Doctor is available in the hospital");
//     }
//     void nurse(){
//         System.out.println("Nurse is available in the hospital");
//     }
//     void patient(){
//         System.out.println("Patient is available in the hospital");
//     }
//     void ambulance(){
//         System.out.println("Ambulance is available in the hospital");
//     }
//     void operation(){
//         System.out.println("Operation is available in the hospital");
//     }
//     void pharmacy(){
//         System.out.println("Pharmacy is available in the hospital");
//     }
//     void medicine(){
//         System.out.println("Medicine is available in the hospital");
//     }
// }
// public class Abstract {

//     public static void main(String[] args) {
//         Hospital h = new MyHospital();
//         h.doctor();
//         h.nurse();
//         h.patient();
//         h.ambulance();
//         h.operation();
//         h.pharmacy();
//         h.medicine();
//     }
// }

// abstract class KFC{
//     KFC(){
//         System.out.println("KFC constructor");
//     }
//     void welcome(){
//         System.out.println("Welcome to KFC");
//     }
//     void menu(){
//         System.out.println("Menu is available in KFC");
//     }
//     void order(){
//         System.out.println("Order is available in KFC");
//     }
//     abstract void billing();
//     abstract void payment();
//     abstract void delivery();
//     abstract void feedback();
//     abstract void offers();

// }
// class MyKFC extends KFC{
//     void billing(){
//         System.out.println("Billing is available in KFC");
//     }
//     void payment(){
//         System.out.println("Payment is available in KFC");
//     }
//     void delivery(){
//         System.out.println("Delivery is available in KFC");
//     }
//     void feedback(){
//         System.out.println("Feedback is available in KFC");
//     }
//     void offers(){
//         System.out.println("Offers are available in KFC");
//     }
//     void festivalOffers(){
//         System.out.println("Festival offers are available in KFC");
//     }
// }   
// public class Abstract {

//     public static void main(String[] args) {
//         KFC k = new MyKFC();
//         k.welcome();
//         k.menu();
//         k.order();
//         k.billing();
//         k.payment();
//         k.delivery();
//         k.feedback();
//         k.offers();

//         k.festivalOffers(); // This will give an error because festivalOffers() is not defined in the KFC class
//     }
// }
//STUDENT CHALLENGE
//Take a class Shape as an abstract class and create three subclasses Circle, Rectangle and Triangle. Each subclass should have its own implementation of the area() method to calculate the area of the shape. Then, create objects of each subclass and call the area() method to display the area of each shape.
//Do_s and Don'ts of Abstract class in Java
//Do's of Abstract class in Java:   
//1. Use abstract classes when you want to provide a common base for related classes and define a common interface for those classes.
//2. Use abstract methods to define methods that must be implemented by any concrete subclass of the abstract class.
//3. Use abstract classes to provide a common implementation for related classes, while still allowing for specific implementations in the subclasses.  
//Don'ts of Abstract class in Java:
//1. Do not create objects of an abstract class, as it cannot be instantiated.  
//2. Do not declare a class as abstract if it does not contain any abstract methods, as this can lead to confusion and is not necessary.    
//3. Do not use abstract classes if you do not need to provide a common base for related classes or if you do not need to define a common interface for those classes, as this can lead to unnecessary complexity in your code. 
 

//Rules for Abstract class in Java:
//1. An abstract class cannot be instantiated, meaning you cannot create an object of an abstract class.
//2. An abstract class can contain both abstract methods (methods without a body) and concrete methods (methods with a body).
//3. If a class is declared as abstract, it must be extended by a concrete subclass that provides implementations for all the abstract methods of the abstract class, otherwise the subclass must also be declared as abstract.
//4. An abstract class can have constructors, but they cannot be used to create objects of the abstract class. Instead, they can be called from the constructors of the concrete subclasses to initialize the state of the object.  
