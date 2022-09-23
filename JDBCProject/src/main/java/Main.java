import entities.Course;
import entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();
//        Transaction transaction = session.beginTransaction();
//        entities.Course course = session.get(entities.Course.class, 1);
//        System.out.println(course);

        Course course = session.get(Course.class, 2);
        List<Student> students = course.getStudents();
        students.forEach(System.out::println);
//        transaction.commit();

        session.close();
        sessionFactory.close();
    }
}