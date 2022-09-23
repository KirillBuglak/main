import java.util.concurrent.atomic.AtomicInteger;

public class MyValue {
    private static AtomicInteger x = new AtomicInteger();

    public static void incrementX() {
        x.getAndIncrement();
    }

    public static int getX() {
        return x.get();
    }
}
