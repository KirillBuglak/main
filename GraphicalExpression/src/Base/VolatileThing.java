package Base;

import java.util.concurrent.atomic.AtomicInteger;

public class VolatileThing {
    public static void main(String[] args) throws InterruptedException {
        var yep = new Yep();
        var t1 = new Thread(()-> {
            yep.write();});
        var t2 = new Thread(()-> yep.read());
        t1.start();
        t2.start();
    }
}

class Yep{
    volatile static int i;
    void write(){
        while (i<5){
            ++i;
            System.out.println("I has gone to "+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }
    void read(){
        int x = i;
        while (i<5)
            if (x!=i){
            System.out.println("yep it's "+i);
            x=i;}
    }
}
class Atomic{
    public static AtomicInteger x = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {
        Runnable r = ()->{
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            new Atomic().someMETH();};
        var t1 = new Thread(r);
        var t2 = new Thread(r);
        var t3 = new Thread(r);
        t1.start();
        t2.start();
        t3.start();
        Thread.sleep(1000);
        System.out.println("X= "+x);
    }
    public void someMETH(){
        for (int i=0;i<10;i++)x.getAndIncrement();
    }
}