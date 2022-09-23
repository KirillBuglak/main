import java.util.concurrent.*;

public class Main4 {
    public static void main(String[] args) {

        callFuture();
        excuFuture();
    }

    private static void excuFuture() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<?> future = executorService.submit(() -> {
            String s = "yep";
            return s;
        });
        try {
            System.out.println(future.get());
            executorService.shutdown();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    private static void callFuture() {
        Callable callable = ()->{

            int i1 = 5;
            int i2 = 10;
            return Math.min(i1,i2);
        };

        FutureTask futureTask = new FutureTask<>(callable);

        new Thread(futureTask).start();
        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
