package entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Parts{
    @Column(name = "Name_of_PART")
    String partName;
    @Column(name = "Amount_of_PARTS")
    int amountOfParts;

    public Parts() {}

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public int getAmountOfParts() {
        return amountOfParts;
    }

    public void setAmountOfParts(int amountOfParts) {
        this.amountOfParts = amountOfParts;
    }

    @Override
    public String toString() {
        return "Parts{" +
                "partName='" + partName + '\'' +
                ", amountOfParts=" + amountOfParts +
               '}';
    }
}
