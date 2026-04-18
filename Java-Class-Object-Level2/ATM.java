// 2. Program to Simulate an ATM 
// Problem Statement: Create a BankAccount class with attributes accountHolder, 
// accountNumber, and balance. Add methods for: 
// ● Depositing money. 
// ● Withdrawing money (only if sufficient balance exists). 
// ● Displaying the current balance. 
// Explanation: The BankAccount class stores bank account details as attributes. The 
// methods allow interaction with these attributes to modify and view the account's state. 

// import java.util.Scanner;

// class BankAccount{
//     private String accountHolder;
//    private long accountNumber;
//    private double balance;

//    BankAccount(String accHolder,long accNum,double bal){
//     accountHolder = accHolder;
//     accountNumber = accNum;
//     balance = bal;
// }
// public long getAccountNumber(){
//     return accountNumber;
// }
// public double getBalance(){
//     return balance;
// }
// public void deposit( double amount){
//     if(amount>0){
//         balance+=amount;
//         System.out.println("Deposited amount Rs : "+ amount);
//     }else{
//         System.out.println("Invalid Deposited Amount !");
//     }

// }
// public void withdraw(double amount){
//     if(amount>balance){System.out.println("Not sufficient Balance");

//     }else{
//         balance-=amount;
//         System.out.println("Withdarwn : "+ amount);
//         System.out.println("Balance Now : "+ balance);
//     }
// }
// void display(){
//     System.out.println("Account Holder : "+ accountHolder);
//     System.out.println("Account Number : "+ accountNumber);
//     System.out.println("Current Balance : "+balance);
// }
// }
// public class ATM {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         System.out.println("Enter the accountHolder name :");
//         String accHolder = sc.nextLine();
//         System.out.println("Enter the accountNumber : ");
//         long accNum = sc.nextLong();
//         System.out.println("Enter the balance : ");
//         double bal = sc.nextDouble();
//         BankAccount account = new BankAccount(accHolder, accNum, bal);
//         int choice;
//         do{
//             System.out.println("------WELCOME TO ATM------");
//             System.out.println("1. Deposit");
//             System.out.println("2. Withdraw");
//             System.out.println("3. CheckBalance");
//             System.out.println("4. Display Account Details");
//             System.out.println("5. Exit ");
//             System.out.println("Enter your Choice : ");
//             choice = sc.nextInt();

//             switch (choice) {
//                 case 1:
//                     System.out.println("Enter the amount to deposit");
//                     double dep = sc.nextDouble();
//                     account.deposit(dep);
//                     break;
//                 case 2:
//                     System.out.println("Enter the amount to Withdraw ");
//                     double withdraw = sc.nextDouble();
//                     account.withdraw(withdraw);
//                     break;
//                 case 3:
//                     System.out.println("Current Balance : "+ account.getBalance());
//                     break;
//                 case 4:                   
//                  account.display();
//                 break;
//                 case 5:
//                     System.out.println("Thank you for using ATM. Goodbye!");
//                     break;
            
//                 default:
//                     System.out.println("Invalid Choice. Please try again.");
//                     break;
//             }
//         }while(choice!=5);
//         sc.close();
//     }

    
// }
