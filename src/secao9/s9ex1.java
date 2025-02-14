package secao9;

import java.util.Scanner;

public class s9ex1 {

    public static void execute(){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter account number: ");
        int number = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter account holder: ");
        String name = sc.nextLine();



        String response = "";

        do {
            System.out.print("Is there a initial deposit (y/n)? ");
            response = sc.nextLine();

        } while (!response.equals("y") && !response.equals("n"));

        Customer customer;

        if(response.equals("y")){
            System.out.print("Enter initial deposit value: ");
            double initDeposit = sc.nextDouble();

            customer = new Customer(number, name, initDeposit);
        } else {
            customer = new Customer(number, name);
        }

        System.out.print("\nAccount data:" + customer.toString());


        System.out.print("Enter a deposit value: ");
        double depositValue = sc.nextDouble();
        customer.deposit(depositValue);

        System.out.print("\nUpdated account data:" + customer.toString());


        System.out.print("Enter a withdraw value: ");
        double withdrawValue = sc.nextDouble();
        customer.withdraw(withdrawValue);

        System.out.print("\nUpdated account data:" + customer.toString());


        sc.close();
    }

}

class Customer {
    private final double TAX = 5;
    private int number;
    private String name;
    private double balance;

    public Customer(int number, String name, double initDeposit){
        this.number = number;
        this.name = name;

        deposit(initDeposit);
    }
    public Customer(int number, String name){
        this.number = number;
        this.name = name;
    }

    public void deposit(double amount){
        this.balance += amount;
    }

    public void withdraw(double amount){
        this.balance -= amount + TAX;
    }

    @Override
    public String toString() {
        return "\nAccount: " + this.number + ", Holder: " + this.name + ", Balance: "+ this.balance+ "\n";
    }
}