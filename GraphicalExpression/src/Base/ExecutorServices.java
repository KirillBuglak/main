package Base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

public class ExecutorServices {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Callable<String> task1 = new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "First Task";
            }
        };
        Callable<String> task2 = new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(100
                );
                return "Second Task";
            }
        };
        List<Callable<String>> tasks = new ArrayList<>();
        tasks.add(task1);
        tasks.add(task2);
        var f1 = new FutureTask<String>(task1);
        var f2 = new FutureTask<String>(task2);
        List<FutureTask<String>> futures = new ArrayList<>();
        futures.add(f1);
        futures.add(f2);


        var executor = Executors.newCachedThreadPool();
        executor.submit(f1);
        executor.submit(f2);
        var executorservice = new ExecutorCompletionService<String>(executor);
        for(Callable<String> c : tasks) executorservice.submit(c);
//        for (int i=0;i<tasks.size();i++) executorservice.take().get();
        System.out.println(f1.get());
        System.out.println(f2.get());
        executor.shutdown();
    }
}
class Merge{
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Map<Integer,String> mao = new HashMap<>();
        mao.put(1, "Yess");
        mao.put(2, "Nope");
        mao.merge(1, "HEY", (x,y)->x+y+x.length());
        System.out.println(mao);

        Callable<String> task1 = new Callable<String>() {
        @Override
        public String call() throws Exception {
            return "First Task";
        }
    };
    Callable<String> task2 = new Callable<String>() {
        @Override
        public String call() throws Exception {
            Thread.sleep(100
            );
            return "Second Task";
        }
    };
    List<Future<String>> ress = new ArrayList<>();
    List<Callable<String>> tasks = new ArrayList<>();
        tasks.add(task1);
        tasks.add(task2);
        var executor = Executors.newCachedThreadPool();
        var service = new ExecutorCompletionService<String>(executor);
        for (Callable<String> t: tasks) {
            service.submit(t);
            ress.add(service.take());
        }
        for (Future<String> f: ress) System.out.println(f.get());
        executor.shutdown();
    }
}