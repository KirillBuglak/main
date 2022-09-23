import entities.Course;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class Main3 {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.buildSessionFactory();
        Session session = sessionFactory.openSession();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Course> query = criteriaBuilder.createQuery(Course.class);
        Root<Course> root = query.from(Course.class);
        query.select(root).where(criteriaBuilder.greaterThanOrEqualTo(root.get("price"),100000))
                .orderBy(criteriaBuilder.desc(root.get("price")),criteriaBuilder.asc(root.get("name")));

        List<Course> resultList = session.createQuery(query).setMaxResults(7).getResultList();

             session.createQuery(query).getResultList().stream().limit(3)
                    .forEach(e -> System.out.println(e.getName() + " - " + e.getPrice()));

        resultList.forEach(e -> System.out.println(e.getName() + " - " + e.getPrice()));

        session.close();
        sessionFactory.close();
    }
}
