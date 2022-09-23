import DTO.ResultDTO;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class MainAggregFuncToDTO {
    public static void main(String[] args) {

        Session session = HiberUtil.getSessionFactory().openSession();
        session.beginTransaction();

        CriteriaBuilder
                criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(ResultDTO.class);
        Root root = criteriaQuery.from(Someone.class);

        Expression<Integer> sumNum = criteriaBuilder.sum(root.get("someNumber"));
        Expression<Long> distinct = criteriaBuilder.countDistinct(root);
        Expression<Double> averNum = criteriaBuilder.avg(root.get("someNumber"));
        Expression<Long> amount = criteriaBuilder.count(root);
        Expression<Integer> maxID = criteriaBuilder.max(root.get("id"));

        criteriaQuery.select(criteriaBuilder.construct(ResultDTO.class,
               amount,maxID,averNum,sumNum,distinct));


        Query sessionQuery = session.createQuery(criteriaQuery);
        ResultDTO singleResult = (ResultDTO) sessionQuery.getSingleResult();
        session.getTransaction().commit();
        session.close();
        HiberUtil.shutDown();
        System.out.println(singleResult);
    }
}