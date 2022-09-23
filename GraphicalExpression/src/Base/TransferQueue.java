package Base;

import java.util.concurrent.LinkedTransferQueue;
import java.util.function.Consumer;

public class TransferQueue {
    public static void main(String[] args) throws InterruptedException {
        var tranQ = new LinkedTransferQueue<String>();

        tranQ.add("Head");
        var t1 = new Thread(()->{

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tranQ.add("Head");
            tranQ.add("ASS");
//            try {
//                tranQ.transfer("Head");
//                tranQ.transfer("ASS");
//            } catch (InterruptedException e) {
//                System.err.println("No such an element");}
        }
        );
        t1.start();
        var t2 = new Thread(()->{
            try {
                System.out.println("We've got it - "+tranQ.take()+" "+Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        var t3 = new Thread(()->{
            try {
                Thread.sleep(100);
                System.out.println("We've got it - "+tranQ.take()+" "+Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
    }
}
class MyCons implements Consumer {

    @Override
    public void accept(Object o) {
        System.out.println("this is"+o);
    }
}