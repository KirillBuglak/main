import org.hibernate.Session;
import otherTables.EmbeddibleTable;
import otherTables.FirstTable;

public class MainEmbed9_7_22 {
    public static void main(String[] args) {
        Session session = HiberUtil.getSessionFactory().openSession();
        session.beginTransaction();

        EmbeddibleTable embeddibleTable = new EmbeddibleTable();
        embeddibleTable.setName("Clark");
        embeddibleTable.setNumber(777);

        FirstTable firstTable = new FirstTable();
        firstTable.setMessage("Message has been created");
        firstTable.setEmbeddibleTable(embeddibleTable);

        session.persist(firstTable);

        session.getTransaction().commit();
        session.close();
        HiberUtil.shutDown();
    }
}
