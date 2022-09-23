import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class MainAggregateFunction {
    public static void main(String[] args) {

        amount();
        maxID();
        averNum();
        sumNum();
        distinct();
    }

    private static void distinct() {
        Session session = HiberUtil.getSessionFactory().openSession();
        session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Long.class);
        Root<Someone> SORoot = criteriaQuery.from(Someone.class);
//        Path<Integer> sumPath = SORoot.get("someNumber");
        criteriaQuery.select(criteriaBuilder.countDistinct(SORoot));


        Query sessionQuery = session.createQuery(criteriaQuery);
        long singleResult = (long) sessionQuery.getSingleResult();
        session.getTransaction().commit();
        session.close();
//        HiberUtil.shutDown();

        System.out.println("Numbers of distinct people "+singleResult);
    }

    private static void sumNum() {
        Session session = HiberUtil.getSessionFactory().openSession();
        session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Integer.class);
        Root<Someone> SORoot = criteriaQuery.from(Someone.class);
        Path<Integer> sumPath = SORoot.get("someNumber");
        criteriaQuery.select(criteriaBuilder.sum(sumPath));


        Query sessionQuery = session.createQuery(criteriaQuery);
        int singleResult = (int) sessionQuery.getSingleResult();
        session.getTransaction().commit();
        session.close();
//        HiberUtil.shutDown();

        System.out.println("SUM of numbers "+singleResult);
    }

    private static void averNum() {
        Session session = HiberUtil.getSessionFactory().openSession();
        session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Double.class);
        Root<Someone> SORoot = criteriaQuery.from(Someone.class);
        Path<Integer> averPath = SORoot.get("someNumber");
        criteriaQuery.select(criteriaBuilder.avg(averPath));


        Query sessionQuery = session.createQuery(criteriaQuery);
        double singleResult = (double) sessionQuery.getSingleResult();
        session.getTransaction().commit();
        session.close();
//        HiberUtil.shutDown();

        System.out.println("AVERAGE "+singleResult);
    }

    static void amount(){
        Session session = HiberUtil.getSessionFactory().openSession();
        session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Long.class);
        Root<Someone> SORoot = criteriaQuery.from(Someone.class);
        criteriaQuery.select(criteriaBuilder.count(SORoot));

        Query sessionQuery = session.createQuery(criteriaQuery);
        Object singleResult = sessionQuery.getSingleResult();
        session.getTransaction().commit();
        session.close();
//        HiberUtil.shutDown();

        System.out.println("COUNT "+singleResult);
    }
    static void maxID(){
        Session session = HiberUtil.getSessionFactory().openSession();
        session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Integer.class);
        Root<Someone> SORoot = criteriaQuery.from(Someone.class);
        Path<Integer> idPath = SORoot.get("id");
        criteriaQuery.select(criteriaBuilder.max(idPath));


        Query sessionQuery = session.createQuery(criteriaQuery);
        int singleResult = (int) sessionQuery.getSingleResult();
        session.getTransaction().commit();
        session.close();
//        HiberUtil.shutDown();

        System.out.println("MAX "+singleResult);
    }
}