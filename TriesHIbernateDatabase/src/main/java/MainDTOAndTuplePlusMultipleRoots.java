import jakarta.persistence.Tuple;
import jakarta.persistence.criteria.*;
import org.hibernate.Session;

import org.hibernate.query.Query;

import java.util.List;

public class MainDTOAndTuplePlusMultipleRoots {
    public static void main(String[] args) {
        Session session = HiberUtil.getSessionFactory().openSession();
        session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
//        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(SomeOneDTO.class);
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Tuple.class);

        Root<Someone> root =criteriaQuery.from(Someone.class);
        Root<AnotherOne> root2 = criteriaQuery.from(AnotherOne.class);

        Path<Object> IDPath = root.get("ID");
        Path<Object> namePath = root.get("name");
        Path<Object> idPath = root2.get("id");
        Path<Object> nickPath = root2.get("nick");

        Predicate someoneRestr = criteriaBuilder.and(criteriaBuilder
                .equal(root.get("name"),"Zeit"),criteriaBuilder.isNotNull(root.get("ID")));
        Predicate anotherOneRestr = criteriaBuilder.and(criteriaBuilder
                .like(root2.<String>get("nick"),"%IC%"),criteriaBuilder.isNotNull(root2.get("id")));

//        criteriaQuery.select(criteriaBuilder.construct(SomeOneDTO.class,idPath,namePath));
//        criteriaQuery.multiselect(IDPath,namePath);
        criteriaQuery.multiselect(root,root2);
        criteriaQuery.where(criteriaBuilder.and(someoneRestr,anotherOneRestr));

        Query sessionQuery = session.createQuery(criteriaQuery);
        List<Tuple> list = sessionQuery.getResultList();
        session.getTransaction().commit();
        session.close();
        HiberUtil.shutDown();

        System.out.println(list);
        for (Tuple l : list) System.out.println(l.get(root).getName()+"\t"+l.get(root2));
    }
}
