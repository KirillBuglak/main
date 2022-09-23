import DTO.ResultDTO;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class MainGroupAndHaving {
    public static void main(String[] args) {
        Session session = HiberUtil.getSessionFactory().openSession();
        session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Object[].class);
        Root root = criteriaQuery.from(Someone.class);

        criteriaQuery.multiselect(criteriaBuilder.count(root.get("name")),
                criteriaBuilder.sum(root.get("ID")),root.get("someNumber"));

        criteriaQuery.groupBy(root.get("someNumber"));
        criteriaQuery.having(criteriaBuilder.gt(root.get("someNumber"),1));

        Query sessionQuery = session.createQuery(criteriaQuery);
        List<Object[]> resultList = sessionQuery.getResultList();

        session.getTransaction().commit();
        session.close();
        HiberUtil.shutDown();
        for (Object[] o : resultList){
            long count = (long) o[0];
            int sum = (int) o[1];
            int someNumber = (int) o[2];

            System.out.println("count of peeople "+count+"\nsum of ID's "+sum+"\nsomeNumber "+someNumber+"\n");
        }
    }
}