import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class MainQueryObject {
    public static void main(String[] args) {

        int num = 10;
        String str = "1";
        String someName = "Po";

        Session session = HiberUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Query query = session.createQuery
                ("select name from Someone s where s.ID>:xx and s.name > :yy",Someone.class);
/**WTF*/query.setParameter("xx", Integer.parseInt(str));
/**WTF*/query.setParameter("yy", someName);
//        Query query = session.createQuery("select name from Someone s where s.ID>?1",Someone.class);
///**WTF*/query.setParameter(1, Integer.parseInt(str));

//        query.setFirstResult(1);
//        query.setMaxResults(3);
        List list = query.list();

//        int x = session.createQuery("select max(ID) from Someone",Someone.class)
//                .getSingleResult().getID();

        session.getTransaction().commit();
        session.close();
        HiberUtil.shutDown();

        System.out.println(list);
//        System.out.println(x);
    }
}