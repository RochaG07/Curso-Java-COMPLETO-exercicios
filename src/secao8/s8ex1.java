package secao8;

import java.util.Scanner;

public class s8ex1 {

    public static void execute(){
        Scanner sc = new Scanner(System.in);

        System.out.print("Entre a altura do retangulo: ");
        double height = sc.nextDouble();

        System.out.print("Entre a largura do retangulo: ");
        double width = sc.nextDouble();

        Rectangle rectangle = new Rectangle(width, height);

        System.out.printf("\nArea: "+ rectangle.Area());
        System.out.printf("\nPerimeter: "+ rectangle.Perimeter());
        System.out.printf("\nDiagonal: "+ rectangle.Diagonal());
    }

}

class Rectangle{
    private double width;
    private double height;

    public Rectangle(double width, double height){
        this.width = width;
        this.height = height;
    }

    public double Area(){
        return this.width * this.height;
    }

    public double Perimeter(){
        return 2 * (this.width + this.height);
    }

    public double Diagonal(){
        return Math.sqrt(Math.pow(this.width, 2) + Math.pow(this.height, 2));
    }
}