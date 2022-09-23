import jakarta.persistence.*;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.SelectBeforeUpdate;

import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "SMN")
@NamedQuery(name = "SOQuery",query = "from Someone where ID>:param")
@NamedNativeQuery(name = "nativeSOQ",
        query = "select * from smn where smn.name>:param"
        ,resultClass = Someone.class
)
@SelectBeforeUpdate
@BatchSize(size = 5)
public class Someone {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int ID;
    String name;
    int someNumber;
    @OneToMany(mappedBy = "someone", fetch = FetchType.LAZY)
    Collection<Something> somethings = new ArrayList<>();


    public Someone() {}

    public int getSomeNumber() {
        return someNumber;
    }

    public void setSomeNumber(int someNumber) {
        this.someNumber = someNumber;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Something> getSomethings() {
        return somethings;
    }

    public void setSomethings(Collection<Something> somethings) {
        this.somethings = somethings;
    }

    @Override
    public String toString() {
        return "Someone{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", someNumber=" + someNumber +
                '}';
    }
}
