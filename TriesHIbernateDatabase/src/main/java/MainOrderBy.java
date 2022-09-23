import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class MainOrderBy {
    public static void main(String[] args) {
        Session session = HiberUtil.getSessionFactory().openSession();
        session.beginTransaction();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(Someone.class);
        Root root = cq.from(Someone.class);

        cq.select(root);
        cq.orderBy(cb.asc(root.get("name")));

        Query sessionQuery = session.createQuery(cq);
        List<Someone> resultList = sessionQuery.getResultList();
        session.getTransaction().commit();
        session.close();
        HiberUtil.shutDown();
        for (Someone s : resultList)
            System.out.println(s.getName()+" "+s.getSomeNumber());



    }
}
