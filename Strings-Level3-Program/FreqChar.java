import java.util.Scanner;
public class FreqChar{
static String[][] findfrq(String text){
    int[] freq = new int[256];
    for(int i=0;i<text.length();i++){
        char c = text.charAt(i);
        int ascii=(int) c;
        freq[ascii]++;
    }
    int uniqueCount=0;
    for(int i=0;i<256;i++){
        if(freq[i]>0){
            uniqueCount++;
        }
    }
    String[][] result = new String[uniqueCount][2];
    int index=0;
    for(int i=0;i<256;i++){
        if(freq[i]>0){
            char c =(char) i;
            result[index][0] = String.valueOf(c);
            result[index][1]=String.valueOf(freq[i]);
            index++;
        }
 
    }
    return result; 
}
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter a String: ");
    String text = sc.nextLine();
    String[][] freqData = findfrq(text);
    System.out.println("\n----------------------------");
    System.out.println(" Character | Frequency");
    System.out.println("----------------------------");

    for(int i=0;i<freqData.length;i++){
        System.out.println(" "+freqData[i][0]+ "           |   "+ freqData[i][1]);

    }
    System.out.println("------------------------------");
sc.close();
}
}