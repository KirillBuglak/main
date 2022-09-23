package Base;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * Must access the SAME object to see SYNCHRONIZATION
 * in this example it's only one RUNNABLE
 */
public class ReentrantLockAndSync {
    public static void main(String[] args) throws InterruptedException {
        var run = new MyRun("RUN MTHFCK");
        var t1 = new Thread(run,"T1");
        var t2 = new Thread(run,"T2 ");
        t1.start();
//        t1.join(); /**First meth for Sync*/
        t2.start();

    }
}
class MyRun implements Runnable{
    ReentrantLock lock = new ReentrantLock();
    String name;
    MyRun(String name){
        this.name = name;
    }
    @Override
    synchronized public void run() { /**synchronized is the second meth*/
//        lock.lock(); /**Third meth for sync*/
//        try {
            System.out.println(Thread.currentThread().getName() + " First ");
            System.out.println(Thread.currentThread().getName() + " Second ");
            System.out.println(Thread.currentThread().getName() + " Third ");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
            System.out.println(Thread.currentThread().getName() + " Forth ");
            System.out.println(Thread.currentThread().getName() + " Fifth ");
            System.out.println(Thread.currentThread().getName() + " Sixth ");
//        }
//        finally {
//            lock.unlock();
//        }
    }
}
