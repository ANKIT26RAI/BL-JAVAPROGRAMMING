import java.util.Scanner;
class Circle{
    double radius;
    Circle(double radius){
        this.radius=radius;
    }
    public double area(){
        return Math.PI*radius*radius;
    }
    public double circumference(){
        return 2*Math.PI*radius;
    }

    void display(){
        System.out.println("Area of Circle "+ area());
        System.out.println("Circumference of Circle "+circumference());
    }
}

public class Circ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the radius : ");
        double radius = sc.nextDouble();
        Circle c = new Circle(radius);
        c.display();
    }
}
