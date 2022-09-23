import org.hibernate.Session;

import java.util.Scanner;

public class MainMerge {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Session session = HiberUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Someone someone = session.get(Someone.class,1);

        session.getTransaction().commit();
        session.close();

        someone.setName(scanner.nextLine());

        session = HiberUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.merge(someone);

        session.getTransaction().commit();
        session.close();
        HiberUtil.shutDown();

        System.out.println(someone.getName());

    }
}