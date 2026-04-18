
// abstract class Shape{
//     abstract double area();

//     abstract double perimeter();
// }
// class Circle extends Shape{
//     private   double radius;
//     Circle( double radius){
//         this.radius=radius;

//     }
//     public double getRadius(){
//         return radius;
//     }
//     public double setRadius(double radius){
//         if(radius>0){
//             this.radius=radius;
//     }else{
//         System.out.println("Invalid radius");
//     }
//         return radius;
//     }
//     @Override
//     double area(){
//         return Math.PI*radius*radius;
//     }
//     double perimeter(){
//         return 2*Math.PI*radius;
//     }
//     double area(double r){
//         return Math.PI*r*r;
//     }
// }
// public class Allfour {

//     public static void main(String[] args) {
//         Circle c = new Circle(5);
//         System.out.println("Radius :" + c.getRadius());
//         System.out.println("Area :" + c.area());
//         System.out.println("Perimeter: "+ c.perimeter());
         
//         System.out.println("Overload radius "+ c.area(10));
//     }
// }

//static variable code:
class Circle{
    private static double radius;
     Circle( double radius){
        Circle.radius=radius;

    }
    public double getRadius(){
        return radius;
    }
    public double setRadius(double radius){
        if(radius>0){
            Circle.radius=radius;
    }else{
        System.out.println("Invalid radius");
    }
        return radius;
    }
    double area(){
        return Math.PI*radius*radius;
    }
    double perimeter(){
        return 2*Math.PI*radius;
    }
    double area(double r){
        return Math.PI*r*r;
    }
}
public class Allfour {

    public static void main(String[] args) {
        Circle c = new Circle(5);
        System.out.println("Radius :" + c.getRadius());
        System.out.println("Area :" + c.area());
        System.out.println("Perimeter: "+ c.perimeter());
         
        System.out.println("Overload radius "+ c.area(10));
    }
}