package secao8;

import java.util.Scanner;

public class s8ex4 {
    public static void execute(){
        Scanner sc = new Scanner(System.in);

        System.out.print("What is the dollar price?: ");
        double dollarQuotation = sc.nextDouble();

        System.out.print("How many dollars will be bought?: ");
        double dollar = sc.nextDouble();


        double reais = CurrencyConverter.DollarToReais(dollar, dollarQuotation);
        System.out.print("Amount to be paid in reais: " + reais);

        sc.close();
    }
}

class CurrencyConverter{
    public static final double IOF = 6;

    static double DollarToReais(double dollar, double dollarQuotation){
        dollar *= 1+ (IOF / 100);

        return dollar * dollarQuotation;
    }
}