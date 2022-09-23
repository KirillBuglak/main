import org.hibernate.Session;

public class CacheMain {
    public static void main(String[] args) {
        Session session = HiberUtil.getSessionFactory().openSession();
        session.beginTransaction();
//todo: try to find how to configure second level cache
        System.out.println("hey");


        session.getTransaction().commit();
        session.close();
        HiberUtil.shutDown();
    }
}