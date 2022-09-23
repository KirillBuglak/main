import jakarta.persistence.Query;
import jakarta.persistence.criteria.*;
import org.hibernate.Session;


import java.util.List;

public class MainNamedQueriesAndCriteria {
    public static void main(String[] args) {

        Session session = HiberUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Query query = session.createNamedQuery("SOQuery",Someone.class);
        Query query1 = session.createNamedQuery("nativeSOQ",Someone.class);
        query.setParameter("param",1);
        query1.setParameter("param","Pop");
        List list = query.getResultList();
        List list1 = query1.getResultList();

/**CRITERIA*/
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        /**
         * Change @Class in @() to Employee to get @FULL_RAW from table
         * Change @Class in @() to String/int to get @ID 0r @name
         */
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Object[].class);
        Root<Someone> root = criteriaQuery.from(Someone.class);

        Path<Object> IDPath = root.get("ID");
        Path<Object> NamePath = root.get("name");


        /**PROCEED*/
//        criteriaQuery.select
//                        (root.get("name"))/**Change @Field here*/
//                .where(criteriaBuilder.gt(root.get("ID"),1));
//        criteriaQuery.select(criteriaBuilder.array(IDPath,NamePath))
//          criteriaQuery.multiselect(IDPath,NamePath)
//                .where(criteriaBuilder.gt(root.get("ID"),1));
        criteriaQuery.multiselect(IDPath,NamePath);


        criteriaQuery.distinct(true);
        criteriaQuery.orderBy(criteriaBuilder.asc(root.get("name")));
        criteriaQuery.groupBy(root.get("id"));


        Query query2 = session.createQuery(criteriaQuery);
        List<Object[]> list2 = query2.getResultList();

        session.getTransaction().commit();
        session.close();
        HiberUtil.shutDown();

        System.out.println(list);
        System.out.println(list1);
        System.out.println("Criteria: \n"+list2);
        for (Object[] r : list2) System.out.println(r[0]+" "+r[1]);
    }
}