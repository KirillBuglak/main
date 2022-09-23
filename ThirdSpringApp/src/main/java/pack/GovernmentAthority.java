package pack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("ga")
public class GovernmentAthority {
    BusinessMan businessMan;

    @Autowired
    public GovernmentAthority(BusinessMan businessMan) {
        this.businessMan = businessMan;
    }

    public BusinessMan getBusinessMan() {
        return businessMan;
    }
}
