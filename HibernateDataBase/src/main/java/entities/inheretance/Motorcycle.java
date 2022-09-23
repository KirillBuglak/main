package entities.inheretance;

import entities.Vehicle;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(value = "TwoWheeler")
public class Motorcycle extends Vehicle {

    int horsePower;

    public Motorcycle() {}

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    @Override
    public String toString() {
        return "Motorcycle{" +
                "horsePower=" + horsePower +
                '}';
    }
}
