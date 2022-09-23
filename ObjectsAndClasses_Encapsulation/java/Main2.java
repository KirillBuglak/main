import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
//        Elevator elevator = new Elevator(-3, 26);
//
//        while (true) {
//            System.out.print("Введите номер этажа: ");
//            int floor = new Scanner(System.in).nextInt();
//            elevator.move(floor);
//        }
        Dimensions dimensions = new Dimensions(200, 300, 1000);
        Order order1 = new Order(dimensions, 20, "NY 6th avenue",
                false, "22-fa-45", true);
        Order order2 = order1.setMass(200);

        System.out.println(order1 == order2);
        System.out.println(order1.equals(order2));
    }
}