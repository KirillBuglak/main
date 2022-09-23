import DTO.ResultDTO;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class MainForAndJoin {
    public static void main(String[] args) {
        Session session = HiberUtil.getSessionFactory().openSession();
        session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Object[].class);
        Root STroot = criteriaQuery.from(Something.class);
        Root SOroot = criteriaQuery.from(Someone.class);

        criteriaQuery.multiselect(STroot,SOroot);

        criteriaQuery.where(criteriaBuilder
                .equal(STroot.get("someone"),SOroot.get("ID")));

        Query sessionQuery = session.createQuery(criteriaQuery);
        List<Object[]> resultList = sessionQuery.getResultList();

        session.getTransaction().commit();
        session.close();
        HiberUtil.shutDown();
            for (Object[] obj : resultList){
//                System.out.println(obj[0]+"_"+obj[1]);
            Someone someone = (Someone) obj[1];
            Something something = (Something) obj[0];
                System.out.println(someone.getName()+" "+something.getModel());
            }
    }
}