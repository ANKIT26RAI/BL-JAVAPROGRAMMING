import java.util.Scanner;
public class Bonus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] salary = new double[10];
        double[] yearOfService= new double[10];
        double[] newSalary = new double[10];
        double[] bonus = new double[10];

        double totalBonus = 0;
        double totalOldSalary = 0;
        double totnewSalary =0;

        for(int i=0;i<10;i++){
            System.out.println("Enter the details of Employee : "+ (i+1) + " : ");
            System.out.println("Enter the salary of employee : ");
            double sal = sc.nextDouble();
            System.out.println("Enter the years of services :");
            double yrs = sc.nextDouble();

            if(yrs<=0||sal<=0){
                System.out.println("The details are invalid! \n ");
                i--;
               continue;          
            }

            salary[i]=sal;
            yearOfService[i]=yrs;
        }
            for(int i=0;i<10;i++){
              if(yearOfService[i]>5){
                bonus[i]= salary[i]*0.05;
            }else{
                bonus[i]=salary[i]*0.02;
            }
            newSalary[i]=salary[i]+bonus[i];
            

            //Total Salary
            totalBonus+=bonus[i];
            totalOldSalary+=salary[i];
            totnewSalary+=newSalary[i];
        }     
        System.out.println("\n Enter the details of employee ---");
        for(int i=0;i<10;i++){
           System.out.print("Employee "+(i+1) + 
                            "| Old Salary "+ salary[i] +
                            "| bonus "+ bonus[i] +
                            "|newSalary "+ newSalary[i]
                        );            
        }
        //final Totals
        System.out.println("\n--- Company Summary ---");
        System.out.println("Total Old Salary: " + totalOldSalary);
        System.out.println("Total Bonus Payout: " + totalBonus);
        System.out.println("Total New Salary: " + totnewSalary);

        sc.close();

        }


    }
    
