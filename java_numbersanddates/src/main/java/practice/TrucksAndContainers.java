package practice;

import java.util.Scanner;

public class TrucksAndContainers {

    public static final int MAX_CONTAINERS_IN_TRUCK = 12;
    public static final int MAX_BOXES_IN_CONTAINER = 27;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //получение количество коробок от пользователя
        int boxes = scanner.nextInt();


        String message = "";
        int numberOfBoxes = boxes;
        int containerNumber = 0;
        int boxNumber = 0;
        int numberOfTrucks = 0;
        int numberOfContainers = boxes / MAX_BOXES_IN_CONTAINER;
        int remainder = numberOfBoxes % MAX_BOXES_IN_CONTAINER;

        if (remainder != 0) {
            ++numberOfContainers;
        }


        for (int i = 1; numberOfBoxes != 0; i++) {
            numberOfTrucks = i;
            message += "Грузовик: " + numberOfTrucks;

            for (int j = 1; j <= MAX_CONTAINERS_IN_TRUCK; j++) {
                containerNumber++;
                message += System.lineSeparator() + "\tКонтейнер: " + containerNumber;

                for (int z = 1; z <= MAX_BOXES_IN_CONTAINER; z++) {
                    boxNumber++;
                    message += System.lineSeparator() + "\t\tЯщик: " + boxNumber;
                    numberOfBoxes--;
                    if (numberOfBoxes == 0) {
                        break;
                    }
                }
                if (numberOfBoxes == 0) {
                    break;
                }
            }
            System.out.println(message);
            message = "";
        }
        message = "Необходимо:" + System.lineSeparator()
                + "грузовиков - " + numberOfTrucks + " шт."
                + System.lineSeparator() + "контейнеров - " + numberOfContainers + " шт.";
        System.out.println(message);
    }


    // TODO: вывести в консоль коробки разложенные по грузовикам и контейнерам
    // пример вывода при вводе 2
    // для отступа используйте табуляцию - \t

        /*
        Грузовик: 1
            Контейнер: 1
                Ящик: 1
                Ящик: 2
        Необходимо:
        грузовиков - 1 шт.
        контейнеров - 1 шт.
        */
}