package Base;

import java.util.Deque;
import java.util.PriorityQueue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class BlockingQue {
    public static void main(String[] args) throws InterruptedException {

/**        var q1 = new PriorityQueue<String>(3);*/
        var q1 = new LinkedBlockingDeque<>();
//        var q1 = new ArrayBlockingQueue<String>(3);
        var delayQue = new DelayQueue<>();



        var t1 = new Thread(()->{
//            try {Thread.sleep(500);} catch (InterruptedException e) {e.printStackTrace();}
            try {q1.take();} catch (InterruptedException e) {
                e.printStackTrace();
            }});

        var t2 = new Thread(()->{
            try {Thread.sleep(100);} catch (InterruptedException e) {e.printStackTrace();}
            try {q1.put("MARRY");} catch (InterruptedException e) {
                e.printStackTrace();
            }});

        var t3 = new Thread(()->{
            try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
            q1.add("SAM");
            q1.add("DREW");
            q1.add("ERL");
        });


//        t2.start();
        t1.start();
        t3.start();

//        t2.join();
        t1.join();
        t3.join();

        System.out.println(q1);
    }
}