package Base;

import java.util.*;
import java.util.concurrent.*;

public class ConcrHashMap {
    public static void main(String[] args) throws InterruptedException {
        ConcurrentHashMap<Integer, String> ccHM = new ConcurrentHashMap<>();
            ccHM.put(1, "sf");
            ccHM.put(2, "DGDH");
        var t1 = new Thread(() -> {
            Iterator<Integer> iter = ccHM.keySet().iterator();
            while (iter.hasNext()) {

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int i = iter.next();
                System.out.println(i+"_"+ccHM.get(i));
            }
        });

        var t2 = new Thread(() -> {
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            ccHM.put(3,"HEY!");
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(ccHM);
    }
}

class Skiplistmap{
    public static void main(String[] args) throws InterruptedException {
        ConcurrentSkipListMap<Integer,String> sklm = new ConcurrentSkipListMap<>();
        sklm.put(1,"aaa");
        sklm.put(22,"bbbb");
        sklm.put(33,"ccc");
//        sklm.merge(1,"ASS",(x,y)->x.toUpperCase(Locale.ROOT)+y.toLowerCase(Locale.ROOT));
        sklm.merge(1,"ASS",String::concat);
        ConcurrentHashMap<Integer,String> cchm = new ConcurrentHashMap<>();
        cchm.put(1,"aaa");
        cchm.put(22,"bbbb");
        cchm.put(33,"ccc");
        Set<Integer> set = cchm.keySet(String.valueOf(1));
        set.remove(22);
        set.add(366);
    /***/String result = cchm.searchValues(1, e->e.length()>3?e:"Nope");
    /***/int res = cchm.searchKeys(1,e->e>22?e:999);
    /***/String search = cchm.search(1,(e,y)->e.toString().length()>1?y:"NO");
//        String foreach = cchm.forEach(1,
//                (x,y)->x+y.length(),System.out::println);
        System.out.println(result);
        System.out.println(res);
        System.out.println(search);
        System.out.println(set);

        var iter = sklm.keySet().iterator();
        var t1 = new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (iter.hasNext()) iter.next();
            iter.remove();
        });
        var t2 = new Thread(()->{
            sklm.forEach((e,j)->
                    System.out.println(e.intValue()+"***"+j.toUpperCase(Locale.ROOT)));
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(sklm);
    }
}
class Mycalandfut{
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        var future = new FutureTask<String>(new Callable<>(){
        @Override
        public String call() throws Exception {
            Thread.sleep(500);
            return "FINALLY";
        }
    }  );
        var t1 = new Thread(future);
        t1.start();
        System.out.println(future.get(600, TimeUnit.MILLISECONDS));
        var scheduledthing = new ScheduledThreadPoolExecutor(4);
        scheduledthing.scheduleAtFixedRate(()->
                System.out.println("HEY YOU!"),1000,500, TimeUnit.MILLISECONDS);
        ExecutorService e1 = Executors.newCachedThreadPool();
        e1.submit(()-> System.out.println("Cashed thing"));
        e1.shutdown();
        scheduledthing.shutdown();
    }
}