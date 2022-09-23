import jakarta.persistence.*;

@Entity
@Table(name = "ANN")
public class AnotherOne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "NICK_NAME")
    String nick;

    public AnotherOne() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    @Override
    public String toString() {
        return "AnotherOne{" +
                "id=" + id +
                ", nick='" + nick + '\'' +
                '}';
    }
}
