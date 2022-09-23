import jakarta.persistence.criteria.*;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class MainParameter {
    public static void main(String[] args) {
        Session session = HiberUtil.getSessionFactory().openSession();
        session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Someone.class);
        Root someoneRoot = criteriaQuery.from(Someone.class);
        Path namePath = someoneRoot.get("name");

        ParameterExpression<String> nameParameter = criteriaBuilder.parameter(String.class);
        criteriaQuery.where(criteriaBuilder.equal(namePath,nameParameter));

        Query sessionQuery = session.createQuery(criteriaQuery);
        sessionQuery.setParameter(nameParameter,"WoMan");
        List<Someone> resultList = sessionQuery.getResultList();
        session.getTransaction().commit();
        session.close();
        HiberUtil.shutDown();
        for (Someone s : resultList)
            System.out.println(s);
    }
}
