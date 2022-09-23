import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class MainJoinFetchQuery {
    public static void main(String[] args) {
        Session session = HiberUtil.getSessionFactory().openSession();
        session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Something.class);

//        Root SOroot = criteriaQuery.from(Someone.class);
//        Root AOroot = criteriaQuery.from(AnotherOne.class);
        Root STroot = criteriaQuery.from(Something.class);
//        STroot.join("someone");
        STroot.fetch("someone");

        criteriaQuery.where(criteriaBuilder.isNotNull(STroot.get("model")));

        Query sessionQuery = session.createQuery(criteriaQuery);
        List<Something> resultList = sessionQuery.getResultList();

        session.getTransaction().commit();
        session.close();
        HiberUtil.shutDown();

        for (Something s : resultList) System.out.println(s.getNumber()+" "
        +s.getModel()+" "+s.getSomeone().getName());

    }
}
