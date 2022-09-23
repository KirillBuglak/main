package HandlerForLoggers;

import java.io.IOException;
import java.util.logging.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Logger log1 = Logger.getLogger("LOG1");
        log1.getFilter();
        log1.setLevel(Level.FINE);
        ConsoleHandler hand1 = new ConsoleHandler();
        hand1.setLevel(Level.FINE);
        log1.addHandler(hand1);
        log1.setUseParentHandlers(false);

        var hand2 = new FileHandler();
        log1.addHandler(hand2);
        log1.info("Message from log1");

        System.out.println(log1.getHandlers().getClass().getName());


    }
}
