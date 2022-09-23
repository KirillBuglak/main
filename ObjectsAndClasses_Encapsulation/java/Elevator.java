import java.util.Random;

public class Elevator {

    private final int minFloor;
    private final int maxFloor;
    private int currentFloor = 1;

    public Elevator(int minFloor, int maxFloor) {
        this.maxFloor = maxFloor;
        this.minFloor = minFloor;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    private int moveDown() {
        return --currentFloor;
    }

    private int moveUp() {
        return ++currentFloor;
    }

    public void move(int floor) {
        while (floor != currentFloor) {
            if (floor > maxFloor || floor < minFloor) {
                System.out.println("There's no such a floor!");
                break;
            } else if (floor > currentFloor) System.out.println("Moving up - " + moveUp());
            else System.out.println("Moving down - " + moveDown());
        }
        System.out.println();
    }
}