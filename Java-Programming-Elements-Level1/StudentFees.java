// Write a new program similar to the program # 6 but take user input for Student Fee and 
// University Discount 
// Hint =>  
// a. Create a variable named fee and take user input for fee. 
// b. Create another variable discountPercent and take user input. 
// c. Compute the discount and assign it to the discount variable. 
// d. Compute and print the fee you have to pay by subtracting the discount from the fee. 
// I/P => fee, discountPrecent 
// O/P => The discount amount is INR ___ and final discounted fee is INR ___ 

import java.util.Scanner;
public class StudentFees {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter the student fee: ");
        double fee = input.nextDouble();
        
        System.out.print("Enter the university discount percentage: ");
        double discountPercent = input.nextDouble();
        
        double discount = (fee * discountPercent) / 100;
        double discountedFee = fee - discount;
        
        System.out.println("The discount amount is INR " + discount + " and final discounted fee is INR " + discountedFee);
    }
}
