package secao10;

import java.util.*;

public class s10ex2 {
    static public void execute(){
        Scanner sc = new Scanner(System.in);

        System.out.print("How many will be registered? ");
        int employeeQuantity = sc.nextInt();

        HashMap<Integer, Employee> employees = new HashMap<Integer, Employee>();


        for(int i = 0; i < employeeQuantity; i++){
            System.out.print("Id: ");
            int id = sc.nextInt();
            sc.nextLine();

            if(employees.get(id) != null){
                System.out.print("Id already exists; Skipping to next employee... \n\n");
                continue;
            }

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Salary: ");
            double salary = sc.nextDouble();
            sc.nextLine();

            Employee employee = new Employee(id, name, salary);

            employees.put(id, employee);
            System.out.print("\n");

        }

        System.out.print("Enter the employee id that will have the salary increase: ");
        int id = sc.nextInt();
        sc.nextLine();

        Employee employee = employees.get(id);

        if(employee == null){
            System.out.print("ERROR: Employee id does not exists!\n");

            sc.close();
            return;
        }



        System.out.print("Enter the percentage: ");
        double percentage = sc.nextDouble();

        employee.increaseSalary(percentage);

        System.out.print("\nList of employees: \n");
        for (Map.Entry<Integer, Employee> set: employees.entrySet()){
            System.out.print(set.getValue());
        }

        sc.close();
    }

}

class Employee {
    private final Integer id;
    private String name;
    private Double salary;

    public Employee(int id, String name, double salary){
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public void increaseSalary(double percentage){
        this.salary *= (percentage/100) + 1;
    }

    @Override
    public String toString() {
        return this.id + ", " + this.name + ", " + this.salary + "\n";
    }
}