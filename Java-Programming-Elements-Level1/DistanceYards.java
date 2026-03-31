// . Write a program the find the distance in yards and miles for the distance provided by user in 
// feets 
// Hint => 1 mile = 1760 yards and 1 yard is 3 feet 
// I/P => distanceInFeet 
// O/P => Your Height in cm is ___ while in feet is ___ and inches is ___ 
import java.util.Scanner;
public class DistanceYards {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter distance in feet: ");
        double distanceInFeet = sc.nextDouble();

        double distanceInYards = distanceInFeet / 3;

        double distanceInMiles = distanceInYards / 1760;

        System.out.println("Distance in yards: " + distanceInYards);
        System.out.println("Distance in miles: " + distanceInMiles);

        sc.close();
        
    }
}
