import entities.Subscription;
import keys.SubscKey;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main2 {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();

            SubscKey subscKey = new SubscKey();
            subscKey.setCourseId(12);
            subscKey.setStudentId(48);

        Subscription subscription = session.get(Subscription.class, subscKey);
        System.out.println(subscription.getDate());
        System.out.println(subscription.getStudent());
        System.out.println(subscription.getCourse());

        session.close();
        sessionFactory.close();
    }
}