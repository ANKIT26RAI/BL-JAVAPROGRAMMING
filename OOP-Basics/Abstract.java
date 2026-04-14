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
abstract class Hospital {
    abstract void doctor();
    abstract void nurse();
    abstract void patient();
    abstract void ambulance();
    abstract void operation();
    abstract void pharmacy();
    abstract void medicine();
}
class MyHospital extends Hospital{
    void doctor(){
        System.out.println("Doctor is available in the hospital");
    }
    void nurse(){
        System.out.println("Nurse is available in the hospital");
    }
    void patient(){
        System.out.println("Patient is available in the hospital");
    }
    void ambulance(){
        System.out.println("Ambulance is available in the hospital");
    }
    void operation(){
        System.out.println("Operation is available in the hospital");
    }
    void pharmacy(){
        System.out.println("Pharmacy is available in the hospital");
    }
    void medicine(){
        System.out.println("Medicine is available in the hospital");
    }
}
public class Abstract {

    public static void main(String[] args) {
        Hospital h = new MyHospital();
        h.doctor();
        h.nurse();
        h.patient();
        h.ambulance();
        h.operation();
        h.pharmacy();
        h.medicine();
    }
}