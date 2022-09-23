import buslogic.HiberUtil;
import entities.Seller;
import org.hibernate.Session;

public class TestMain2 {
    public static void main(String[] args) {
        Session session = HiberUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Seller sellerFromSession = session.get(Seller.class,1);

        session.remove(sellerFromSession);

//        session.remove(truckFromSession);

        session.getTransaction().commit();
        session.close();
        HiberUtil.shutDown();

//        System.out.println(sellerFromSession.getSellerName());
   }
}
