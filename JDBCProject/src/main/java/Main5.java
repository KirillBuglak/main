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

public class Main5 {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.buildSessionFactory();
        Session session = sessionFactory.openSession();

        session.createNativeQuery("create table table1(id int auto_inerement, name varchar(50), primary key (id))");

//        CriteriaBuilder cb = session.getCriteriaBuilder();
//
//        CriteriaQuery<entities.LinkedPurchaseList> queryPur = cb.createQuery(entities.LinkedPurchaseList.class);
//        Root<entities.LinkedPurchaseList> rootPur = queryPur.from(entities.LinkedPurchaseList.class);
//        queryPur.select(rootPur);
//        List<entities.LinkedPurchaseList> purList = session.createQuery(queryPur).getResultList();
        session.close();
        sessionFactory.close();
    }
}
