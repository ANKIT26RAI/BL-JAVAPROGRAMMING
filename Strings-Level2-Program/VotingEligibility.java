import java.util.Scanner;

public class VotingEligibility {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of students:");
        int n = sc.nextInt();

        // Step a: Generate random ages
        int[] ages = generateAges(n);

        // Step b: Check eligibility
        String[][] eligibility = checkVotingEligibility(ages);

        // Step c: Display results
        displayTable(eligibility);
    }

    // --- Methods defined above ---
    public static int[] generateAges(int n) {
        int[] ages = new int[n];
        for (int i = 0; i < n; i++) {
            ages[i] = (int)(Math.random() * 90) + 10;
        }
        return ages;
    }

    public static String[][] checkVotingEligibility(int[] ages) {
        String[][] result = new String[ages.length][2];
        for (int i = 0; i < ages.length; i++) {
            result[i][0] = String.valueOf(ages[i]);
            if (ages[i] < 0) {
                result[i][1] = "false";
            } else if (ages[i] >= 18) {
                result[i][1] = "true";
            } else {
                result[i][1] = "false";
            }
        }
        return result;
    }

    public static void displayTable(String[][] arr) {
        System.out.println("Age\tCan Vote?");
        System.out.println("-------------------");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i][0] + "\t" + arr[i][1]);
        }
    }
}
