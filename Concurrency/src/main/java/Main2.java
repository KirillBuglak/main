import java.util.ArrayList;
import java.util.List;

public class Main2 {
    static List<Double> list = new ArrayList<>();

    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(Main2::someMeth));
        }

        threads.forEach(e -> e.start());
    }

    public static void someMeth() {
        for (int i = 0; i < 1000000; i++) {
            double x = Math.random() * Math.random();
            synchronized (list) {
                list.add(x);
            }
        }
        System.out.println(list.size());
        list.clear();
    }
}
