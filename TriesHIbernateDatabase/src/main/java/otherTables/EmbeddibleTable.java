package otherTables;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class EmbeddibleTable {
    int number;
    String name;

    public EmbeddibleTable() {}

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "EmbeddibleTable{" +
                "number=" + number +
                ", name='" + name + '\'' +
                '}';
    }
}
