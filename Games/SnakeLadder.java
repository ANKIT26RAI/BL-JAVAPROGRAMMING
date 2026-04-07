package Games;
import java.util.Scanner;
import java.util.Random;
public class SnakeLadder {
    static int[] snakeHead = {17,54,62,64,87,93,95,99};
    static int[] snakeTail = {7,34,19,60,24,73,75,78};
    
    static int[] ladderBottom ={4,9,20,28,40,51,63,71};
    static int[] ladderTop = {14,31,38,84,59,67,81,91};

    static int move(int pos, int roll){
        int newPos = pos+roll;

        if(newPos>100){
            System.out.println("Needs exact roll - stay at "+ pos);
            return pos;
        }
        //check snakes
        for(int i=0;i<snakeHead.length;i++){
            if(newPos == snakeHead[i]){
                System.out.println("Snake! "+ newPos + " -> "+snakeTail[i] );
                return snakeTail[i];

            }
        }
        //check ladders.
        for(int i=0;i<ladderBottom.length;i++){
            if(newPos==ladderBottom[i]){
                System.out.println("Ladder! "+ newPos+ " -> "+ladderTop[i]);
                return ladderTop[i];
            }
        }
        return newPos;

    }
    public static void main(String[] args) {
    System.out.println("Snake & ladder starting...");
    Scanner sc = new Scanner(System.in);
    Random random = new Random();
    int[] playerPos = {1,1};
    int turn =0;
    boolean gameOver = false;
    System.out.println("Game ready! P1 pos: "+ playerPos[0]);
    System.out.println("Game ready! P2 pos: "+ playerPos[1]);

    while (!gameOver) {
        System.out.println("\nPlayer "+ (turn+1)+" is at square "+playerPos[turn]);
        System.out.println("Press Enter to roll...");
        sc.nextLine();

        int roll = random.nextInt(6)+1;
        System.out.println(" Rolled:  "+roll);
        playerPos[turn]=move(playerPos[turn], roll);
        System.out.println(" Now at: "+playerPos[turn]);

        //check Win
        if(playerPos[turn]==100){
            System.out.println("\nPlayer "+ (turn+1) +" WINS!");
            gameOver = true;
        }
        //switch turns
        if(!gameOver){
            turn=(turn+1)%2;
        }
    }
     sc.close();
}
    
}