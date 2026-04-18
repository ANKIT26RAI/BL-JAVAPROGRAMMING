

// import java.util.Scanner;

// class Employee{
//     private int id;
//     private String name;
//     private String password;
//     private double salary;

//     Employee(int id,String name,String password,double salary){
//         this.id=id;
//         this.name=name;
//         this.password=password;
//         this.salary=salary;
//     }
//     public int getId(){
//         return id;
//     }
   
//     public String getPassword(){
//         return password;
//     }
    
//     public void payroll(){
//         double tax = salary*0.10;
//         double deduction = salary*0.05;
//         double netPay = salary-tax-deduction;


//         System.out.println("-----PayDetails-----");
//         System.out.println("Employee : "+name);
//         System.out.println("Basic Salary : "+ salary);
//         System.out.println("Tax (10%) : "+ tax );
//         System.out.println("Deduction(5%): "+deduction );
//         System.out.println("Net Pay : "+ netPay);

//     }
// }
// public class payroll {
//     public static void main(String[] args) {
//             Scanner sc = new Scanner(System.in);
//             System.out.println("Enter the no. of employees :");
//             int n = sc.nextInt();
//             Employee employees[]= new Employee[n];
//             int count =0;
//             int choice;
//             do{
//                 System.out.println("=====PayRoll System=====");
//                 System.out.println("1.Register the Employee ");
//                 System.out.println("2.Login");
//                 System.out.println("3.Exit");
//                 System.out.println("Enter your choice :");
//                 choice = sc.nextInt();
    
//                 switch (choice) {
                    
    
//                     case 1:if(count<n){
//                         System.out.println("Enter the id :");
//                         int id = sc.nextInt();
//                         sc.nextLine();
//                         System.out.println("Enter the name :");
//                         String name = sc.nextLine();
//                         System.out.println("Set the PASSWORD");
//                         String password = sc.nextLine();
//                         System.out.println("Enter the Salary :");
//                         double salary = sc.nextDouble();
//                         employees[count]= new Employee(id, name, password, salary);
//                         count++;
//                         System.out.println("Employee Registerd Successfully!");
    
//                     }else{
//                         System.out.println("Employee Limit Reached");
//                     }
//                      break;
//                     case 2:
//                         System.out.println("Enter the id :");
//                         int loginid = sc.nextInt();
//                         sc.nextLine();
//                         System.out.println("Enter the password :");
//                         String logpass = sc.nextLine();
//                         boolean found = false;
//                         for(int i=0;i<count;i++){
//                             if(employees[i].getId()==loginid&&employees[i].getPassword().equals(logpass)){
//                                 System.out.println("Login Successfully");
//                                 employees[i].payroll();
//                                 found = true; 
//                                 break;
//                         }
//                     }
//                     if(!found){
//                         System.out.println("Invalid id / Password");
//                     }
//                     break;
//                     case 3:
//                         System.out.println("Exit!");
//                         break;
//                 default:
//                     System.out.println("Invalid Choice!");
                    
//             }
//         }while (choice!=3);

        
//     }
    
// }


