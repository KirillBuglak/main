package entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
@MappedSuperclass
public abstract class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int ID;

    public Model() {
    }

    public int getId() {
        return ID;
    }

    public void setId(int id) {
        this.ID = id;
    }
}
