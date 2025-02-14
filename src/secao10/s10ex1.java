package secao10;

import java.util.Scanner;

public class s10ex1 {
    public static void execute(){
        Scanner sc = new Scanner(System.in);

        System.out.print("How many rooms will be rented?: ");
        int rentedAmount = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < rentedAmount; i++){
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Email: ");
            String email = sc.nextLine();

            Student student = new Student(name, email);

            System.out.print("Room: ");
            int room = sc.nextInt();
            sc.nextLine();

            Hotel.rentRoom(room, student);
            System.out.print("\n");
        }

        Hotel.printRentedRooms();

        sc.close();
    }
}

class Student {
    String name;
    String email;

    public Student(String name, String email){
        this.name = name;
        this.email = email;
    }
}

class Hotel {
    static Student[] rooms = new Student[9];

    static void rentRoom(int number, Student student){
        number--;

        if(number > rooms.length || number < 0){
            System.out.print("Room out bounds!\n");

            return;
        }

        if(rooms[number] != null){
            System.out.print("Room already vacant!\n");

            return;
        }

        rooms[number] = student;
    }

    static void printRentedRooms(){
        System.out.print("\n\nBusy Rooms: \n");

        for (int i = 0; i < rooms.length; i++){
            if(rooms[i] != null) {
                System.out.print((i+1) + ": " + rooms[i].name + ", " + rooms[i].email + "\n");
            }
        }
    }

}