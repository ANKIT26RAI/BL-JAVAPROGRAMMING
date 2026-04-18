import java.util.Scanner;

//Generalization (Bottom up)& Specialization(top down).
//Specialization is achieved using inheritance.
//Generalization is achieved using interfaces.
//In b/w these exist Abstract classes.

//Inheritance : Acquiring features of existing class into new class.
//For example : Cyclinder acquiring features of circle class.
//Cuboid acquiring features of Rectangle class.

//Inheritance class use extends.
// class Circle{
//     public double radius;
//     public double area(){
//     return 2*Math.PI*radius*radius;
//     }
//     public double perimeter(){
//         return 2*Math.PI*radius;
//     }
//     public  double circumference(){
//         return perimeter();
//     }
// }
// class Cylinder extends Circle{
//     public double height;
//     public double volume(){
//         return area()*height;
//     }
// }
// public class Inherit {

    


//     public static void main(String[] args) {
//         Cylinder c = new Cylinder();
//         c.radius=7;
//         c.height=10;
//         System.out.println("Volume : " + c.volume());
//         System.out.println("Area : "+ c.area());
//        }
// }


//Inheritance :
//class Account{
    
//}

//Constructors in Inheritance :
// class Parent{
//     public Parent(){
//     System.out.println("Parent Constructor");
// }}
// class Child extends Parent{
//     public Child(){
//         System.out.println("Child Constructor");
//     }
// }
// class GrandChild extends Child{
//     public GrandChild(){
//         System.out.println("GrandChild Constructor");
//     }
// }
// public class Inherit {
//     public static void main(String[] args) {
//        // Parent p = new Parent();
//         //Child c = new Child();

//         GrandChild gc = new GrandChild();
//     }
// }

//Parametrized Constructor in Inheritance :
//How to call Parameterized Constructor.
// class Parent{
//      Parent(){
//         System.out.println("Non-Param of Parent");
//     }
//     Parent(int x){
//         System.out.println("Param of Parent "+x);
//     }
// }
// class Child extends Parent{
//     Child(){
//         System.out.println("Non-Param of Child");
//     }
//     Child(int y){
//         System.out.println("Param of child");
//     }
//     Child(int x,int y){
//         super(x); //Calling parent class parameterized constructor.
//         System.out.println(" 2nd Param of child "+y);
//     }
// }
// public class Inherit {

//     public static void main(String[] args) {
//       //  Child c = new Child();
//       Child c = new Child(10,20);
//     }
// }

// class Rectangle{
//     int length;
//     int breadth;
//     Rectangle(){
//         length=breadth=1;
//     }
//     Rectangle(int l,int b){
//         length=l;
//         breadth=b;
//     }
// }
// class Cuboid extends Rectangle{
//     int height;
//     Cuboid(){
//         height=1;

//     }
//     Cuboid(int h){
//         height=h;
//     }
//     Cuboid(int l,int b,int h){
//         super(l,b);
//         height=h;
//     }
//     int volume(){
//         return length*breadth*height;
//     }
// }
// public class Inherit{
//  public static void main(String[] args) {
//     Cuboid c = new Cuboid(10,5,10);
//     System.out.println("Volume :" + c.volume());
//  }   
// }

//this and super keyword.
// class Rectangle{
//     int length;
//     int breadth;
//     Rectangle(int l,int b){
//         this.length=l;
//         this.breadth=b;
//     }
//     void display(){
//         System.out.println("Length : "+this.length);
//         System.out.println("Breadth : "+this.breadth);
//     }
// }
// public class Inherit {

//     public static void main(String[] args) {
//         Rectangle r =new Rectangle(10,5);
//         r.display();
//         Rectangle r2 = new Rectangle(20,10);
//         r2.display();
//     }
// }

