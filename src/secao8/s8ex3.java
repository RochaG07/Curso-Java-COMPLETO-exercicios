package secao8;

import java.util.Scanner;

public class s8ex3 {
    public static void execute(){
        Scanner sc = new Scanner(System.in);

        System.out.print("Name: ");
        String name = sc.nextLine();

        Student student = new Student(name);

        for(int i = 0; i < 3; i++){
            System.out.print("Enter " + (i + 1) + "º grade: ");
            student.grades[i] = sc.nextDouble();
        }

        student.printResult();
    }
}

class Student{
    private String name;
    public double[] grades = {-1, -1, -1};

    public Student(String name){
        this.name = name;
    }

    public void printResult(){
        double finalGrade = grades[0] + grades[1] + grades[2];

        System.out.println("\nFINAL GRADE: "+ finalGrade);

        if(finalGrade >= 60){
            System.out.println("PASS");
        } else {
            System.out.println("FAILED\nMISSING "+ (60 - finalGrade) + " POINTS");
        }
    }
}