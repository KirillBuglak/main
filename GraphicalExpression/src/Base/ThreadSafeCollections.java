package Base;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ThreadSafeCollections {
    public static void main(String[] args) throws InterruptedException {
//        List list1 = new ArrayList<Integer>();
        List list1 = new CopyOnWriteArrayList<>();
        list1.add(25);
        list1.add(35);
        list1.add(58);
        list1.add(169);
        list1.add(47);
        System.out.println(list1);

        var t11 = new Thread(()->{
            var iterator = list1.iterator();
           while (iterator.hasNext())
           {
               try {
                   Thread.sleep(100);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               System.out.println(iterator.next());
           }
        });

        var t12 = new Thread(()->{
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list1.remove(2);
            list1.add(2,777);
        });

//        t1.start();
//        t2.start();
//        t1.join();
//        t2.join();
        t11.start();
        t12.start();
        t11.join();
        t12.join();
//        Thread.sleep(1000);
        System.out.println(list1);
    }
}