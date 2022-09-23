package Base;

import java.util.Date;
import java.util.Locale;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class RecTask {
    public static CompletableFuture<String> dostuff(String x){
        return CompletableFuture.supplyAsync(()->"STUFF"+x);
    }
    public static void main(String[] args) {
        var exxe = new ForkJoinPool(4);
        String rt = "HEY";
        var compFut = new CompletableFuture<>();
        var compFut2 = new CompletableFuture<>();
        dostuff(rt);

    compFut.supplyAsync(()->"GREGOR").thenCompose(t->CompletableFuture.supplyAsync(()->"hey yoyu "+t)).
        thenCompose(t->dostuff(t)).
            thenApply(x->x.concat(rt.toLowerCase(Locale.ROOT))).thenApply(x->x+x.hashCode()).
                thenAcceptAsync(System.out::println,exxe);

        var CF = new CompletableFuture<>();
        CF.supplyAsync(()-> 31L).thenCombine(CompletableFuture.supplyAsync(()->"YOEP"),(x,y)->x.toString()+y)
            .thenApply(x->x+101)
                .thenAccept(System.out::println)
        ;
        var execu = Executors.newCachedThreadPool();
//        execu.submit(CF);

        System.out.println(new Date());
        long l=0;
        for (int x = 0;x<2000000000;++x) l+=x;
        System.out.println(l);
        System.out.println(new Date());

        System.out.println("__________________");

        System.out.println(new Date());
        long xxx = 2000000000;
        int numProcess = Runtime.getRuntime().availableProcessors();
        var wrec = new WRECK(0, xxx);
        var pool = new ForkJoinPool(numProcess);

        pool.invoke(wrec);
//        System.out.println(wrec.join());
        System.out.println(pool.invoke(wrec));
        System.out.println(new Date());

    }

}
class WRECK extends RecursiveTask<Integer> {
    long xxx = 1000000000;
    int numProcess = Runtime.getRuntime().availableProcessors();

    long from;
    long to;
    WRECK(long from, long to) {
        this.from = from;
        this.to = to;
    }

    @Override
    protected Integer compute() {
        if (to-from <= xxx/numProcess) {
            int yyy = 0;
            for (int x = 0;x<to;++x) {
                yyy+=x;
            }
            return yyy;
        } else {
            long middle = (to+from)/2;
            var r1 = new WRECK(from, middle);
            var r2 = new WRECK(middle, to);
            r1.fork();
            r2.fork();
//            invokeAll(r1,r2);

            return r1.join()+r2.join();
        }
    }
}