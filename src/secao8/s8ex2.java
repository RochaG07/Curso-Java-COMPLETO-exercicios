package secao8;

import java.util.Scanner;

public class s8ex2 {
    public static void execute(){
        Scanner sc = new Scanner(System.in);

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Gross Salary: ");
        double grossSalary = sc.nextDouble();

        System.out.print("Tax: ");
        double tax = sc.nextDouble();

        Employee employee = new Employee(name, grossSalary, tax);

        System.out.print("Employee: " + employee);

        employee.IncreaseSalary(10);

        System.out.print("\nUpdated Employee: " + employee);

    }
}

class Employee {
    private String name;
    private double grossSalary;
    private double tax;

    public Employee(String name, double grossSalary, double tax){
        this.name = name;
        this.grossSalary = grossSalary;
        this.tax = tax;
    }

    public double NetSalary(){
        return grossSalary - tax;
    }

    public void IncreaseSalary(double percentage){
        double factor = 1 + (percentage / 100);
        grossSalary = grossSalary * factor;
    }

    @Override
    public String toString() {
        return this.name + ", $" + (this.grossSalary - this.tax);
    }
}