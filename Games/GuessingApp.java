package Games;

import java.util.Scanner;
import java.util.Random;
 public class GuessingApp {
 public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Random random =new Random();

    int maxNumber = 50;
    int secretNumber = random.nextInt(maxNumber)+1;
    int attempts=0;
    boolean guessed = false;

    while(!guessed){
        System.out.println("Enter your guess :");
        int guess = sc.nextInt();
        attempts++;

        if(guess<1||guess>50){
            System.out.println("Enter the valid number");
      
        }else if(guess>secretNumber){
            System.out.println("Too high , Guess Low");
        }else if(guess<secretNumber){
            System.out.println("Too low , Guess high");
        }else{
            System.out.print("Correct , you got in "+attempts+" tries");
           guessed = true;    
        }
    }
sc.close();
 }
    
 }