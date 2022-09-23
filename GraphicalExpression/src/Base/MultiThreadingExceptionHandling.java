package Base;

import org.w3c.dom.css.Counter;

import javax.management.monitor.CounterMonitor;
import java.util.Locale;
import java.util.concurrent.locks.ReentrantLock;

public class MultiThreadingExceptionHandling {
    public static void main(String[] args) {
        try{
        var t1 = new Thread(()-> System.out.println("Wazap"),"*Thread #1*");
        var t2 = new Thread(()-> System.out.println("Yep"),"*Thread #2*");
        var t3 = new Thread(()->{System.out.println(1/0);},"*Thread #3*");
        t3.setUncaughtExceptionHandler((t,e)->
                System.err.println("Exception happened "+ t.getState()+ t.getName() + e.getMessage().toUpperCase(Locale.ROOT)));
            t1.setPriority(Thread.MIN_PRIORITY);
            t2.setPriority(2);
            t3.setPriority(3);
            System.out.printf("%s has %s priority+\n",t1.getName(),t1.getPriority());
            System.out.printf("%s has %s priority+\n",t2.getName(),t2.getPriority());
            System.out.printf("%s has %s priority+\n",t3.getName(),t3.getPriority());
            var t4 = new Thread(()->{throw new RuntimeException("FUCCCK");});
            t4.setName("*FOUR*");
        t4.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
            System.out.println(t4.getName()+t4.getPriority());}
        catch (Exception e) {System.out.println("Caught");}
    }
}
class RaceCond {
    public static void main(String[] args) throws InterruptedException {

        var t1 = new Thread(new Run("T1thread"),"T1");
        var t2 = new Thread(new Run("T2 thread"),"T2");
        t1.start();
        t2.start();
        Thread.sleep(100);
//        t1.join();
//        t2.join();
    }
}
class Run implements Runnable{
    String name;
    ReentrantLock lock = new ReentrantLock();

    Run(String name){
    this.name = name;
    }

    @Override
    synchronized public void run() {
//        lock.lock();
//        try{
        for (int i = 0;i<10;i++) {
            System.out.println(name+" First text " + i);
            System.out.println(name+" Second text " + i);
        }
//        }
//        finally {
//            lock.unlock();
//        }
    }
}