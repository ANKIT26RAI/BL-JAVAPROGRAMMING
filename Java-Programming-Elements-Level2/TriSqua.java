// Write a program that takes the base and height in cm to find the area of a triangle in square
// inches and square centimeters
// Hint => Area of a Triangle is 1⁄2 * base * height and 1 in = 2.54 cm
// I/P => base, height
// O/P => The Area of the triangle in sq in is ___ and sq cm is ___
public class TriSqua {
    public static void main(String[] args) {
        double base = 10; // in cm
        double height = 5; // in cm
        double areaInSqCm = 0.5 * base * height;
        double areaInSqIn = areaInSqCm / (2.54 * 2.54);
        System.out.println("The Area of the triangle in sq in is " + areaInSqIn + " and sq cm is " + areaInSqCm);
    }
    
}
