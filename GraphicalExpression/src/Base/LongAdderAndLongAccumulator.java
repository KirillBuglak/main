package Base;

import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;

public class LongAdderAndLongAccumulator {
    public static LongAdder lad = new LongAdder();
    public static LongAccumulator lac = new LongAccumulator(Long::sum,0);
    public static void main(String[] args) throws InterruptedException {

        Runnable r = ()->LAD();
        Runnable r1 = ()->LAC();

        var t1 = new Thread(r);
        var t2 = new Thread(r);
        var t3 = new Thread(r);

        var t4 = new Thread(r1);
        var t5 = new Thread(r1);

        t1.start();
        t2.start();
        t3.start();

        t4.start();
        t5.start();

        Thread.sleep(10);

        System.out.println(lad.sum());
        System.out.println(lac.intValue());
        System.out.println(lac.get());

    }
    public static void LAD(){
        for (int i=0;i<100;++i)
            lad.increment();
//            lad.add(lad.intValue());
    }
    public static void LAC(){
        for (int i=0;i<10;i++)
            lac.accumulate(i);
    }
}