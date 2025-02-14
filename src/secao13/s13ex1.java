package secao13;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class s13ex1 {
    public static void execute(){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of products: ");
        int productQnt = sc.nextInt();
        sc.nextLine();

        List<Product> products = new ArrayList<>();

        for (int i = 0; i < productQnt; i++) {

            System.out.print("Common, user or imported (c/u/i)?");
            String productTypeResponse = sc.nextLine();


            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Price: ");
            Double price = sc.nextDouble();
            sc.nextLine();

            Product product;

            if(productTypeResponse.equals("u")){
                System.out.print("Customs fee: ");
                Double customsFee = sc.nextDouble();
                sc.nextLine();

                product = new ImportedProduct(name, price, customsFee);

            } else if(productTypeResponse.equals("i")){
                System.out.print("Manufacture date (DD/MM/YYYY): ");
                LocalDate mnfDate = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

                Date date = Date.from(mnfDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

                product = new UsedProduct(name, price, date);

            } else {
                product = new Product(name, price);

            }

            products.add(product);
        }

        System.out.print("\nPRICE TAGS: \n");


        for(Product product : products){
            System.out.print(product.priceTag() + "\n");
        }

        sc.close();
    }
}

class Product{
    protected String name;
    protected Double price;

    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public String priceTag(){
        return this.name + " $ " + this.price;
    }
}

class ImportedProduct extends Product{
    private Double customsFees;

    public ImportedProduct(String name, Double price, Double customsFees) {
        super(name, price);
        this.customsFees = customsFees;
    }

    public Double totalPrice(){
        return this.price + this.customsFees;
    }

    @Override
    public String priceTag() {
        return super.priceTag() + " (Customs fee: " + this.customsFees + ")";
    }
}

class UsedProduct extends Product{
    private Date manifacturedDate;

    public UsedProduct(String name, Double price, Date manifacturedDate) {
        super(name, price);
        this.manifacturedDate = manifacturedDate;
    }

    @Override
    public String priceTag() {
        return super.priceTag() + " (Manufacture date: "+ this.manifacturedDate + ")";
    }
}