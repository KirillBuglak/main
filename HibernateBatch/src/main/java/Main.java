import org.hibernate.Session;

public class Main {
    public static void main(String[] args) {
        Session session = HiberUtil.getSessionFactory().openSession();
        session.beginTransaction();

        long start = System.currentTimeMillis();
//        for (int i = 0; i < 1000; ++i) {
//            Table_1 table_1 = new Table_1();
//            table_1.setName("Mark "+i);
//
//            session.persist(table_1);
//        }
        for (int i = 0;i<1000;++i){
            Table_1 table_1 = (Table_1) session.get(Table_1.class,20302+i);
            table_1.setName("Mark  "+i);
        }


        session.getTransaction().commit();
        session.close();
        HiberUtil.shutDown();

        long finish = System.currentTimeMillis();
        System.err.println(finish-start);

    }
}
