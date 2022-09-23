import org.hibernate.Session;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {

        Session session = HiberUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Something something1 = new Something();
        something1.setModel("model1");
        Something something2 = new Something();
        something2.setModel("model2");

        Someone someone = new Someone();
        someone.setName("Man");
        someone.getSomethings().add(something1);
        someone.getSomethings().add(something2);
        someone.setSomeNumber(777);

        session.persist(someone);

        AnotherOne anotherOne = new AnotherOne();
        anotherOne.setNick("NICK");

        something1.setSomeone(someone);
        something2.setSomeone(someone);

        session.persist(anotherOne);
        session.persist(something1);
        session.persist(something2);

        session.getTransaction().commit();
        session.close();

//        session = HiberUtil.getSessionFactory().openSession();
//        session.beginTransaction();
//
//        Someone someone1 = session.get(Someone.class,1);
//
//        session.getTransaction().commit();
//        session.close();
        HiberUtil.shutDown();
//
//        System.out.println(someone1.getName());

    }
}