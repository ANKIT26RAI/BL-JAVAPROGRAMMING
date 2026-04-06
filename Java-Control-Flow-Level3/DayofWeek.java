import java.util.Scanner;

public class DayofWeek {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter month (1-12) : ");
        int m = sc.nextInt();

        System.out.print("Enter day          : ");
        int d = sc.nextInt();

        System.out.print("Enter year         : ");
        int y = sc.nextInt();

        // Gregorian calendar formulas (integer division)
        int y0 = y - (14 - m) / 12;
        int x  = y0 + y0/4 - y0/100 + y0/400;
        int m0 = m + 12 * ((14 - m) / 12) - 2;
        int d0 = (d + x + 31 * m0 / 12) % 7;

        // Day name
        String day;
        if (d0 == 0)      day = "Sunday";
        else if (d0 == 1) day = "Monday";
        else if (d0 == 2) day = "Tuesday";
        else if (d0 == 3) day = "Wednesday";
        else if (d0 == 4) day = "Thursday";
        else if (d0 == 5) day = "Friday";
        else              day = "Saturday";

        System.out.println("\nDay Number : " + d0);
        System.out.println("Day Name   : " + day);

        sc.close();
    }
}