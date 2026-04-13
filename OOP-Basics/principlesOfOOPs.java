import java.util.Scanner;
//Principles of OOPs
//1. Abstraction : Hiding the internal details and showing only the required features of an object.
//2. Encapsulation : Hiding inside a single box. It is the process of wrapping code and data together into a single unit. It helps to protect the data from unauthorized access and modification.
//3. Inheritance (Specialization): It is the process by which one class acquires the properties and behaviors of another class. It promotes code reusability and establishes a natural hierarchical relationship between classes.
//4. Polymorphism (Generalization): It is the ability of an object to take on many forms. It allows objects of different classes to be treated as objects of a common superclass. It is achieved through method overriding and method overloading.  
import java.util.concurrent.CyclicBarrier;

//Difference between class and object.
//Anything in the world you can called is an Object.
//In OOPS, we define Object in terms of its proerties and behaviors.
//Class is a blueprint/design/template for creating objects. It defines the properties and behaviors that the objects created from the class will have. An object is an instance of a class. It is a specific realization of a class with actual values for the properties defined in the class.
//Object is a real entity that has a state and behavior. It is an instance of a class.
// A class is a blueprint or template for creating objects. It defines the properties and behaviors that the objects created from the class will have. An object is an instance of a class. It is a specific realization of a class with actual values for the properties defined in the class. 
//From single class, we can create multiple objects. Each object will have its own state and behavior, but they will all share the same properties and behaviors defined in the class.  
//We create Properties as a variable/Data member/Field.
//Behaviors as a method/Function in the class. 
//How it looks in memory?
//Class is a blueprint, it is not stored in memory. It is used to create objects and objects are stored in memory. Each object has its own memory space to store its state (properties) and behavior (methods). When we create an object from a class, memory is allocated for that object to store its state and behavior. The class itself is not stored in memory, but the objects created from the class are stored in memory. Each object has its own memory space to store its state and behavior, and they can interact with each other through their methods.   
//How to write a class in Java?
//1.Circle.
// class Circle{
//     public double radius;
//     public double area(){
//         return Math.PI * radius * radius;
//     }
//     public double perimeter(){
//         return 2 * Math.PI * radius;
//     }
//     public double diameter(){
//         return 2 * radius;
//     }  
//     public double circumference(){
//         return perimeter();
//     }
// }
// public class principlesOfOOPs{
//     public static void main(String[] args) {
//         Circle c1 = new Circle();
//         Circle c2 = new Circle();
//         c1.radius=7;
//         c2.radius=14;
//         System.out.println("-----------Circle C1 ------------");
//         System.out.println("Area : "+ c1.area());
//         System.out.println("Perimeter : "+c1.perimeter());
//         System.out.println("Diameter : "+c1.diameter());
//         System.out.println("Circumference : "+c1.circumference() );
//         System.out.println("----------Circle C2 ----------");
//          System.out.println("Area : "+ c2.area());
//         System.out.println("Perimeter : "+c2.perimeter());
//         System.out.println("Diameter : "+c2.diameter());
//         System.out.println("Circumference : "+c2.circumference() );
//     }
// }
//2.Rectangle
// class Rectangle{
//     public double length;
//     public double breadth;
//     public double area(){
//         return length * breadth;
//     }
//     public double perimeter(){
//         return 2 * (length + breadth);
//     }
//     public boolean isSquare(){
//         if(length==breadth)
//             return true;
//         return false;
//     }
// }
// public class principlesOfOOPs{
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         Rectangle r1 = new Rectangle();
//         Rectangle r2 = new Rectangle();
//         System.out.println("-------------Enter the length and breadth of rectangle 1--------");
//         r1.length= sc.nextDouble();
//         r1.breadth=sc.nextDouble();

//          System.out.println("----------Rectangle R1 ------------");
//         System.out.println("Area : "+ r1.area());
//         System.out.println("Perimeter : "+ r1.perimeter());
//         System.out.println("isSquare : "+r1.isSquare());

//         System.out.println("-----------Enter the length and breadth of Rectangle 2------------");
//         r2.length=sc.nextDouble();
//         r2.breadth=sc.nextDouble();

       
        
//         System.out.println("----------Rectangle R2 ------------");
//         System.out.println("Area : "+ r2.area());
//         System.out.println("Perimeter : "+ r2.perimeter());
//         System.out.println("isSquare : "+r2.isSquare());
        
//     }
// }

//3.Cylinder.
// class Cylinder{
//     public double radius;
//     public double height;
//     public double lidArea(){
//         return Math.PI*radius*radius;
//     }
//     public double totalsurfaceArea(){
//         return 2*Math.PI*radius*(height+radius);


//     }
//     public double volume(){
//         return lidArea()*height;
//     }
// }
// public class principlesOfOOPs{
// public static void main(String[] args) {
//     Scanner sc = new Scanner(System.in);
//     Cylinder c1 = new Cylinder();
//     Cylinder c2 = new Cylinder();

