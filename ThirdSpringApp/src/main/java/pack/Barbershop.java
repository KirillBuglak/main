package pack;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("barb")
@Scope("prototype")
public class Barbershop implements Business {
    int id;
    @Value("${barbLabel}")
    String label;

    public Barbershop() {
    }
    public void init() throws ClassNotFoundException {
        System.out.println("Initializing "+this.getClass().getName());
    }

    public void destroy() throws ClassNotFoundException {
        System.out.println("Destroying "+this.getClass().getName());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public String getLabel() {
//        return label;
//    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String getName() {
        return label;
    }
}