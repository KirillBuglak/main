package pack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BusinessMan {
    @Autowired
    @Qualifier("cafe")
    private Business business;
    int id;
    String name;

    public BusinessMan() {
    }

//    @Autowired
//    public void setBusiness(Business business) {
//        this.business = business;
//    }

    public BusinessMan(Business business, int id, String name) {
        this.business = business;
        this.id = id;
        this.name = name;
    }

    public Business getBusiness() {
        return business;
    }

    public String getBusinessClassName() {
        return "The business I have is - " + business.getClass().getSimpleName();
    }

    @Override
    public String toString() {
        return "BusinessMan{" +
                "business=" + business +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}