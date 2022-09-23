package otherTables;

import jakarta.persistence.*;

@Entity
public class FirstTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String message;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(column = @Column(name = "some_num_overriden"), name = "number"),
            @AttributeOverride(column = @Column(name = "some_nick_overriden"), name = "name")})
    EmbeddibleTable embeddibleTable;

    public FirstTable() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public EmbeddibleTable getEmbeddibleTable() {
        return embeddibleTable;
    }

    public void setEmbeddibleTable(EmbeddibleTable embeddibleTable) {
        this.embeddibleTable = embeddibleTable;
    }

    @Override
    public String toString() {
        return "FirstTable{" +
                "id=" + id +
                ", message='" + message + '\'' +
                '}';
    }
}