//VVIP:IF THEIR IS A CONFLICT BETWEEN NAME OF PROPERTIES OR DATA MEMBERS OF PARENT AND CHILD CLASS THEN THIS KEYWORD REFERS TO CURRENT CLASS OBJECT AND SUPER KEYWORD REFERS TO PARENT CLASS OBJECT.
// super keyword is used to resolve the conflict between parent and child class properties or data members.
// class Rectangle{
//     int length;
//     int breadth;
//     int x=10;
// Rectangle(int length,int breadth){
//     this.breadth= breadth;
//     this.length=length;
// }

// }
// class Cuboid extends Rectangle{
//     int height;
//     int x=20;
//     Cuboid(int l,int b,int h){
//         super(l, h);
//         height=h;
//     }
//     void display(){
//         System.out.println(super.x);
//         System.out.println(x);
//     }

// }
// public class Inherit {

//     public static void main(String[] args) {
//         Cuboid c = new Cuboid(10,20,10);
//         c.display();
//     }
// }

//Method Overriding.
//What is Method Overriding.
//Method overiding is redefining of method of superclass in subclass.
// class Super{
//     public void display(){
//         System.out.println("super class display");
//     }
// }
// class Subclass extends Super{
//     public void display(){
//         System.out.println("subclass display");
//     }
// }
// public class Inherit {

//     public static void main(String[] args) {
//         // Super su = new Super();
//         // su.display();
//         // Subclass sc = new Subclass();
//         // sc.display();
//         Super s= new Subclass();
//         s.display();

//     }
// }
//Why Method Overriding.
//Dynamic Method Dispatch.
//A superclass reference holding an object of subclass and override method is called Dynamic Method Dispatch.   
//The method of object will be called at runtime is called Dynamic Method Dispatch. 
//Rules.
//Overloading vs Overriding.
//  class TV{
//     public void switchOn(){
//         System.out.println("TV is ON");
//     }
//     public void changeChannel(){
//         System.out.println("Channel is changed");
//     }
//  }
//  class SmartTV extends TV{
//     public void switchOn(){
//         System.out.println("Smart TV is ON");
//     }
//     public void changeChannel(){
//         System.out.println("Smart TV: Channel is changed");
//     }
//     public void connectToInternet(){
//         System.out.println("Connected to Internet");
//     }
//  }
//  public class Inherit {
 
//     public static void main(String[] args) {
//         // TV t = new TV();
//         // t.switchOn();
//         // t.changeChannel();
//         // SmartTV st = new SmartTV();
//         // st.switchOn();
//         // st.changeChannel();
//         // st.connectToInternet();
//         // TV t = new SmartTV();
//         // t.switchOn();
//         // t.changeChannel();
//         // t.connectToInternet(); //Compile time error because reference type is TV and TV class does not have connectToInternet method.
//     }
//  }

//Example 2: 
// class Cars{
//     public void start(){
//         System.out.println("Car is starting");
//     }
//     public void accelerate(){
//         System.out.println("Car is accelerating");
//     }
//     public void changeGear(){
//         System.out.println("Car is changing gear");
//     }
// }
// class LuxuryCar extends Cars{
//     public void start(){
//         System.out.println("Luxury Car is starting");
//     }
//     public void accelerate(){
//         System.out.println("Luxury Car is  accelerating");
//     }
//     public void changeGear(){
//         System.out.println("Luxury Car is  automatic changing gear");
//     }
//     public void playMusic(){
//         System.out.println("Playing music");
//     }
//     public void openSunroof(){
//         System.out.println("Opening sunroof");
//     }
// }
// public class Inherit {

//     public static void main(String[] args) {
//         Cars c = new Cars();
//         c.start();
//         c.accelerate();
//         c.changeGear();
//         LuxuryCar lc = new LuxuryCar();
//         lc.start(); 
//         lc.accelerate();
//         lc.changeGear();
//         lc.playMusic();
//         lc.openSunroof();
//         Cars c2 = new LuxuryCar();
//         c2.openSunroof(); //Compile time error because reference type is Cars and Cars class does not have openSunroof method.

//     }
// }

//Dynamic Method Dispatch is used in Runtime Polymorphism.
//Runtime Polymorphism is achieved through method overriding and dynamic method dispatch.   

