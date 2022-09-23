import jakarta.persistence.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "SMTHG")
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "SMTHG")
public class Something {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int number;
    String model;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    Someone someone;

    public Something() {}

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Someone getSomeone() {
        return someone;
    }

    public void setSomeone(Someone someone) {
        this.someone = someone;
    }

    @Override
    public String toString() {
        return "Something{" +
                "number=" + number +
                ", model='" + model + '\'' +
                '}';
    }
}

