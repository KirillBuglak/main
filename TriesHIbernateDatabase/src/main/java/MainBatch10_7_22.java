import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class MainBatch10_7_22 {
    public static void main(String[] args) {
        Session session = HiberUtil.getSessionFactory().openSession();
        session.beginTransaction();

        for (int i = 0; i < 9; ++i) {
            Someone someone = new Someone();
            someone.setName("Father");
            someone.setSomeNumber(10101);
            session.persist(someone);
        }

        session.getTransaction().commit();
        session.close();
        HiberUtil.shutDown();
    }
}
