// // Program to Track Inventory of Items 
// // Problem Statement: Create an Item class with attributes itemCode, itemName, and 
// // price. Add a method to display item details and calculate the total cost for a given 
// // quantity. 
// import java.util.Scanner;
// class Item{
//     int itemCode;
//     String itemName;
//     double itemPrice;
//     Item(int iC,String iN,double iP){
//         itemCode=iC;
//         itemName=iN;
//         itemPrice=iP;
//     }
//     int Code(){
//         return itemCode;
//     }
//     String Name(){
//         return itemName;
//     }
    
//     double price(){
//         return itemPrice;
//     }
//     double quanity(int q){
//         return itemPrice*q;
//     }

//     void display(int q){
//         System.out.println("Enter the Item Code "+ Code());
//         System.out.println("Enter the Item Name "+ Name());
//         System.out.println("Enter the Item Price "+ price());
//         System.out.println("Enter the Item Quanity "+ quanity(q));
//     }
// }
// public class InventoryItems {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         System.out.println("Enter the Item Code : ");
//         int iC = sc.nextInt();
//         sc.nextLine(); // Consume the newline character
//         System.out.println("Enter the Item Name : ");
//         String iN = sc.nextLine();
//         System.out.println("Enter the Item Price : ");
//         double iP = sc.nextDouble();
//         System.out.println("Enter the Item Quantity : ");
//         int q = sc.nextInt();
//         Item item = new Item(iC, iN, iP);
//         item.display(q);
//     }
    

// }