// class Super{
//     public void display(){
//         System.out.println("super class display");
//     }
//     public void show(){
//         System.out.println("super class show"); 
//     }
//     public void method(){
//         System.out.println("super class method");
//     }
// }
// class Subclass extends Super{
//     public void display(){
//         System.out.println("subclass display");
//     }
//     public void show(){
//         System.out.println("subclass show");
//     }
// }
// public class Inherit {

//     public static void main(String[] args) {
//         Super s = new Subclass();
//         s.display(); //subclass display
//         s.show(); //subclass show
//         s.method(); //super class method
//     }
// }

//A superclass reference can call only those methods which are present in superclass but the actual method which will be called at runtime is determined by the type of object which is referred by superclass reference.   
//In above example s is a reference of Super class but it is referring to an object of Subclass. So at runtime the display and show method of Subclass will be called because the actual type of object is Subclass. But method method is not overridden in Subclass so the method of Super class will be called.   

//Do_s and Don'ts of Method Overriding.
//1. The method in subclass must have the same name, return type and parameters as the method in superclass.
//2. The method in subclass must have the same or more accessibility than the method in superclass. For example if the method in superclass is public then the method in subclass must be public. If the method in superclass is protected then the method in subclass can be protected or public but not private.
//3. The method in subclass cannot throw a checked exception if the method in superclass does not throw any exception or throws a different checked exception. For example if the method in superclass throws IOException then the method in subclass cannot throw FileNotFoundException because it is a checked exception and it is not a subclass of IOException.
//4. The method in subclass can throw any unchecked exception regardless of the exceptions thrown by the method in superclass. For example if the method in superclass throws IOException then the method in subclass can throw NullPointerException because it is an unchecked exception.  


//Polymorphism : Many forms.One name Different forms. 
//Compile time Polymorphism : Method Overloading.
//Runtime Polymorphism : Method Overriding and Dynamic Method Dispatch.
//Overloading vs Overriding.
//Overloading is achieved within the same class but overriding is achieved in different classes which are in inheritance relationship.
//Overloading is resolved at compile time but overriding is resolved at runtime.    
//Code:
// class Test{
//     public int max(int a,int b){
//         return (a>b)?a:b;
//     }
//     public double max(double a,double b){
//         return (a>b)?a:b;
//     }

// }
// public class Inherit {

//     public static void main(String[] args) {
//         Test t = new Test();
//         System.out.println("Max of 10 and 20 is : "+ t.max(10,20));
//         System.out.println("Max of 10.5 and 20.5 is : "+ t.max(10.5,20.5));
//     }
// }

//Compiler decides at compile time which method to call based on the reference type and the parameters passed to the method. In above example when we call t.max(10,20) the compiler will look for a method with name max and parameters of type int and it will find the first method and it will call that method. When we call t.max(10.5,20.5) the compiler will look for a method with name max and parameters of type double and it will find the second method and it will call that method. This is how method overloading works.   
//In method overloading the return type of the method can be different but it is not considered for method signature. The method signature consists of the method name and the parameters but not the return type. So we cannot overload a method based on return type alone. For example if we have two methods with same name and same parameters but different return type then it will result in compile time error because the compiler will not be able to decide which method to call based on the reference type and the parameters passed to the method.   
//Overriding is achieved in different classes which are in inheritance relationship. The method in subclass must have the same name, return type and parameters as the method in superclass. The method in subclass must have the same or more accessibility than the method in superclass. The method in subclass cannot throw a checked exception if the method in superclass does not throw any exception or throws a different checked exception. The method in subclass can throw any unchecked exception regardless of the exceptions thrown by the method in superclass. For example if the method in superclass throws IOException then the method in subclass can throw NullPointerException because it is an unchecked exception. This is how method overriding works.
//Overriding is resolved at runtime. The actual method which will be called at runtime is determined by the type of object which is referred by superclass reference. For example if we have a superclass reference which is referring to an object of subclass then at runtime the method of subclass will be called because the actual type of object is subclass. This is how dynamic method dispatch works. 



