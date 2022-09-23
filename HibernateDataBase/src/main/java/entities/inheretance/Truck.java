package entities.inheretance;

import entities.Vehicle;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(value = "DieselPower")
public class Truck extends Vehicle {

    String cabinType;

    public Truck() {}

    public String getCabinType() {
        return cabinType;
    }

    public void setCabinType(String cabinType) {
        this.cabinType = cabinType;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "cabinType='" + cabinType + '\'' +
                '}';
    }
}
