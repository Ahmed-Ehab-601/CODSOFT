package task2;

import java.util.Scanner;

public class GradeCalculator {
    int numberOfSubjects;
    int sum = 0;
    double average;
    char grade;
   
    public void input(){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter Number Of Subjects : ");

        while(true){
            try{
                numberOfSubjects = Integer.parseInt(in.nextLine());
                break;
            }catch(Exception e){
                System.out.print("Enter Valid Input : ");
            }

        }
    
        for(int i = 1; i <= numberOfSubjects; i++){
            System.out.print("Enter marks for subject " + i + " : ");
            int mark = 0;
            boolean x = true;
            while(x){
                try{
                    mark = Integer.parseInt(in.nextLine());
                    if(mark < 0 || mark > 100){
                        x = true;
                    }else{
                        break;

                    }
            
                }catch(Exception e){
                    System.out.print("Enter Valid Input : ");
                }
            }
            sum+= mark;
            
        }
        average = (double) sum / numberOfSubjects;
        if (average >= 90) {
            grade = 'A';
        } else if (average >= 80) {
            grade = 'B';
        } else if (average >= 70) {
            grade = 'C';
        } else if (average >= 60) {
            grade = 'D';
        } else {
           grade = 'F';
        }
        System.out.println("Total Marks: " + sum);
        System.out.printf("Average Percentage: %.2f \n",average);
        System.out.println("Grade: " + grade);
        in.close();
        

    }

    public static void main(String[] args) {
        GradeCalculator grade = new GradeCalculator();
        grade.input();
    }

    
}
