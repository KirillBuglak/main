package Base;

import java.util.function.Supplier;

public class ThreadLocals {
    public static ThreadLocal<String> TL = ThreadLocal.withInitial(new Supplier<String>() {
        @Override
        public String get() {
            return "Some text "+Thread.currentThread().getName();
        }
    });
    public static void main(String[] args) {

        var t1 = new Thread(new Helperer(),"T1");
        var t2 = new Thread(new Helperer(),"T2");
        var t3 = new Thread(()-> System.out.println(TL.get()),"T3");

        t1.start();
        t2.start();
        t3.start();

    }
}
class Helperer implements Runnable{
    private java.lang.ThreadLocal<String> tl = new java.lang.ThreadLocal<>(){
      protected String initialValue(){
          return Thread.currentThread().getName()+" Some text";
      }
    };

    @Override
    public void run() {
        System.out.println(tl.get());
    }
}