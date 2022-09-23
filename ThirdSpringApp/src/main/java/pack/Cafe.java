package pack;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


@Component
//@Scope("prototype")
public class Cafe implements Business {
    int id;
    @Value("${cafeName}")
    String label;

    public Cafe() {
    }

    @PostConstruct
    public void init() throws ClassNotFoundException {
        System.out.println("Initializing " + this.getClass().getSimpleName());
    }

    @PreDestroy
    public void destroy() throws ClassNotFoundException {
        System.out.println("Destroying " + this.getClass().getSimpleName());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

//    public void setLabel(String label) {
//        this.label = label;
//    }

    @Override
    public String getName() {
        return label;
    }
}
