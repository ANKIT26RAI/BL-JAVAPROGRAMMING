import java.util.Scanner;
//What is Interface in Java?
//Interface is used to achieve polymorphism in Java. It is a blueprint of a class that contains static constants and abstract methods. An interface cannot be instantiated, meaning you cannot create an object of an interface. Instead, you must create a class that implements the interface and provides implementations for the abstract methods. Interfaces are used to provide a common base for related classes and to define a common interface for those classes.
//An interface can contain only abstract methods and static constants. It cannot contain any concrete methods (methods with a body). However, from Java 8 onwards, interfaces can also contain default methods (methods with a body) and static methods. Default methods are methods that have a default implementation and can be overridden by the implementing class. Static methods are methods that belong to the interface and can be called without an instance of the interface.
//You can not create object of an interface.
// abstract class Test{
//     abstract public void method();
//     abstract public void method1();
// }
// class Test1 extends Test{
//     public void method(){
//         System.out.println("Method 1 is implemented");
//     }
//     public void method1(){
//         System.out.println("Method 2 is implemented");
//     }
// }
//Interface can called abstract class with all abstract methods. It is used to achieve multiple inheritance in Java. A class can implement multiple interfaces, but it can only extend one class (abstract or concrete). This allows for greater flexibility in designing classes and promotes code reusability. Interfaces are also used to define a common interface for unrelated classes, allowing them to be treated polymorphically.  
// interface Test{
//     void method1();
//     void method2();
// }
// class Test2 implements Test{
//     public void method1(){
//         System.out.println("Method 1 is implemented");
//     }
//     public void method2(){
//         System.out.println("Method 2 is implemented");
//     }
// }
// public class Interface {

//     public static void main(String[] args) {    
//         Test t = new Test2(); // This is allowed because we are creating an object of a concrete class that implements the interface
//         t.method1(); // This will call the method1 of the Test2 class
//         t.method2(); // This will call the method2 of the Test2 class
//     }
// }
//Multiple inheritance vs Interface in Java?
//Example of Interface in Java?
//Do_s and Don'ts of Interface in Java?

//SmartPhone example of Interface in Java
class Phone{
    void call(){
        System.out.println("Calling...");
    }
    void message(){
        System.out.println("Messaging...");
    }
}
interface Camera{
    void click();
    void record();
}
interface MusicPlayer{
    void play();
    void pause();
    void stop();
}
class SmartPhone extends Phone implements Camera, MusicPlayer{
    public void click(){
        System.out.println("Clicking...");
    }
    public void record(){
        System.out.println("Recording...");
    }
    public void play(){
        System.out.println("Playing music...");
    }
    public void pause(){
        System.out.println("Pausing music...");
    }
    public void stop(){
        System.out.println("Stopping music...");
    }
    public void videoCall(){
        System.out.println("Video calling...");
    }
    public void browse(){
        System.out.println("Browsing...");
    }
}
public class Interface {

    public static void main(String[] args) {
        SmartPhone sp = new SmartPhone();
        sp.call();
        sp.message();
        sp.click();
        sp.record();
        sp.play();
        sp.pause();
        sp.stop();
        sp.videoCall();
        sp.browse();
    }
}
