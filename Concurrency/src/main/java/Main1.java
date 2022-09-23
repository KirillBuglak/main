import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {

        Task task = new Task();
        new Thread(task).start();
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        task.stop();
        System.out.println("Counter Main - " + task.getCounter());


        for (int i = 0; i < 4; i++) {
            new Thread(() -> {
                for (int j = 0; j < 100000; j++) {
                    MyValue.incrementX();
                }
                System.out.println(MyValue.getX());
            }).start();
        }
    }
}