//     System.out.println("---------Enter the radius and height of Cylinder c1---------");
//     c1.height= sc.nextDouble();
//     c1.radius = sc.nextDouble();
//     System.out.println("-----Cylinder c1------");
//     System.out.println("lidArea :" + c1.lidArea());
//     System.out.println("totalSurface :"+ c1.totalsurfaceArea());
//     System.out.println("Volume : "+ c1.volume());

    
//     System.out.println("---------Enter the radius and height of Cylinder c2---------");
//     c2.height= sc.nextDouble();
//     c2.radius = sc.nextDouble();
//      System.out.println("-----Cylinder c2------");
//     System.out.println("lidArea :" + c2.lidArea());
//     System.out.println("totalSurface :"+ c2.totalsurfaceArea());
//     System.out.println("Volume : "+ c2.volume());
// }
// }

//4.Student.
// class Student{
//     public int rollno;
//     public String name;
//     public String courseName;
//     public int m1,m2,m3;
//     public int total(){
//         return m1+m2+m3;
//     }
//     public float average(){
//         return total()/3.0f;
//     }
// }
// public class principlesOfOOPs{
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         Student s1 = new Student();
//         Student s2 = new Student();

//         System.out.println("---------Enter the details of student 1---------");
//         s1.rollno= sc.nextInt();
//         s1.name = sc.next();
//         s1.courseName = sc.next();
//         s1.m1= sc.nextInt();
//         s1.m2= sc.nextInt();
//         s1.m3= sc.nextInt();

//         System.out.println("-----Student 1------");
//         System.out.println("Roll No : "+s1.rollno);
//         System.out.println("Name : "+s1.name);
//         System.out.println("Course Name : "+s1.courseName);
//         System.out.println("Total Marks : "+s1.total());
//         System.out.println("Average Marks : "+s1.average());

        
//         System.out.println("---------Enter the details of student 2---------");
//         s2.rollno= sc.nextInt();
//         s2.name = sc.next();
//         s2.courseName = sc.next();
//         s2.m1= sc.nextInt();
//         s2.m2= sc.nextInt();
//         s2.m3= sc.nextInt();

//          System.out.println("-----Student 2------");
//          System.out.println("Roll No : "+s2.rollno);
//          System.out.println("Name : "+s2.name);
//          System.out.println("Course Name : "+s2.courseName);
//          System.out.println("Total Marks : "+s2.total());
//          System.out.println("Average Marks : "+s2.average());
//     }
// }

//5.Account.
// class Account{
//     public long accountNumber;
//     public String name;
//     public double balance;
//     public double deposit(double amt){

//     }
//     public double withdraw(double amt){

//     }
// }


//Car.
// class Car{
//     public String name;
//     public String regNo;
//     public String col;
//     public double fuelQty;
//     public void start(){};
//     public void stop(){};
//     public void accelerate(){};
//     public void brake(){};
// }

//Television.
// class Television{
//     public String brand; 
//     public String model;
//     public int size;
//     public void turnOn(){};
//     public void turnOff(){};
//     public void changeChannel(){};
//     public void adjustVolume(){};
// }



//Data Hiding : It is the process of hiding the internal details and showing only the required features of an object. It is achieved through access modifiers (private, protected, public) and getter/setter methods. It helps to protect the data from unauthorized access and modification.   
//How to hide data in Java?
class Account{
    private long accountNumber;
    private String name;
    private double balance;
    //for accessing the private data members, we need to create getter and setter methods.
    public long getAccountNumber(){
        return accountNumber;
    }
    public String getName(){
        return name;
    }
    public double getBalance(){
        return balance;
    }
    public void setAccountNumber(long accountNumber){
        this.accountNumber=accountNumber;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setBalance(double balance){
        this.balance=balance;
    }
    public double deposit(double amt){
        balance+=amt;
        return balance;
    }
    public double withdraw(double amt){
        if(amt>balance){
            System.out.println("Insufficient balance");
            return balance;
        }
        balance-=amt;
        return balance;
    }
}
public class principlesOfOOPs{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Account a1 = new Account();
        System.out.println("---------Enter the details of account 1---------");
        a1.setAccountNumber(sc.nextLong());
        a1.setName(sc.next());
        a1.setBalance(sc.nextDouble());

        System.out.println("-----Account 1------");
        System.out.println("Account Number : "+a1.getAccountNumber());
        System.out.println("Name : "+a1.getName());
        System.out.println("Balance : "+a1.getBalance());

        System.out.println("Enter the amount to deposit : ");
        double amt = sc.nextDouble();
        System.out.println("Balance after deposit : "+a1.deposit(amt));

        System.out.println("Enter the amount to withdraw : ");
        amt = sc.nextDouble();
        System.out.println("Balance after withdrawal : "+a1.withdraw(amt));
    }
}
