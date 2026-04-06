import java.util.Scanner;

public class StudentGrade {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Student Grade Calculator ===");
        System.out.print("Enter marks for Physics    : ");
        double physics = sc.nextDouble();
        System.out.print("Enter marks for Chemistry  : ");
        double chemistry = sc.nextDouble();
        System.out.print("Enter marks for Maths      : ");
        double maths = sc.nextDouble();

        double total = physics + chemistry + maths;
        double percentage = total / 3;

        String grade, remarks;

        if (percentage >= 80) {
            grade = "A";
            remarks = "Level 4, above agency-normalized standards";
        } else if (percentage >= 70) {
            grade = "B";
            remarks = "Level 3, at agency-normalized standards";
        } else if (percentage >= 60) {
            grade = "C";
            remarks = "Level 2, below, but approaching agency-normalized standards";
        } else if (percentage >= 50) {
            grade = "D";
            remarks = "Level 1, well below agency-normalized standards";
        } else if (percentage >= 40) {
            grade = "E";
            remarks = "Level 1-, too below agency-normalized standards";
        } else {
            grade = "R";
            remarks = "Remedial standards";
        }

        System.out.println("\n========== RESULT ==========");
        System.out.printf("Physics    : %.2f%n", physics);
        System.out.printf("Chemistry  : %.2f%n", chemistry);
        System.out.printf("Maths      : %.2f%n", maths);
        System.out.printf("Total      : %.2f%n", total);
        System.out.printf("Average    : %.2f%%%n", percentage);
        System.out.println("Grade      : " + grade);
        System.out.println("Remarks    : " + remarks);
        System.out.println("============================");

        sc.close();
    }
}