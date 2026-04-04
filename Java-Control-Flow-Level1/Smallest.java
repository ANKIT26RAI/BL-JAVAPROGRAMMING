// Write a program to check if the first is the smallest of the 3 numbers. 
// I/P => number1, number2, number3 
// O/P => Is the first number the smallest? ____ 

public class Smallest {
    public static void main(String[] args) {
        int number1 = 5;
        int number2 = 10;
        int number3 = 15;

        boolean isSmallest = (number1 < number2) && (number1 < number3);
        System.out.println("Is the first number the smallest? " + isSmallest);
    }
    
}
