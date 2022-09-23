package pack;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AutoService implements Business {

    int id;
    @Value("${autoName}")
    String name;

    public AutoService() {
    }

    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }
}
