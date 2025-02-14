package secao12;

import java.time.LocalDate;
import java.util.*;

import java.time.*;

enum OrderStatus{
    PENDING_PAYMENT,
    PROCESSING,
    SHIPPED,
    DELIVERED
}

public class s12ex1 {
    public static void execute(){
        Scanner sc = new Scanner(System.in);

        // Client
        System.out.print("Enter client data:\n");
        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Email: ");
        String email = sc.nextLine();

        System.out.print("Birth date (YYYY-MM-DD): ");
        String dateStr = sc.nextLine();
        LocalDate birthDate = LocalDate.parse(dateStr);

        Client client = new Client(name, email, birthDate);

        //Order
        System.out.print("Enter order data:\n");
        System.out.print("Status: ");
        OrderStatus status = OrderStatus.valueOf(sc.nextLine());

        Order order = new Order(client, status);

        System.out.print("How many items to this order?: ");
        int itemAmount = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < itemAmount; i++){
            System.out.print("Enter #"+ (i+1) + " item data:\n");

            System.out.print("Product name: ");
            String productName = sc.nextLine();

            System.out.print("Product price: ");
            Double productPrice = sc.nextDouble();
            sc.nextLine();

            System.out.print("Quantity: ");
            Integer quantity = sc.nextInt();
            sc.nextLine();

            OrderItem orderItem = new OrderItem(new Product(productName, productPrice), quantity);

            order.addItemToOrder(orderItem);
        }


        // Summary
        System.out.print("ORDER SUMMARY:" + order.toString());


        sc.close();
    }
}

class Order {
    private LocalDate moment;
    private OrderStatus status;

    private List<OrderItem> orderItems = new ArrayList<OrderItem>();
    private Client client = null;

    public Order(Client client, OrderStatus status) {
        this.client = client;
        this.status = status;

        this.moment = LocalDate.now();
    }

    public void addItemToOrder(OrderItem orderItem){
        orderItems.add(orderItem);
    }

    @Override
    public String toString() {
        StringBuilder summary = new StringBuilder();

        summary.append("Order moment: ").append(this.moment).append("\n");
        summary.append("Order status: ").append(this.status).append("\n");
        summary.append("Client: ").append(this.client).append("\n");

        double totalPrice = 0;

        summary.append("Order items:").append("\n");
        for(OrderItem item : this.orderItems){
            summary.append(item).append("\n");

            totalPrice += item.getPrice();
        }

        summary.append("Total price: ").append(totalPrice).append("\n");

        return summary.toString();
    }
}

class OrderItem {
    private Integer quantity;
    private Double price;

    private Product product = null;

    public OrderItem(Product product, Integer quantity){
        this.quantity = quantity;
        this.price = product.getPrice() * quantity;

        this.product = product;
    }

    public Double getPrice(){
        return this.price;
    }

    @Override
    public String toString() {
        return product.getName() +
                ", Quantity: " + this.quantity +
                ", Subtotal: " + this.price;
    }
}

class Product {
    private String name;
    private Double price;

    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public Double getPrice(){
        return this.price;
    }

    public String getName(){
        return this.name;
    }
}

class Client {
    private String name;
    private String email;
    private LocalDate birthDate;

    //private List<Order> orders = new ArrayList<Order>();

    public Client(String name, String email, LocalDate birthDate){
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return this.name + "("+ this.birthDate +") - " + this.email;
    }
}
