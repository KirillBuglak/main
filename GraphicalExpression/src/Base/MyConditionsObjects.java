package Base;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyConditionsObjects {
    public static void main(String[] args) throws InterruptedException {
        var helper = new Helper("First try",3);

        var t1 = new Thread(()-> {
            helper.first();
            },"T1");

        var t2 = new Thread(()-> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                helper.second();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            helper.first();
        },"T2");

        t1.start();
        t2.start();
    }
}
class Helper{
    String name;
    static int n;
    ReentrantLock lock = new ReentrantLock();;
    Condition condition = lock.newCondition();
    Helper(String name, int n){
        this.name=name;
    }

    synchronized void first(){
//        lock.lock();
//        try {
            System.out.println("First thread has come that far "+Thread.currentThread().getName());
            while (n<5) {
/**@WAIT meth*/try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
//                condition.await();
            System.out.println("Second thread has helped mme out! "+Thread.currentThread().getName());
//        } catch (InterruptedException e) {
//            System.err.println("sheat");
//        } finally {
//            lock.unlock();
//        }
    }
    synchronized void second() throws InterruptedException {
//        lock.lock();
//        try{
        System.out.println("Second thread is going to do smth   "+Thread.currentThread().getName());
        this.n=6;
        Thread.sleep(1000);
        notifyAll();
//        condition.signalAll();
//        }
//        finally {
//            lock.unlock();
//        }
    }
}