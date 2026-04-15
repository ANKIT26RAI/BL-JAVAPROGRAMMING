// Program to Handle Book Details 
// Problem Statement: Write a program to create a Book class with attributes title, 
// author, and price. Add a method to display the book details.
import java.util.Scanner;
class Book{
    String title;
    String author;
    double price;
    Book(String t,String a, double p){
        title=t;
        author=a;
        price=p;
    }
    String title(){
        return title;
    }
    String author(){
        return author;
    }
    double price(){
        return price;
    }
    void display(){
        System.out.println("Enter the title of Book "+ title());
        System.out.println("Enter the author of Book "+ author());
        System.out.println("Enter the price of Book "+ price());
    }
}
public class BookDetails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Title of Book : ");
        String t = sc.nextLine();
        System.out.println("Enter the Author of Book : ");
        String a = sc.nextLine();
        System.out.println("Enter the price of Book : ");
        double p = sc.nextDouble();
        Book b = new Book(t, a, p);
        b.display();

    }
    
}
