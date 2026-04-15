// 1. Program to Display Employee Details 
// Problem Statement: Write a program to create an Employee class with attributes 
// name, id, and salary. Add a method to display the details. 
import java.util.Scanner;
class Employee{
    String name;
    int id;
    double salary;
    Employee(String name, int id ,double salary){
        this.name = name;
        this.id = id;
        this.salary = salary;
    }
    void displayDetails(){
        System.out.println("Employee Name: " + name);
        System.out.println("Employee ID: " + id);
        System.out.println("Employee Salary: " + salary);
    }
}
public class Employees {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Employee Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();
        System.out.print("Enter Employee Salary: ");
        double salary = scanner.nextDouble();
        Employee employee = new Employee(name, id, salary);
        employee.displayDetails();
    }
}
