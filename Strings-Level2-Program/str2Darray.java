import java.util.Scanner;
public class str2Darray {

    static int findlength(String text){
        int count=0;
        try {
            while (true) {
                text.charAt(count);
                count++;
                
            }
            
        } catch (Exception e) {
            // TODO: handle exception
        }
        return count;
    }
    static String[] customSplit(String text){
     int len = findlength(text);
     int wordCount=1;
     for(int i=0;i<len;i++){
        if(text.charAt(i)==' '){
            wordCount++;
        }
     }
     String[] words = new String[wordCount];
     int start = 0; int wordIndex =0;
     for(int i=0;i<len;i++){
        if(text.charAt(i)==' '){
            words[wordIndex++]=text.substring(start,i);
            start =i+1;
        }
     }
     words[wordIndex]=text.substring(start,len);
     return words;
    }
    public static String[][] wordLengthArray(String[] words) {
    String[][] result = new String[words.length][2];
    for (int i = 0; i < words.length; i++) {
        result[i][0] = words[i];
        result[i][1] = String.valueOf(findlength(words[i]));
    }
    return result;
}
public static void displayTable(String[][] wordLengthTable) {
    System.out.println("\nWord\t\tLength");
    System.out.println("----------------------");
    for (int i = 0; i < wordLengthTable.length; i++) {
        int lengthValue = Integer.parseInt(wordLengthTable[i][1]);
        System.out.println(wordLengthTable[i][0] + "\t\t" + lengthValue);
    }
}

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a line of Text: ");
        String input = sc.nextLine();

    String[] words = customSplit(input);
    String[][] wordLengthTable = wordLengthArray(words);

    displayTable(wordLengthTable);
    }
    
}
