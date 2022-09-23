import entities.Course;
import entities.LinkedPurchaseList;
import entities.PurchaseList;
import entities.Student;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import keys.LinkPurKey;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.ArrayList;
import java.util.List;

public class Practice4 {
    static List<LinkPurKey> llist = new ArrayList<>();

    public static void main(String[] args) {

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.buildSessionFactory();
        Session session = sessionFactory.openSession();

        CriteriaBuilder cb = session.getCriteriaBuilder();

        CriteriaQuery<PurchaseList> queryPur = cb.createQuery(PurchaseList.class);
        Root<PurchaseList> rootPur = queryPur.from(PurchaseList.class);
        queryPur.select(rootPur);
        List<PurchaseList> purList = session.createQuery(queryPur).getResultList();

        CriteriaQuery<Student> queryStud = cb.createQuery(Student.class);
        Root<Student> rootStud = queryStud.from(Student.class);
        queryStud.select(rootStud);
        List<Student> studList = session.createQuery(queryStud).getResultList();

        CriteriaQuery<Course> queryCour = cb.createQuery(Course.class);
        Root<Course> rootCour = queryCour.from(Course.class);
        queryCour.select(rootCour);
        List<Course> courList = session.createQuery(queryCour).getResultList();

        purList.forEach(e -> {
            LinkPurKey linkPurKey = new LinkPurKey();

            studList.stream().filter(f -> f.getName().equals(e.getStudentName()))
                    .forEach(f -> linkPurKey.setStudentId(f.getId()));
            courList.stream().filter(f -> f.getName().equals(e.getCourseName()))
                    .forEach(f -> linkPurKey.setCourseId(f.getId()));

            llist.add(linkPurKey);
        });

        llist.forEach(e -> {
            Transaction transaction = session.beginTransaction();

            LinkedPurchaseList list = new LinkedPurchaseList();
            LinkPurKey key = new LinkPurKey();
            key.setStudentId(e.getStudentId());
            key.setCourseId(e.getCourseId());
            list.setId(key);

            session.persist(list);
            transaction.commit();
        });

        session.close();
        sessionFactory.close();
    }
}