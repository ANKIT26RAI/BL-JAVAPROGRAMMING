// Program to Simulate Student Report 
// Problem Statement: Create a Student class with attributes name, rollNumber, and 
// marks. Add two methods: 
// ● To calculate the grade based on the marks. 
// ● To display the student's details and grade. 
// Explanation: The Student class organizes all relevant details about a student as 
// attributes. Methods are used to calculate the grade and provide a way to display all 
// information.

// import java.util.Scanner;

// class Student{
//     String name;
//     int rollNumber;
//     double marks;
//     Student(String name, int rollNumber, double marks){
//         this.name = name;
//         this.rollNumber = rollNumber;
//         this.marks = marks;
//     }
//     String calculateGrade(){
//         if(marks >= 90){
//             return "A";
//         } else if(marks >= 80){
//             return "B";
//         } else if(marks >= 70){
//             return "C";
//         } else if(marks >= 60){
//             return "D";
//         } else {
//             return "F";
//         }
//     }
//     void displayDetails(){
//         System.out.println("Student Name: " + name);
//         System.out.println("Roll Number: " + rollNumber);
//         System.out.println("Marks: " + marks);
//         System.out.println("Grade: " + calculateGrade());
//     }
// }
// public class StudentReport {
//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);
//         System.out.print("Enter Student Name: ");
//         String name = scanner.nextLine();
//         System.out.print("Enter Roll Number: ");
//         int rollNumber = scanner.nextInt();
//         System.out.print("Enter Marks: ");
//         double marks = scanner.nextDouble();
//         Student student = new Student(name, rollNumber, marks);
//         student.displayDetails();
//     }
// }
